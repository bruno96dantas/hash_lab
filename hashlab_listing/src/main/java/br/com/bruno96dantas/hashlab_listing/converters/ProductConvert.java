package br.com.bruno96dantas.hashlab_listing.converters;

import br.com.bruno96dantas.hashlab_listing.dto.ProductDto;
import br.com.bruno96dantas.hashlab_listing.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConvert {

    public Product convert(ProductDto dto) {
        return Product.builder()
                .price(dto.getPrice())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .build();
    }

    public ProductDto unConvert(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .price(product.getPrice())
                .title(product.getTitle())
                .description(product.getDescription())
                .build();
    }
}
