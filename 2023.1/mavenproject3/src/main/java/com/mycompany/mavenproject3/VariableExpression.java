package com.mycompany.mavenproject3;

import java.util.Map;

public class VariableExpression extends Expression {
    private String variableName;
    private Map<String, Integer> attributes;
    
    public VariableExpression(String variableName, Map<String, Integer> attributes) {
        this.variableName = variableName;
        this.attributes = attributes;
    }
    
    public int interpret() {
        return attributes.get(variableName);
    }
}
