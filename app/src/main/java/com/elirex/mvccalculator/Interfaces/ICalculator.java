package com.elirex.mvccalculator.Interfaces;

/**
 * Created by Sheng on 15/1/31.
 */
public interface ICalculator {

    public void pushOperand(String operand);

    public double pushOperate(String operate);

    public void reset();

}
