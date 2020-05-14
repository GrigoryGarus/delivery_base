package io.github.mkdev.service;

import io.github.mkdev.model.Item;
import io.github.mkdev.model.User;
import io.github.mkdev.model.UserTransactions;

public class UserTransactionService {

  public UserTransactions createUserTransactions(User user, Item item,
                                                 Integer count) {
    return new UserTransactions(user, item, count);
  }
}
