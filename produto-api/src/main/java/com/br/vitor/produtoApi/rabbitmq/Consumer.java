package com.br.vitor.produtoApi.rabbitmq;

import com.br.vitor.produtoApi.config.RabbitConfig;
import com.br.vitor.produtoApi.dto.ProductDTO;
import com.br.vitor.produtoApi.entity.Product;
import com.br.vitor.produtoApi.mapper.ProductMapper;
import com.br.vitor.produtoApi.repository.ProductRepository;
import com.br.vitor.produtoApi.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


@Service
@Slf4j
@Transactional
public class Consumer {

    @Autowired
    ProductRepository repository;
    @Autowired
    ProductService service;
    @Autowired
    ObjectMapper mapper;
    @Autowired
    ProductMapper productMapper;

    @RabbitListener(queues = RabbitConfig.queue)
    public void productConsumer(Message<String> payload) {

        Object message = payload.getHeaders().get("EVENT");
        log.info("Receive Message " + message);
        try {
            switch (Objects.requireNonNull(message).toString()) {
                case "PRODUCT_CHANGED":
                    Product productChangedAmount = mapper.readValue(payload.getPayload(), Product.class);
                    repository.save(productChangedAmount);
                    log.info(productChangedAmount.getName() + " product amount updated to: " + productChangedAmount.getAmount() + "!");
                    break;
                case "POST":
                    Product insertionProduct = mapper.readValue(payload.getPayload(), Product.class);
                    service.insert(productMapper.productToRequestDTO(insertionProduct));
                    log.info("inserted product: " + insertionProduct.toString());
                    break;
                case "DELETE":
                    Long id = mapper.readValue(payload.getPayload(), Long.class);
                    service.delete(id);
                    log.info("product id " + id + " deleted!");
                    break;
                case "UPDATE":
                    ProductDTO productToUpdate = mapper.readValue(payload.getPayload(), ProductDTO.class);
                    service.update(productToUpdate.getId(), productMapper.productDTOToRequestDTO(productToUpdate));
                    log.info("product id " + productToUpdate.getId() + " updated!");
                    break;
                case "teste":
                    break;
            }
        } catch (Exception e) {
            log.error(e.getMessage());

        }
    }
}
