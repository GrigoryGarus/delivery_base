package io.github.mkdev;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.github.mkdev.model.Item;
import io.github.mkdev.model.Market;
import io.github.mkdev.model.Role;
import io.github.mkdev.model.User;
import io.github.mkdev.model.UserTransactions;
import io.github.mkdev.service.ItemService;
import io.github.mkdev.service.MarketService;
import io.github.mkdev.service.RoleService;
import io.github.mkdev.service.UserService;
import io.github.mkdev.service.UserTransactionService;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;



public class UserTransactionServiceTest {

  static RoleService roleService = new RoleService();
  static UserService userService = new UserService();
  static MarketService marketService = new MarketService();
  static ItemService itemService = new ItemService();
  static UserTransactionService userTransactionService = new UserTransactionService();


  static Role adminRole = roleService.createAdminRole();
  static Role userRole = roleService.createUserRole();
  static Role marketOwnerRole = roleService.createMarketOwnerRole();

  static User admin = userService.create("admin", adminRole);
  static User user = userService.create("user", userRole);
  static User marketOwner = userService.create("marketOwner", marketOwnerRole);
  static Market delivery = marketService.createMarket("Delivery", marketOwner);
  static Item pizza = itemService.createItem("Pizza", "Пицца 4 сыра", delivery,
                  new BigDecimal(750));
  static UserTransactions userTransaction = userTransactionService.createUserTransactions(
                                             user, pizza, 2, new BigDecimal(1500));

  @Test
  void userTransactionServiceUserRoleTest() {
    assertEquals("USER", userTransaction.getUser().getRole().getName(),
                 "Create UserTransactions with user role name");
  }

  @Test
  void userTransactionServiceItemPriceTest() {
    assertEquals(new BigDecimal(1500), userTransaction.getPrice(),
                  "Create UserTransactions with user role name");
  }

  @Test
  void userTransactionServiceHasCountTest() {
    assertNotNull(userTransaction.getCount(),
                 "Create UserTransactions has count");
  }

  @Test
  void userTransactionServiceItemTotalTest() {
    assertEquals(new BigDecimal(1500), userTransaction.getTotal(),
                "Create UserTransactions with user total");
  }
}
