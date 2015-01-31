package com.elirex.mvccalculator.view;

import android.app.Activity;
import android.widget.TextView;

import com.elirex.mvccalculator.R;

/**
 * Created by Sheng on 15/1/31.
 */
public class CalculatorOutputView {

    private TextView mTVOutputText;

    public CalculatorOutputView(Activity activity) {
        mTVOutputText = (TextView) activity.findViewById(R.id.tv_OutputText);
    }

    public void outputData(String str) {
        mTVOutputText.setText(str);
    }

}
