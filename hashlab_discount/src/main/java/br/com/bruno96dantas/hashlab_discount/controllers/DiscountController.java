package br.com.bruno96dantas.hashlab_discount.controllers;

import br.com.bruno96dantas.hashlab_discount.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @GetMapping
    public ResponseEntity select(
            @RequestParam("userId") Long userId,
            @RequestParam("productId") Long productId) {

        return ResponseEntity.ok(discountService.getDiscount(userId, productId));
    }
}
