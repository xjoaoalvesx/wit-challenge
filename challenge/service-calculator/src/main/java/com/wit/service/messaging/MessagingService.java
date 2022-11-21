package com.wit.service.messaging;

import com.wit.lib.CalcMessage;
import com.wit.lib.QueueType;
import com.wit.service.handlers.CalcHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MessagingService {

    private final RabbitTemplate template;
    private final CalcHandler calcHandler;

    private MessagingService(RabbitTemplate template, CalcHandler calcHandler) {
        this.template = template;
        this.calcHandler = calcHandler;
    }

    @RabbitListener(queues = QueueType.QUEUE1)
    public void receiveAndRespond (Message request) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        CalcMessage calculation = mapper.readValue(request.getBody(), CalcMessage.class);
        calculation.setResult(calcHandler.calculate(calculation));

        final String correlationId = request.getMessageProperties().getCorrelationId();

        Message response = MessageBuilder
                .withBody(mapper.writeValueAsString(calculation).getBytes())
                .setCorrelationId(correlationId)
                .build();

        CorrelationData correlationData = new CorrelationData(correlationId);
        template.send(
                MessagingConfig.EXCHANGE,
                QueueType.QUEUE2,
                response,
                correlationData);
    }

}
