package io.github.mkdev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.mkdev.service.RoleService;
import org.junit.jupiter.api.Test;



public class RoleServiceTest {

  @Test
  void roleServiceTest() {
    RoleService roleServiceTest = new RoleService();
    assertEquals("ADMIN", roleServiceTest.createAdminRole().getName(),
                 "сервис должен создать роль админа");
  }
}
