package com.br.vitor.produtoProducerApi.service;

import com.br.vitor.produtoProducerApi.configs.RabbitConfig;
import com.br.vitor.produtoProducerApi.dto.RequestProductDTO;
import com.br.vitor.produtoProducerApi.entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class ProductService {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    ObjectMapper mapper;

    @Value("${app.host}")
    private String host;


    public void sendMessageInsertProduct(RequestProductDTO requestDTO) {
        try {

            sendRabbitMessage(RabbitConfig.exchange, RabbitConfig.routingKey, requestDTO, "POST");

        } catch (NullPointerException e) {
            throw new RuntimeException(e.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void sendMessageDeleteProduct(Long id) {
        sendRabbitMessageId(RabbitConfig.exchange, RabbitConfig.routingKey, id, "DELETE");
    }

    public void sendMessageUpdateProduct(Long id, RequestProductDTO requestDTO) {
        requestDTO.setId(id);
        try {

            sendRabbitMessage(RabbitConfig.exchange, RabbitConfig.routingKey, requestDTO, "UPDATE");

        } catch (NullPointerException e) {
            throw new RuntimeException(e.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void sendRabbitMessage(String exchange, String routingKey, RequestProductDTO product, String header) throws JsonProcessingException {
        String request = mapper.writeValueAsString(product);
        rabbitTemplate.convertAndSend(exchange, routingKey, request, message -> {
            message.getMessageProperties().setHeader("EVENT", header);
            return message;
        });
    }

    public void sendRabbitMessageId(String exchange, String routingKey, Long id, String header) {
        rabbitTemplate.convertAndSend(exchange, routingKey, id, message -> {
            message.getMessageProperties().setHeader("EVENT", header);
            return message;
        });
    }

    public ResponseEntity<Product> getById(Long id) {
        RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://" + host + ":8080/api/products/get").build();

        ResponseEntity<Product> product = restTemplate.getForEntity("/" + id, Product.class);
        return product;
    }

    public ResponseEntity<PageableResponse<Product>> getAll() {
        RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://" + host + ":8080/api/products/get").build();
        ResponseEntity<PageableResponse<Product>> exchange = restTemplate.exchange("/all", HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<PageableResponse<Product>>() {
                });
        return exchange;
    }
}
