package com.mycompany.calculadora_polonesa;

public class DivisionOperator implements Operator {
    @Override
    public void execute(Context context) {
        double operand2 = context.popValue();
        double operand1 = context.popValue();
        double result = operand1 / operand2;
        context.pushValue(result);
    }
}
