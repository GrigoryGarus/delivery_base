package io.github.mkdev;

import io.github.mkdev.model.Market;
import io.github.mkdev.model.Role;
import io.github.mkdev.model.User;
import io.github.mkdev.service.ItemService;
import io.github.mkdev.service.MarketService;
import io.github.mkdev.service.RoleService;
import io.github.mkdev.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarketServiceTest {

  RoleService roleService = new RoleService();
  UserService userService = new UserService();
  MarketService marketService = new MarketService();

  Role marketOwnerRole = roleService.createMarketOwnerRole();

  User marketOwner = userService.create("marketOwner", marketOwnerRole);
  Market delivery = marketService.createMarket("Delivery", marketOwner);
  @Test
  void marketServiceOwnerNameTest() {
    assertEquals("marketOwner" ,delivery.getOwner().getName(),
      "Create market with owner name");
  }
  @Test
  void marketServiceNameTest() {
    assertEquals("Delivery" ,delivery.getName(),
      "Create market with name");
  }
}
