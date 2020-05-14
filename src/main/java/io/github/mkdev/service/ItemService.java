package io.github.mkdev.service;

import io.github.mkdev.model.Item;
import io.github.mkdev.model.Market;
import java.math.BigDecimal;

public class ItemService {

  public Item createItem(String name, String description, Market market, BigDecimal price) {
    return new Item(name, description, market, price);
  }
}
