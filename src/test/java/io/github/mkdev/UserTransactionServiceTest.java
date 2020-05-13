package io.github.mkdev;

import io.github.mkdev.model.*;
import io.github.mkdev.service.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTransactionServiceTest {

  RoleService roleService = new RoleService();
  UserService userService = new UserService();
  MarketService marketService = new MarketService();
  ItemService itemService = new ItemService();
  UserTransactionService userTransactionService = new UserTransactionService();


  Role adminRole = roleService.createAdminRole();
  Role userRole = roleService.createUserRole();
  Role marketOwnerRole = roleService.createMarketOwnerRole();


  User admin = userService.create("admin", adminRole);
  User user = userService.create("user", userRole);
  User marketOwner = userService.create("marketOwner", marketOwnerRole);
  Market delivery = marketService.createMarket("Delivery", marketOwner);
  Item pizza = itemService.createItem("Pizza", "Пицца 4 сыра", delivery,
    new BigDecimal(750));
  UserTransactions userTransaction = userTransactionService.createUserTransactions(user, pizza,
    2, new BigDecimal(1500));

  @Test
  void userTransactionServiceUserRoleTest() {
    assertEquals("USER" , userTransaction.getUser().getRole().getName(),
      "Create UserTransactions with user role name");
  }

  @Test
  void userTransactionServiceItemPriceTest() {
    assertEquals(new BigDecimal(1500) , userTransaction.getPrice(),
      "Create UserTransactions with user role name");
  }
  @Test
  void userTransactionServiceHasCountTest() {
    assertNotNull(userTransaction.getCount(),
      "Create UserTransactions has count");
  }
}
