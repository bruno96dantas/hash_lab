package br.com.bruno96dantas.hashlab_listing.controllers;

import br.com.bruno96dantas.hashlab_listing.dto.ProductDto;
import br.com.bruno96dantas.hashlab_listing.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity create(@RequestBody ProductDto productDto) {

        productService.create(productDto);

        return ResponseEntity.ok(productDto);
    }

    @GetMapping
    public ResponseEntity selectAll() {

        return ResponseEntity.ok(productService.selectAll());
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity delete(@PathVariable("productId") Long productId) {

        productService.delete(productId);

        return ResponseEntity.ok().build();
    }
}
