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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class ItemServiceTest {

  private transient Item pizza;

  /** Init.*/

  @BeforeEach
  public void init() {
    RoleService roleService = new RoleService();
    UserService userService = new UserService();
    MarketService marketService = new MarketService();
    ItemService itemService = new ItemService();
    Role marketOwnerRole = roleService.createMarketOwnerRole();
    User marketOwner = userService.create("marketOwner", marketOwnerRole);
    Market delivery = marketService.createMarket("Delivery", marketOwner);
    pizza = itemService.createItem("Pizza", "Пицца 4 сыра", delivery,
                                  new BigDecimal(750));
  }

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
