package com.example.wit.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    public static final String QUEUE1 = "queue1";
    public static final String QUEUE2 = "queue2";
    public static final String EXCHANGE = "Texchange";

    @Bean
    Queue receiveQueue () {
        return new Queue(QUEUE1);
    }

    @Bean
    Queue responseQueue () {
        return new Queue(QUEUE2);
    }

    @Bean
    TopicExchange exchange () {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    Binding receiveBinding () {
        return BindingBuilder.bind(receiveQueue()).to(exchange()).with(QUEUE1);
    }

    @Bean
    Binding responseBinding () {
        return BindingBuilder.bind(responseQueue()).to(exchange()).with(QUEUE2);
    }
}
