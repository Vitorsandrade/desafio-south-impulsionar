package com.br.vitor.desafio2.mapper;

import com.br.vitor.desafio2.dto.ProductDTO;
import com.br.vitor.desafio2.dto.RequestProductDTO;
import com.br.vitor.desafio2.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-28T14:54:12-0300",
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
        productDTO.manufacturingDate( product.getManufacturingDate() );
        productDTO.expirationDate( product.getExpirationDate() );
        productDTO.color( product.getColor() );
        productDTO.material( product.getMaterial() );
        productDTO.category( product.getCategory() );
        productDTO.amount( product.getAmount() );

        return productDTO.build();
    }

    @Override
    public ProductDTO requestToProductDTO(RequestProductDTO requestProductDTO) {
        if ( requestProductDTO == null ) {
            return null;
        }

        ProductDTO.ProductDTOBuilder productDTO = ProductDTO.builder();

        productDTO.name( requestProductDTO.getName() );
        productDTO.description( requestProductDTO.getDescription() );
        productDTO.price( requestProductDTO.getPrice() );
        productDTO.color( requestProductDTO.getColor() );
        productDTO.material( requestProductDTO.getMaterial() );
        productDTO.category( requestProductDTO.getCategory() );
        productDTO.amount( requestProductDTO.getAmount() );

        return productDTO.build();
    }

    @Override
    public Product productDtoToProduct(ProductDTO productDTO) {
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
        product.manufacturingDate( productDTO.getManufacturingDate() );
        product.expirationDate( productDTO.getExpirationDate() );
        product.color( productDTO.getColor() );
        product.material( productDTO.getMaterial() );
        product.category( productDTO.getCategory() );
        product.amount( productDTO.getAmount() );

        return product.build();
    }
}
