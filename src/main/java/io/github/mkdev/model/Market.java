package io.github.mkdev.model;

import java.util.UUID;


public class Market {
  private final UUID id;
  private String name;
  private User owner;


  /**
   * Create {@link io.github.mkdev.model.Market} object with required fields.
   */
  public Market(String name, User owner) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.owner = owner;
  }


  public UUID getId() {
    return id;
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public User getOwner() {
    return owner;
  }


  public void setOwner(User owner) {
    this.owner = owner;
  }
}
