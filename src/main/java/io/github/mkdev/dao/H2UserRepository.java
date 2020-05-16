package io.github.mkdev.dao;

import io.github.mkdev.model.Role;
import io.github.mkdev.model.User;
import java.sql.Connection;
import java.util.Optional;

public class H2UserRepository extends H2BaseRepository implements Repository<User> {

  public H2UserRepository(Connection connection) {
    super(connection);
  }

  @Override
  public Optional<User> save(User user) {
    return Optional.empty();
  }
}
