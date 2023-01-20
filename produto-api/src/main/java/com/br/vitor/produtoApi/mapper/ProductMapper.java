package com.br.vitor.produtoApi.mapper;

import com.br.vitor.produtoApi.dto.ProductDTO;
import com.br.vitor.produtoApi.dto.RequestProductDTO;
import com.br.vitor.produtoApi.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO productToProductDTO(Product product);

    Product requestToProduct(RequestProductDTO requestProductDTO);

    Product productDTOToProduct(ProductDTO productDTO);

    RequestProductDTO productToRequestDTO(Product product);

    RequestProductDTO productDTOToRequestDTO(ProductDTO productDTO);

}
