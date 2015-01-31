package com.elirex.mvccalculator;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.elirex.mvccalculator.view.CalculatorInputView;
import com.elirex.mvccalculator.view.CalculatorOutputView;
import com.elirex.mvccalculator.view.CalculatorInputView.InputHappend;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements InputHappend {

    private CalculatorInputView _CIV;
    private CalculatorOutputView _COV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);

        _CIV = new CalculatorInputView(this,this);
        _COV = new CalculatorOutputView(this);

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
        _COV.outputData(operand);
    }

    @Override
    public void operateIn(String operate) {
        _COV.outputData(operate);
    }
}
