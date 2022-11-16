package com.example.wit.controller;

import com.example.wit.messaging.CalcMessage;
import com.example.wit.messaging.MessagingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@RestController
public class RestCalcController{

        private final MessagingService service;

    public RestCalcController(MessagingService service) {
        this.service = service;
    }

    @GetMapping(
            value="/sum",
            produces="application/json"
    )
    public ResponseEntity<Object> sum(@RequestParam BigDecimal a, @RequestParam BigDecimal b) throws IOException {
        final CalcMessage msg = new CalcMessage("sum", a, b);
        final CalcMessage result = service.send(msg);
        return getResponse(result);
    }

    @GetMapping(
            value="/subtraction",
            produces="application/json"
    )
    public ResponseEntity<Object> subtraction(@RequestParam BigDecimal a, @RequestParam BigDecimal b) throws IOException {
        final CalcMessage msg = new CalcMessage("subtraction", a, b);
        final CalcMessage result = service.send(msg);
        return getResponse(result);
    }

    @GetMapping(
            value="/division",
            produces="application/json"
    )
    public ResponseEntity<Object> division(@RequestParam BigDecimal a, @RequestParam BigDecimal b) throws IOException {
        final CalcMessage msg = new CalcMessage("division", a, b);
        final CalcMessage result = service.send(msg);
        return getResponse(result);
    }

    @GetMapping(
            value="/multiplication",
            produces="application/json"
    )
    public ResponseEntity<Object> multiplication(@RequestParam BigDecimal a, @RequestParam BigDecimal b) throws IOException {
        final CalcMessage msg = new CalcMessage("multiplication", a, b);
        final CalcMessage result = service.send(msg);
        return getResponse(result);
    }

    private ResponseEntity<Object> getResponse (CalcMessage msg) {
        return ResponseEntity.ok().body(
                Map.of("result", msg.getResult())
        );
    }
}