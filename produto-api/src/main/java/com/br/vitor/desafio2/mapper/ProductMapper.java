package com.br.vitor.desafio2.mapper;

import com.br.vitor.desafio2.dto.ProductDTO;
import com.br.vitor.desafio2.dto.RequestAmountDTO;
import com.br.vitor.desafio2.dto.RequestProductDTO;
import com.br.vitor.desafio2.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO productToProductDTO(Product product);
    Product requestAmountToProduct(RequestAmountDTO requestAmountDTO);
    Product requestToProduct(RequestProductDTO requestProductDTO);

    Product productDTOToProduct(ProductDTO productDTO);

}
