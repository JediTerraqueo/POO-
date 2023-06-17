package com.mycompany.mavenproject3;

public interface Visitor {
    int visitAdditionExpression(AdditionExpression expression);
    int visitSubtractionExpression(SubtractionExpression expression);
    int visitMultiplicationExpression(MultiplicationExpression expression);
    int visitDivisionExpression(DivisionExpression expression);
}
