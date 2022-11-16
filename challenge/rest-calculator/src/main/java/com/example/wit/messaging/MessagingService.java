package com.example.wit.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
public class MessagingService{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper mapper;

    public CalcMessage send (CalcMessage msg) throws IOException {

        Message request = MessageBuilder
                .withBody(mapper.writeValueAsString(msg).getBytes())
                .build();

        Message response = rabbitTemplate
                .sendAndReceive(
                        MessagingConfig.EXCHANGE,
                        MessagingConfig.QUEUE1,
                        request
                );

        System.out.println(response + "debugrestservice");

        return mapper.readValue(response.getBody(), CalcMessage.class);

    }


}
