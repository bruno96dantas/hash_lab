package br.com.bruno96dantas.hashlab_listing.services;

import br.com.bruno96dantas.hashlab_listing.converters.ProductConvert;
import br.com.bruno96dantas.hashlab_listing.dto.ProductDto;
import br.com.bruno96dantas.hashlab_listing.models.Product;
import br.com.bruno96dantas.hashlab_listing.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConvert productConvert;

    @Transactional
    public ProductDto create(ProductDto productDto) {

        Product product = productConvert.convert(productDto);

        product = productRepository.save(product);

        productDto.setId(product.getId());

        return productDto;
    }

    public List<ProductDto> selectAll() {

        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(x -> productConvert.unConvert(x))
                .collect(toList());
    }

    public void delete(Long productId) {

        productRepository.deleteById(productId);
    }
}
