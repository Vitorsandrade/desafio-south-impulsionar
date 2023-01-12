package com.br.vitor.produtoApi.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String routingKey = "for_product_queue";
    public static final String exchange = "exchange_product";
    public static final String queue = "queue_product";

    @Bean
    public DirectExchange directExchange(){
        return ExchangeBuilder.directExchange(exchange).durable(true).build();
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(routingKey);
    }

    @Bean
    public Queue productQueue(){
        return QueueBuilder.durable(queue).build();
    }
}
