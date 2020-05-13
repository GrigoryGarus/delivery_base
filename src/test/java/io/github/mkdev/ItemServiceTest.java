package io.github.mkdev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.mkdev.model.Item;
import io.github.mkdev.model.Market;
import io.github.mkdev.model.Role;
import io.github.mkdev.model.User;
import io.github.mkdev.service.ItemService;
import io.github.mkdev.service.MarketService;
import io.github.mkdev.service.RoleService;
import io.github.mkdev.service.UserService;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;



public class ItemServiceTest {


  static RoleService  roleService = new RoleService();
  static UserService userService = new UserService();
  static MarketService marketService = new MarketService();
  static ItemService itemService = new ItemService();
  static Role marketOwnerRole = roleService.createMarketOwnerRole();
  static User marketOwner = userService.create("marketOwner", marketOwnerRole);
  static Market delivery = marketService.createMarket("Delivery", marketOwner);
  static Item pizza = itemService.createItem("Pizza", "Пицца 4 сыра", delivery,
           new BigDecimal(750));

  @Test
  void itemServiceDescriptionTest() {
    assertEquals("Пицца 4 сыра", pizza.getDescription(),
                  "Create item pizza with description");
  }

  @Test
  void itemServiceNameTest() {
    assertEquals("Pizza", pizza.getName(),
                "Create item pizza with description");
  }
}
