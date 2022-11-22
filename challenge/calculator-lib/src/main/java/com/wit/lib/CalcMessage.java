package com.wit.lib;

import java.io.Serializable;
import java.math.BigDecimal;

public class CalcMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    private OperationType operation;
    private BigDecimal a;
    private BigDecimal b;
    private String result;
    private String identifier;

    public CalcMessage(OperationType operation, BigDecimal a, BigDecimal b, String identifier) {
        this.operation = operation;
        this.a = a;
        this.b = b;
        this.identifier = identifier;
    }

    public CalcMessage() {}

    public OperationType getOperation () {
        return operation;
    }

    public void setOperation(OperationType operation) {
        this.operation = operation;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public void setB(BigDecimal b) {
        this.b = b;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public BigDecimal getA () {
        return a;
    }

    public BigDecimal getB() {
        return b;
    }

    public String getResult () {
        return result;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "CalcMessage{" +
                "operation=" + operation +
                ", a=" + a +
                ", b=" + b +
                ", result='" + result + '\'' +
                '}';
    }
}
