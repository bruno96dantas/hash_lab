package br.com.bruno96dantas.hashlab_discount.services;

import br.com.bruno96dantas.hashlab_discount.converters.DiscountConvert;
import br.com.bruno96dantas.hashlab_discount.converters.UserConvert;
import br.com.bruno96dantas.hashlab_discount.dto.DiscountDto;
import br.com.bruno96dantas.hashlab_discount.dto.ProductDto;
import br.com.bruno96dantas.hashlab_discount.models.Discount;
import br.com.bruno96dantas.hashlab_discount.models.User;
import br.com.bruno96dantas.hashlab_discount.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class DiscountService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserConvert userConvert;

    @Autowired
    private DiscountConvert discountConvert;


    public DiscountDto getDiscount(Long userId, Long productId) {

        User user = userRepository.findByOneId(userId);

        /* fazer a requisição buscando o valor do produto */
        ServiceInstance serviceInstance = loadBalancerClient.choose("HASHLAB_LISTING");

        ResponseEntity<ProductDto> product =
                restTemplate.exchange(
                        "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/{productId}",
                        HttpMethod.GET,
                        null,
                        ProductDto.class,
                        productId);

        double productPrice = product.getBody().getPrice();

        if (user.getDateOfBirth().isEqual(LocalDate.now())){

            return setDiscountPercentage(productPrice, 0.05, user);

        }
        // black friday
        else if (LocalDate.now().isEqual(LocalDate.of(2019, 11, 25))) {

            return setDiscountPercentage(productPrice, 0.10, user);
        }

        return setDiscountPercentage(productPrice, 0, user);
    }

    private DiscountDto setDiscountPercentage(double productPrice, double percentage, User user) {
        productPrice = productPrice * percentage;

        Discount discount = Discount.builder()
                .discountPercentage(percentage)
                .discount(productPrice)
                .user(user)
                .build();

        user.setDiscount(discount);

        userService.update(userConvert.unConvert(user));

        return discountConvert.unConvert(discount);
    }
}
