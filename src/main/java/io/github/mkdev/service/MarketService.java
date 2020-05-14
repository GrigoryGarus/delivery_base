package io.github.mkdev.service;

import io.github.mkdev.model.Market;
import io.github.mkdev.model.User;

public class MarketService {
  public Market createMarket(String name, User owner) {
    return new Market(name, owner);
  }
}
