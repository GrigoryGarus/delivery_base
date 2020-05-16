package io.github.mkdev.dao;

import java.util.Optional;

public interface Repository<T> {
  Optional<T> save(T t);
}
