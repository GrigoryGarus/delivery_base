package io.github.mkdev.service;

import io.github.mkdev.model.Role;
import io.github.mkdev.model.User;


public class UserService {


  public User create(String name, Role role) {
    return new User(name, role);
  }
}
