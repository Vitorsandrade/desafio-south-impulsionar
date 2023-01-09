package com.br.vitor.desafio2.mapper;

import com.br.vitor.desafio2.dto.ProductDTO;
import com.br.vitor.desafio2.dto.RequestAmountDTO;
import com.br.vitor.desafio2.dto.RequestProductDTO;
import com.br.vitor.desafio2.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-09T16:15:53-0300",
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

    @Override
    public Product productDTOToProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( productDTO.getId() );
        product.code( productDTO.getCode() );
        product.barCode( productDTO.getBarCode() );
        product.series( productDTO.getSeries() );
        product.name( productDTO.getName() );
        product.description( productDTO.getDescription() );
        product.price( productDTO.getPrice() );
        product.tax( productDTO.getTax() );
        product.manufacturingDate( productDTO.getManufacturingDate() );
        product.expirationDate( productDTO.getExpirationDate() );
        product.color( productDTO.getColor() );
        product.material( productDTO.getMaterial() );
        product.category( productDTO.getCategory() );
        product.amount( productDTO.getAmount() );

        return product.build();
    }
}
