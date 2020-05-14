package io.github.mkdev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.mkdev.model.Market;
import io.github.mkdev.model.Role;
import io.github.mkdev.model.User;
import io.github.mkdev.service.MarketService;
import io.github.mkdev.service.RoleService;
import io.github.mkdev.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MarketServiceTest {

  private transient Market delivery;

  /** Init.*/

  @BeforeEach
  public void init() {
    RoleService roleService = new RoleService();
    UserService userService = new UserService();
    MarketService marketService = new MarketService();
    Role marketOwnerRole = roleService.createMarketOwnerRole();
    User marketOwner = userService.create("marketOwner", marketOwnerRole);
    delivery = marketService.createMarket("Delivery", marketOwner);
  }

  @Test
  void marketServiceOwnerNameTest() {
    assertEquals("marketOwner", delivery.getOwner().getName(),
        "Create market with owner name");
  }

  @Test
  void marketServiceNameTest() {
    assertEquals("Delivery", delivery.getName(),
        "Create market with name");
  }
}
