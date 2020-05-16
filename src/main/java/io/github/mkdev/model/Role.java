package io.github.mkdev.model;

import java.util.UUID;


public class Role {
  private UUID id;
  private String name;


  /**
   * Create {@link io.github.mkdev.model.Role} object with required fields.
   */
  public Role(String name) {
    this.name = name;
  }


  public Role(UUID id, String name) {
    this.id = id;
    this.name = name;
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
}
