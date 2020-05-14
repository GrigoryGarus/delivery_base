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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class UserTransactionServiceTest {

  private transient UserTransactions userTransaction;

  /** Init.*/

  @BeforeEach
  public void init() {
    RoleService roleService = new RoleService();
    UserService userService = new UserService();
    MarketService marketService = new MarketService();
    ItemService itemService = new ItemService();
    UserTransactionService userTransactionService = new UserTransactionService();
    Role userRole = roleService.createUserRole();
    Role marketOwnerRole = roleService.createMarketOwnerRole();
    User user = userService.create("user", userRole);
    User marketOwner = userService.create("marketOwner", marketOwnerRole);
    Market delivery = marketService.createMarket("Delivery", marketOwner);
    Item pizza = itemService.createItem("Pizza", "Пицца 4 сыра", delivery,
                            new BigDecimal(750));
    userTransaction = userTransactionService.createUserTransactions(user, pizza, 2);
  }


  @Test
  void userTransactionServiceUserRoleTest() {
    assertEquals("USER", userTransaction.getUser().getRole().getName(),
        "Create UserTransactions with user role name");
  }

  @Test
  void userTransactionServiceItemPriceTest() {
    assertEquals(new BigDecimal(750), userTransaction.getPrice(),
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
