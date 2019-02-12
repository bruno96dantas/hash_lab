package br.com.bruno96dantas.hashlab_discount.services;

import br.com.bruno96dantas.hashlab_discount.converters.UserConvert;
import br.com.bruno96dantas.hashlab_discount.dto.UserDto;
import br.com.bruno96dantas.hashlab_discount.models.User;
import br.com.bruno96dantas.hashlab_discount.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConvert userConvert;

    @Transactional
    public UserDto create(UserDto userDto) {

        User user = userConvert.convert(userDto);

        user = userRepository.save(user);

        userDto.setId(user.getId());

        return userDto;
    }

    public List<UserDto> selectAll() {

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(x -> userConvert.unConvert(x))
                .collect(toList());
    }

    public void delete(Long userId) {

        userRepository.deleteById(userId);
    }
}
