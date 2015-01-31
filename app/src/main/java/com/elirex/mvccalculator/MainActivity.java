package com.elirex.mvccalculator;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.elirex.mvccalculator.model.CalculatorModel;
import com.elirex.mvccalculator.view.CalculatorInputView;
import com.elirex.mvccalculator.view.CalculatorOutputView;
import com.elirex.mvccalculator.view.CalculatorInputView.InputHappend;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements InputHappend {

    private static final String LOG_TAG = "Calculator";

    private CalculatorInputView _CInputView;
    private CalculatorOutputView _COutputView;
    private CalculatorModel _CModel;

    private String _Number = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);

        _CInputView = new CalculatorInputView(this,this);
        _COutputView = new CalculatorOutputView(this);
        _CModel = new CalculatorModel();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void operandIn(String operand) {
        Log.d(LOG_TAG, operand);
        _Number = _Number.equals("0") ? operand : _Number + operand;
        _COutputView.outputData(_Number);
    }

    @Override
    public void operateIn(String operate) {
        Log.d(LOG_TAG, operate);
        if(operate.equalsIgnoreCase("C")) {
            _CModel.reset();
            _Number = "0";
            _COutputView.outputData(_Number);
            return;
        }
        if(!_Number.equals("0"))
            _CModel.pushOperand(_Number);
        double tmpResult = _CModel.pushOperate(operate);
        if(tmpResult % 1d == 0d) {
            int tmp = Double.valueOf(tmpResult).intValue();
            _COutputView.outputData(String.valueOf(tmp));
        } else {
            _COutputView.outputData(String.valueOf(tmpResult));
        }
        _Number = "0";
    }
}
