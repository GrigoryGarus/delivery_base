package io.github.mkdev.service;

import io.github.mkdev.model.Item;
import io.github.mkdev.model.User;
import io.github.mkdev.model.UserTransactions;
import java.math.BigDecimal;

public class UserTransactionService {

  public UserTransactions createUserTransactions(User user, Item item,
                                                 Integer count, BigDecimal price) {
    return new UserTransactions(user, item, count, price);
  }
}
