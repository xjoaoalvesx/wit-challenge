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
                return String.valueOf(calculator.sum(calcmessage.getA(), calcmessage.getB()));
            case "subtraction":
                return String.valueOf(calculator.subtraction(calcmessage.getA(), calcmessage.getB()));
            case "division":
                return String.valueOf(calculator.division(calcmessage.getA(), calcmessage.getB()));
            case "multiplication":
                return String.valueOf(calculator.multiplication(calcmessage.getA(), calcmessage.getB()));
            default:
                return null;
        }
    }

    public String sum (CalcMessage calcmessage) {
        return null;
    }

    public String subtraction (CalcMessage calcmessage) {
        return null;
    }

    public String division (CalcMessage calcmessage) {
        return null;
    }

    public String multiplicaition (CalcMessage calcmessage) {
        return null;
    }
}
