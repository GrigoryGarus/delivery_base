package io.github.mkdev;

import io.github.mkdev.dao.H2BaseRepository;
import io.github.mkdev.dao.H2RoleRepository;
import io.github.mkdev.dao.Repository;
import io.github.mkdev.database.H2ConnectionManager;
import io.github.mkdev.model.Role;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;


public class App {


  /**
   * Input program method. Allow start project code.
   */
  public static void main(String[] args) throws SQLException {
    H2ConnectionManager connectionManager = H2ConnectionManager.create();


    Connection connection = connectionManager.getConnection();


    Repository<Role> h2RoleRepository = new H2RoleRepository(connection);


    Optional<Role> role = h2RoleRepository.save(new Role("ADMIN"));

    System.out.println(role.get().getId());

    H2BaseRepository baseRepository = new H2BaseRepository(connection);
    System.out.println(Arrays.asList(baseRepository.selectAllFieldsByTableNameAndId(
              "Role", role.get().getId().toString())));


    baseRepository.updateFieldByTableNameFieldNameAndId("Role", "name",
                                  role.get().getId().toString(), "USER!");



    baseRepository.createRowByTableNameAndColumns("Role",
      new String[]{"1de3e313-d18b-47d2-8239-fe99a28a209f", "USERR"});

    baseRepository.deleteRowByTableNameAndRowId("Role", role.get().getId().toString());
    System.out.println(Arrays.asList(baseRepository.selectAllFieldsByTableNameAndId(
      "Role", role.get().getId().toString())));

    System.out.println(Arrays.asList(baseRepository.selectAllFieldsByTableNameAndId(
      "Role", "1de3e313-d18b-47d2-8239-fe99a28a209f")));



    String [] values = {"USER", role.get().getId().toString() };
    StringBuilder valueAppend= new StringBuilder();
    valueAppend.append("INSERT INTO ").append("tableName").append(" VALUES (");
    for (int i = 0; i <values.length; i++) {
      if (i!=values.length-1){
        valueAppend.append("'").append(values[i]).append("', ");
      } else valueAppend.append("'").append(values[i]).append("')");
    }
    System.out.println(valueAppend.toString());








  }
}
