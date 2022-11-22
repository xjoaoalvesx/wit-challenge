package com.wit.rest.controller;

import com.wit.lib.CalcMessage;
import com.wit.lib.OperationType;
import com.wit.rest.messaging.MessagingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
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
    private static final Logger logger = LoggerFactory.getLogger(RestCalcController.class);
    public RestCalcController(MessagingService service) {
        this.service = service;
    }

    @GetMapping(
            value="/sum",
            produces="application/json"
    )
    public ResponseEntity<Object> sum(@RequestParam BigDecimal a, @RequestParam BigDecimal b) throws IOException {
        final CalcMessage msg = new CalcMessage(OperationType.SUM, a, b, MDC.get("unique.id"));
        final CalcMessage result = service.send(msg);
        return getResponse(result);
    }

    @GetMapping(
            value="/subtraction",
            produces="application/json"
    )
    public ResponseEntity<Object> subtraction(@RequestParam BigDecimal a, @RequestParam BigDecimal b) throws IOException {
        final CalcMessage msg = new CalcMessage(OperationType.SUBTRACTION, a, b, MDC.get("unique.id"));
        final CalcMessage result = service.send(msg);
        return getResponse(result);
    }

    @GetMapping(
            value="/division",
            produces="application/json"
    )
    public ResponseEntity<Object> division(@RequestParam BigDecimal a, @RequestParam BigDecimal b) throws IOException {
        final CalcMessage msg = new CalcMessage(OperationType.DIVISION, a, b, MDC.get("unique.id"));
        final CalcMessage result = service.send(msg);
        return getResponse(result);
    }

    @GetMapping(
            value="/multiplication",
            produces="application/json"
    )
    public ResponseEntity<Object> multiplication(@RequestParam BigDecimal a, @RequestParam BigDecimal b) throws IOException {
        final CalcMessage msg = new CalcMessage(OperationType.MULTIPLICATION, a, b, MDC.get("unique.id"));
        final CalcMessage result = service.send(msg);
        return getResponse(result);
    }

    private ResponseEntity<Object> getResponse (CalcMessage msg) {
        return ResponseEntity.ok().body(
                Map.of("result", msg.getResult())
        );
    }
}