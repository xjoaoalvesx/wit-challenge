package com.example.wit.handlers;

import com.example.wit.calculator.Calculator;
import com.example.wit.messaging.CalcMessage;
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
        switch (calcmessage.getOperation().toLowerCase()) {
            case "sum":
                return sum(calcmessage);
            case "subtraction":
                return subtraction(calcmessage);
            case "division":
                return division(calcmessage);
            case "multiplication":
                return multiplication(calcmessage);
            default:
                return "null";
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
