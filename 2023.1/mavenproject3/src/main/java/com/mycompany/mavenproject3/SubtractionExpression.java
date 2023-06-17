package com.mycompany.mavenproject3;

public class SubtractionExpression extends Expression {
    private Expression leftOperand;
    private Expression rightOperand;
    
    public SubtractionExpression(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }
    
    public int interpret() {
        return leftOperand.interpret() - rightOperand.interpret();
    }
}