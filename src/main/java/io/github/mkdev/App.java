package io.github.mkdev;

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


public class App {


  /**
   * Input program method. Allow start project code.
   */
  public static void main(String[] args) {
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
                     2);

    System.out.println("Create admin with name: " + admin.getName());
    System.out.println("Create admin with name: " + user.getName());
    System.out.println("Create marketOwner with role: " + marketOwner.getRole().getName());
    System.out.println("Create item pizza with description: " + pizza.getDescription());
    System.out.println("Create UserTransactions userTransaction with item name: "
                         + userTransaction.getItem().getName());
  }
}
