package com.wit.service.messaging;

import com.wit.lib.QueueType;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    public static final String EXCHANGE = "EXCHANGE";

    @Bean
    Queue receiveQueue () {
        return new Queue(QueueType.QUEUE1);
    }

    @Bean
    Queue responseQueue () {
        return new Queue(QueueType.QUEUE2);
    }

    @Bean
    TopicExchange exchange () {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    Binding receiveBinding () {
        return BindingBuilder.bind(receiveQueue()).to(exchange()).with(QueueType.QUEUE1);
    }

    @Bean
    Binding responseBinding () {
        return BindingBuilder.bind(responseQueue()).to(exchange()).with(QueueType.QUEUE2);
    }
}
