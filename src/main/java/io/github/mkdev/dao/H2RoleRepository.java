package io.github.mkdev.dao;

import io.github.mkdev.model.Role;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;


public class H2RoleRepository extends H2BaseRepository implements Repository<Role> {


  public H2RoleRepository(Connection connection) {
    super(connection);
  }


  @Override
  public Optional<Role> save(Role role) {
    Optional<Role> dbRole = Optional.empty();
    String query = "INSERT INTO ROLE(NAME) VALUES ( '" + role.getName() + "' );";


    try {
      String id = this.insert(query);
      HashMap<String, String> roleHash = this.selectAllFieldsByTableNameAndId("ROLE", id);


      dbRole = Optional.of(new Role(
        UUID.fromString(roleHash.get("id")),
        roleHash.get("name")
      ));


    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }


    return dbRole;
  }
}
