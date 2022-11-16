package com.example.wit.messaging;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
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
    RabbitTemplate rabbitTemplate (ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setReplyAddress(QUEUE2);
        template.setReplyTimeout(6000);
        return template;
    }

    @Bean
    SimpleMessageListenerContainer responseContainer (ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE2);
        container.setMessageListener(rabbitTemplate(connectionFactory));
        return container;
    }

}
