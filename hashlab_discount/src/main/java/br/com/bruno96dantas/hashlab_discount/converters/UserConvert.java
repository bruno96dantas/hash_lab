package br.com.bruno96dantas.hashlab_discount.converters;

import br.com.bruno96dantas.hashlab_discount.dto.UserDto;
import br.com.bruno96dantas.hashlab_discount.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserConvert implements Convert<User, UserDto> {

    @Override
    public User convert(UserDto dto) {
        return User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .dateOfBirth(dto.getDateOfBirth())
                .build();
    }

    @Override
    public UserDto unConvert(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .dateOfBirth(user.getDateOfBirth())
                .build();
    }
}
