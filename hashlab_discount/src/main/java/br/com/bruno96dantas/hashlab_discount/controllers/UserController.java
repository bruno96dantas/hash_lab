package br.com.bruno96dantas.hashlab_discount.controllers;

import br.com.bruno96dantas.hashlab_discount.dto.UserDto;
import br.com.bruno96dantas.hashlab_discount.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity create(@RequestBody UserDto userDto) {

        userService.create(userDto);

        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity selectAll() {

        return ResponseEntity.ok(userService.selectAll());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity delete(@PathVariable("userId") Long userId) {

        userService.delete(userId);

        return ResponseEntity.ok().build();
    }
}
