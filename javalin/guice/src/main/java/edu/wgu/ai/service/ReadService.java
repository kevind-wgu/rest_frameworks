package edu.wgu.ai.service;

import java.util.NoSuchElementException;
import java.util.Optional;

public interface ReadService<T, KeyType> {
    Optional<T> get(KeyType id);

    String getTypeName();

    default T getRequired(KeyType id) {
        return get(id).orElseThrow(() -> new NoSuchElementException(getTypeName()));
    }
}
