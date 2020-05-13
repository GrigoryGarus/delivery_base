package io.github.mkdev.service;

import io.github.mkdev.model.Role;


public class RoleService {


  public Role createAdminRole() {
    return new Role("ADMIN");
  }


  public Role createUserRole() {
    return new Role("USER");
  }
  public Role createMarketOwnerRole() {
    return new Role("MARKET_OWNER");
  }

}
