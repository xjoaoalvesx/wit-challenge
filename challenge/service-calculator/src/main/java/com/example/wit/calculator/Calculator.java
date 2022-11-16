package com.example.wit.calculator;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
public class Calculator implements StandardOperationsCalc{

    private final int precision = 2000;

    @Override
    public BigDecimal sum(BigDecimal a, BigDecimal b) {
        return a.add(b, new MathContext(precision, RoundingMode.UP));
    }

    @Override
    public BigDecimal subtraction(BigDecimal a, BigDecimal b) {
        return a.subtract(b, new MathContext(precision, RoundingMode.UP));
    }

    @Override
    public BigDecimal division(BigDecimal a, BigDecimal b) {
        return a.divide(b, new MathContext(precision, RoundingMode.UP));
    }

    @Override
    public BigDecimal multiplication(BigDecimal a, BigDecimal b) {
        return a.multiply(b, new MathContext(precision, RoundingMode.UP));
    }
}
