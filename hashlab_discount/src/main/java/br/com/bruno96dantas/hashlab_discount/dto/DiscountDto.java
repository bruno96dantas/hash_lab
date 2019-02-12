package br.com.bruno96dantas.hashlab_discount.dto;

import br.com.bruno96dantas.hashlab_discount.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DiscountDto {

    private Long id;
    private double discountPercentage;
    private double discount;
    private User user;
}
