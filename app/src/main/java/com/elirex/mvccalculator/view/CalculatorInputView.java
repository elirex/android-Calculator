package com.elirex.mvccalculator.view;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.elirex.mvccalculator.R;

import java.util.ArrayList;

/**
 * Created by Sheng on 15/1/31.
 */
public class CalculatorInputView {

    private ArrayList<Button> mBTNOperands;
    private ArrayList<Button> mBTNOperates;
/*    private Button mBTNOperateAC, mBTNOperateAnswers, mBTNOperateAddition,
            mBTNOperateSign, mBTNOperatePercent, mBTNOperateDivision,
            mBTNOperateMultiplication, mBTNOperateSubtraction;*/

    private CalculatorInputView.InputHappend _Delagete;

    public CalculatorInputView(Activity activity, CalculatorInputView.InputHappend delegate) {
        _Delagete = delegate;
        mBTNOperands = new ArrayList<Button>();
        mBTNOperates = new ArrayList<Button>();
        setUIComponent(activity);
    }



    private void setUIComponent(Activity activity) {
        Resources tmpRes = activity.getResources();
        for(int i = 0; i < 10; i++) {
            int tmpOperandId = tmpRes.getIdentifier("btn_Operand" + i, "id", activity.getPackageName());
            Button tmpBTNOperand = (Button) activity.findViewById(tmpOperandId);
            mBTNOperands.add(tmpBTNOperand);
        }
        mBTNOperands.add((Button) activity.findViewById(R.id.btn_OperandDot));

        mBTNOperates.add((Button) activity.findViewById(R.id.btn_OperateAC));
        mBTNOperates.add((Button) activity.findViewById(R.id.btn_OperateSign));
        mBTNOperates.add((Button) activity.findViewById(R.id.btn_OperatePercent));
        mBTNOperates.add((Button) activity.findViewById(R.id.btn_OperateDivision));
        mBTNOperates.add((Button) activity.findViewById(R.id.btn_OperateMultiplication));
        mBTNOperates.add((Button) activity.findViewById(R.id.btn_OperateSubtraction));
        mBTNOperates.add((Button) activity.findViewById(R.id.btn_OperateAddition));
        mBTNOperates.add((Button) activity.findViewById(R.id.btn_OperateAnswers));

        for(Button btn : mBTNOperands) {
            btn.setOnClickListener(onClickOperand);
        }

        for(Button btn : mBTNOperates) {
            btn.setOnClickListener(onClickOperate);
        }

        /*
        mBTNOperateAC = (Button) activity.findViewById(R.id.btn_OperateAC);
        mBTNOperateSign = (Button) activity.findViewById(R.id.btn_OperateSign);
        mBTNOperatePercent = (Button) activity.findViewById(R.id.btn_OperatePercent);
        mBTNOperateDivision = (Button) activity.findViewById(R.id.btn_OperateDivision);
        mBTNOperateMultiplication = (Button) activity.findViewById(R.id.btn_OperateMultiplication);
        mBTNOperateSubtraction = (Button) activity.findViewById(R.id.btn_OperateSubtraction);
        mBTNOperateAddition = (Button) activity.findViewById(R.id.btn_OperateAddition);
        mBTNOperateAnswers = (Button) activity.findViewById(R.id.btn_OperateAnswers);
        */
    }

    private Button.OnClickListener onClickOperand = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button tmpClickBTN = (Button) v;
            String tmpText = tmpClickBTN.getText().toString();
            _Delagete.operandIn(tmpText);
        }
    };

    private Button.OnClickListener onClickOperate = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button tmpClickBTN = (Button) v;
            String tmpText = tmpClickBTN.getText().toString();
            _Delagete.operateIn(tmpText);
        }
    };

    public interface InputHappend {
        // When user input operand, notify which operand by input.
        public void operandIn(String operand);
        // When user input operate, notify which operate by input.
        public void operateIn(String operate);
    }

}
