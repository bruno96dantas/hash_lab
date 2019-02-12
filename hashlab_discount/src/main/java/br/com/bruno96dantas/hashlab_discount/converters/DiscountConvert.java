package br.com.bruno96dantas.hashlab_discount.converters;

import br.com.bruno96dantas.hashlab_discount.dto.DiscountDto;
import br.com.bruno96dantas.hashlab_discount.models.Discount;
import org.springframework.stereotype.Component;

@Component
public class DiscountConvert implements Convert<Discount, DiscountDto> {

    @Override
    public Discount convert(DiscountDto dto) {
        return Discount.builder()
                .discountPercentage(dto.getDiscountPercentage())
                .discount(dto.getDiscount())
                .build();
    }

    @Override
    public DiscountDto unConvert(Discount discount) {
        return DiscountDto.builder()
                .id(discount.getId())
                .discountPercentage(discount.getDiscountPercentage())
                .discount(discount.getDiscount())
                .build();
    }
}
