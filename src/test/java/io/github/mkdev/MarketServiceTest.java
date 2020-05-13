package io.github.mkdev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.mkdev.model.Market;
import io.github.mkdev.model.Role;
import io.github.mkdev.model.User;
import io.github.mkdev.service.ItemService;
import io.github.mkdev.service.MarketService;
import io.github.mkdev.service.RoleService;
import io.github.mkdev.service.UserService;
import org.junit.jupiter.api.Test;



public class MarketServiceTest {

  static RoleService roleService = new RoleService();
  static UserService userService = new UserService();
  static MarketService marketService = new MarketService();
  static Role marketOwnerRole = roleService.createMarketOwnerRole();
  static User marketOwner = userService.create("marketOwner", marketOwnerRole);
  static Market delivery = marketService.createMarket("Delivery", marketOwner);

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
