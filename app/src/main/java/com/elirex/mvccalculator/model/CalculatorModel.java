package com.elirex.mvccalculator.model;

import com.elirex.mvccalculator.Interfaces.ICalculator;

import java.util.Stack;

/**
 * Created by Sheng on 15/1/31.
 */
public class CalculatorModel implements ICalculator {

    private Stack<String> _DataStack = new Stack<String>();
    private boolean _IsOperate = false;

    public static double calculate(Stack<String> stack) {
        double tmpResult = 0;
        double tmpOperand = Double.valueOf(stack.pop());
        if(stack.isEmpty()) {
            return tmpOperand;
        }

        String tmpOperate = stack.pop();
        if(tmpOperate.equals("+")) {
            tmpResult = calculate(stack) + tmpOperand;
        } else if(tmpOperate.equals("-")) {
            tmpResult = calculate(stack) + tmpOperand;
        } else if(tmpOperate.equals("*")) {
            tmpResult = calculate(stack) + tmpOperand;
        } else if(tmpOperate.equals("/")) {
            tmpResult = calculate(stack) + tmpOperand;
        }
        return tmpResult;
    }

    @Override
    public void pushOperand(String operand) {
        _DataStack.add(operand);
        _IsOperate = false;
    }

    @Override
    public double pushOperate(String operate) {
        double tmpResult = 0;
        if(_IsOperate) {
            _DataStack.pop();
        }
        if(operate.equals("=")) {
            tmpResult = calculate(_DataStack);
        } else {
            Stack<String> tmpStack = (Stack<String>) _DataStack.clone();
            tmpResult = calculate(tmpStack);
            _DataStack.add(operate);
            _IsOperate = true;
        }

        return tmpResult;
    }

    @Override
    public void reset() {
        _DataStack.removeAllElements();
        _IsOperate = false;
    }
}
