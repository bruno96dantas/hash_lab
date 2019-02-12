package br.com.bruno96dantas.hashlab_discount.services;

import br.com.bruno96dantas.hashlab_discount.converters.DiscountConvert;
import br.com.bruno96dantas.hashlab_discount.dto.DiscountDto;
import br.com.bruno96dantas.hashlab_discount.dto.ProductDto;
import br.com.bruno96dantas.hashlab_discount.models.Discount;
import br.com.bruno96dantas.hashlab_discount.models.User;
import br.com.bruno96dantas.hashlab_discount.repositories.DiscountRepository;
import br.com.bruno96dantas.hashlab_discount.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;

@Service
public class DiscountService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DiscountConvert discountConvert;


    public DiscountDto getDiscount(Long userId, Long productId) {

        User user = userRepository.findByOneId(userId);

        if(user.getDateOfBirth().isEqual(LocalDate.now())){

            /* fazer a requisição buscando o valor do produto */
            ProductDto product = restTemplate.getForObject("localhost:8088/product", ProductDto.class);
            /* valor do produto -5% */

            Discount discount = Discount.builder()
                    .discountPercentage(5)
                    //.discount()
                    .user(user)
                    .build();

            user.setDiscount(discount);

            // update user

            return discountConvert.unConvert(discount);

        }
        // black friday
//        else if () {
//
//        } else {
//
//        }
        return null;
    }
}
