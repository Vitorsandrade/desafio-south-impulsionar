package com.br.vitor.desafio2.mapper;

import com.br.vitor.desafio2.dto.ProductDTO;
import com.br.vitor.desafio2.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-06T13:52:52-0300",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( product.getId() );
        productDTO.setCode( product.getCode() );
        productDTO.setBarCode( product.getBarCode() );
        productDTO.setSeries( product.getSeries() );
        productDTO.setName( product.getName() );
        productDTO.setDescription( product.getDescription() );
        productDTO.setPrice( product.getPrice() );
        productDTO.setManufacturingDate( product.getManufacturingDate() );
        productDTO.setExpirationDate( product.getExpirationDate() );
        productDTO.setColor( product.getColor() );
        productDTO.setMaterial( product.getMaterial() );
        productDTO.setCategory( product.getCategory() );
        productDTO.setAmount( product.getAmount() );

        return productDTO;
    }
}
