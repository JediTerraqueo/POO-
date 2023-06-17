package com.mycompany.mavenproject3;

public class ExpressionVisitor implements Visitor {
    public int visitAdditionExpression(AdditionExpression expression) {
        return expression.interpret();
    }
    
    public int visitSubtractionExpression(SubtractionExpression expression) {
        return expression.interpret();
    }
    
    public int visitMultiplicationExpression(MultiplicationExpression expression) {
        return expression.interpret();
    }
    
    public int visitDivisionExpression(DivisionExpression expression) {
        return expression.interpret();
    }
}
