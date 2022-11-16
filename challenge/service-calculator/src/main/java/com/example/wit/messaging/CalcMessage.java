package com.example.wit.messaging;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = CalcMessage.class)
public class CalcMessage implements Serializable {

    private String operation;
    private BigDecimal a;
    private BigDecimal b;
    private String result;

    public CalcMessage(String operation, BigDecimal a, BigDecimal b) {
        this.operation = operation;
        this.a = a;
        this.b = b;
    }

    public CalcMessage () {}

    public String getOperation() {
        return operation;
    }

    public BigDecimal getA() {
        return a;
    }

    public BigDecimal getB() {
        return b;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
