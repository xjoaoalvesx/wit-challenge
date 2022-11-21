package com.wit.service.handlers;

import com.wit.service.calculator.Calculator;
import com.wit.lib.CalcMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalcHandler {

    private final Calculator calculator;

    @Autowired
    public CalcHandler (Calculator calculator) {
        this.calculator = calculator;
    }

    public String calculate (CalcMessage calcmessage) {
        switch (calcmessage.getOperation()) {
            case SUM:
                return sum(calcmessage);
            case SUBTRACTION:
                return subtraction(calcmessage);
            case DIVISION:
                return division(calcmessage);
            case MULTIPLICATION:
                return multiplication(calcmessage);
            default:
                return null;
        }
    }

    public String sum (CalcMessage calcmessage) {
        return String.valueOf(calculator.sum(calcmessage.getA(), calcmessage.getB()));
    }

    public String subtraction (CalcMessage calcmessage) {
        return String.valueOf(calculator.subtraction(calcmessage.getA(), calcmessage.getB()));
    }

    public String division (CalcMessage calcmessage) {
        return String.valueOf(calculator.division(calcmessage.getA(), calcmessage.getB()));
    }

    public String multiplication (CalcMessage calcmessage) {
        return String.valueOf(calculator.multiplication(calcmessage.getA(), calcmessage.getB()));
    }

}
