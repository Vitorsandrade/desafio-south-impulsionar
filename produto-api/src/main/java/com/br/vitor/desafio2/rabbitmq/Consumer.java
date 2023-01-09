package com.br.vitor.desafio2.rabbitmq;

import com.br.vitor.desafio2.entity.Product;
import com.br.vitor.desafio2.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;


@Service
@Slf4j
public class Consumer {

    @Autowired
    ProductRepository repository;
    @Autowired
    ObjectMapper mapper;

    @RabbitListener(queues = RabbitMqConfig.queue)
    public void productConsumer(Message<String> payload) throws IOException {
        Product product = mapper.readValue(payload.getPayload(),Product.class);

        Object message = payload.getHeaders().get("EVENT");
        log.info("Receive Message " + message);

        switch (Objects.requireNonNull(message).toString()) {
            case "PRODUCT_CHANGED":
                repository.save(product);
                log.info(product.getName() + " product amount updated to: " + product.getAmount());
        }
    }
}
