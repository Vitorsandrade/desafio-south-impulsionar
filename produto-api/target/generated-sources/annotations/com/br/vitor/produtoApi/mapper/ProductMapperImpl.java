package com.br.vitor.produtoApi.mapper;

import com.br.vitor.produtoApi.dto.ProductDTO;
import com.br.vitor.produtoApi.dto.RequestProductDTO;
import com.br.vitor.produtoApi.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-20T15:48:05-0300",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
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

    @Override
    public RequestProductDTO productToRequestDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        RequestProductDTO.RequestProductDTOBuilder requestProductDTO = RequestProductDTO.builder();

        requestProductDTO.name( product.getName() );
        requestProductDTO.description( product.getDescription() );
        requestProductDTO.price( product.getPrice() );
        requestProductDTO.color( product.getColor() );
        requestProductDTO.material( product.getMaterial() );
        requestProductDTO.category( product.getCategory() );
        requestProductDTO.tax( product.getTax() );

        return requestProductDTO.build();
    }

    @Override
    public RequestProductDTO productDTOToRequestDTO(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        RequestProductDTO.RequestProductDTOBuilder requestProductDTO = RequestProductDTO.builder();

        requestProductDTO.name( productDTO.getName() );
        requestProductDTO.description( productDTO.getDescription() );
        requestProductDTO.price( productDTO.getPrice() );
        requestProductDTO.color( productDTO.getColor() );
        requestProductDTO.material( productDTO.getMaterial() );
        requestProductDTO.category( productDTO.getCategory() );
        requestProductDTO.tax( productDTO.getTax() );

        return requestProductDTO.build();
    }
}
