package br.com.bruno96dantas.hashlab_listing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDto {

    private Long id;
    private Float price;
    private String title;
    private String description;
}
