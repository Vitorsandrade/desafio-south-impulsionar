package com.br.vitor.desafio2.mapper;

import com.br.vitor.desafio2.dto.ProductDTO;
import com.br.vitor.desafio2.dto.RequestAmountDTO;
import com.br.vitor.desafio2.dto.RequestProductDTO;
import com.br.vitor.desafio2.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-05T18:54:59-0300",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO productToProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO.ProductDTOBuilder productDTO = ProductDTO.builder();

        productDTO.id( product.getId() );
        productDTO.code( product.getCode() );
        productDTO.barCode( product.getBarCode() );
        productDTO.series( product.getSeries() );
        productDTO.name( product.getName() );
        productDTO.description( product.getDescription() );
        productDTO.price( product.getPrice() );
        productDTO.tax( product.getTax() );
        productDTO.manufacturingDate( product.getManufacturingDate() );
        productDTO.expirationDate( product.getExpirationDate() );
        productDTO.color( product.getColor() );
        productDTO.material( product.getMaterial() );
        productDTO.category( product.getCategory() );
        productDTO.amount( product.getAmount() );

        return productDTO.build();
    }

    @Override
    public Product requestAmountToProduct(RequestAmountDTO requestAmountDTO) {
        if ( requestAmountDTO == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.amount( requestAmountDTO.getAmount() );

        return product.build();
    }

    @Override
    public Product requestToProduct(RequestProductDTO requestProductDTO) {
        if ( requestProductDTO == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.name( requestProductDTO.getName() );
        product.description( requestProductDTO.getDescription() );
        product.price( requestProductDTO.getPrice() );
        product.tax( requestProductDTO.getTax() );
        product.color( requestProductDTO.getColor() );
        product.material( requestProductDTO.getMaterial() );
        product.category( requestProductDTO.getCategory() );

        return product.build();
    }
}
