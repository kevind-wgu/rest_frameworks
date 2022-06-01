package edu.wgu.ai;

import java.util.NoSuchElementException;
import java.util.Optional;

public interface ReadService<T, KeyType> {
    Optional<T> get(KeyType id);
}
