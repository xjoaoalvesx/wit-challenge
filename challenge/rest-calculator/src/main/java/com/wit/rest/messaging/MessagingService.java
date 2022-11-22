package com.wit.rest.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wit.lib.CalcMessage;
import com.wit.lib.QueueType;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

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
                        QueueType.EXCHANGE,
                        QueueType.QUEUE1,
                        request
                );

        if (response != null) {
            return mapper.readValue(response.getBody(), CalcMessage.class);
        }

        return null;

    }

}
