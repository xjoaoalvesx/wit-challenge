package com.wit.rest.messaging;

import com.wit.lib.QueueType;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {


    @Bean
    Queue receiveQueue () {
        return new Queue(QueueType.QUEUE1);
    }

    @Bean
    Queue responseQueue () {
        return new Queue(QueueType.QUEUE2);
    }

    @Bean
    RabbitTemplate rabbitTemplate (ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setReplyAddress(QueueType.QUEUE2);
        template.setReplyTimeout(6000);
        return template;
    }

    @Bean
    SimpleMessageListenerContainer responseContainer (ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QueueType.QUEUE2);
        container.setMessageListener(rabbitTemplate(connectionFactory));
        return container;
    }

}
