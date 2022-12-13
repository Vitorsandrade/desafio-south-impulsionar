package com.br.vitor.desafio2.mapper;

import com.br.vitor.desafio2.dto.ProductDTO;
import com.br.vitor.desafio2.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-13T09:51:30-0300",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toProductDTO(Product product) {
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
        productDTO.manufacturingDate( product.getManufacturingDate() );
        productDTO.expirationDate( product.getExpirationDate() );
        productDTO.color( product.getColor() );
        productDTO.material( product.getMaterial() );
        productDTO.category( product.getCategory() );
        productDTO.amount( product.getAmount() );

        return productDTO.build();
    }

    @Override
    public Product productToProduct(Product product) {
        if ( product == null ) {
            return null;
        }

        Product.ProductBuilder product1 = Product.builder();

        product1.id( product.getId() );
        product1.code( product.getCode() );
        product1.barCode( product.getBarCode() );
        product1.series( product.getSeries() );
        product1.name( product.getName() );
        product1.description( product.getDescription() );
        product1.price( product.getPrice() );
        product1.manufacturingDate( product.getManufacturingDate() );
        product1.expirationDate( product.getExpirationDate() );
        product1.color( product.getColor() );
        product1.material( product.getMaterial() );
        product1.category( product.getCategory() );
        product1.amount( product.getAmount() );

        return product1.build();
    }
}
