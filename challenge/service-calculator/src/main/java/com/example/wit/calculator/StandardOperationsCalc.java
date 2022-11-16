package com.example.wit.calculator;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface StandardOperationsCalc {
    BigDecimal sum (BigDecimal a, BigDecimal b);
    BigDecimal subtraction (BigDecimal a, BigDecimal b);
    BigDecimal division (BigDecimal a, BigDecimal b);
    BigDecimal multiplication (BigDecimal a, BigDecimal b);

}
