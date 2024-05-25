package com.sabirov.springeshop.mapper;

import com.sabirov.springeshop.domain.Product;
import com.sabirov.springeshop.domain.Product.ProductBuilder;
import com.sabirov.springeshop.dto.ProductDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-23T20:27:30+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ProductBuilder product = Product.builder();

        if ( dto.getId() != null ) {
            product.id( dto.getId() );
        }
        product.title( dto.getTitle() );
        product.price( dto.getPrice() );

        return product.build();
    }

    @Override
    public ProductDTO fromProduct(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( product.getId() );
        productDTO.setTitle( product.getTitle() );
        productDTO.setPrice( product.getPrice() );

        return productDTO;
    }

    @Override
    public List<Product> toProductList(List<ProductDTO> productDTOS) {
        if ( productDTOS == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productDTOS.size() );
        for ( ProductDTO productDTO : productDTOS ) {
            list.add( toProduct( productDTO ) );
        }

        return list;
    }

    @Override
    public List<ProductDTO> fromProductList(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( products.size() );
        for ( Product product : products ) {
            list.add( fromProduct( product ) );
        }

        return list;
    }
}
