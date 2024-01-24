package com.cgtfarmer.app.controller;

import com.cgtfarmer.app.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

  // private final UserService userService;

  // @Autowired
  // public UserController(UserService userService) {
  //   this.userService = userService;
  // }

  @GetMapping
  public ResponseEntity<String> index() {
    log.info("[UserController#index]");

    // UserResponse response = this.userService.findAll();

    // return ResponseEntity.ok(response);
    return ResponseEntity.ok("{ \"msg\": \"Hello, world!\"}");
  }

  @PostMapping
  public ResponseEntity<String> create(
    // @RequestBody UserRequest request
  ) {
    // log.info("[UserController#create] {}", request);
    log.info("[UserController#create]");

    // UserResponse response = this.userService.create(request);

    // return ResponseEntity.ok(response);
    return ResponseEntity.ok("{ \"msg\": \"Created successfully\"}");
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserEntity> show(@PathVariable Long id) {
    log.info("[UserController#show] id={}", id);

    // UserResponse response = this.userService.findAll();

    // return ResponseEntity.ok(response);
    UserEntity user = UserEntity.builder()
        .id(id)
        .firstName("John")
        .lastName("Doe")
        .age(35)
        .weight(185.3f)
        .build();

    return ResponseEntity.ok(user);
  }
}
