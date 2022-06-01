package edu.wgu.ai;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class MyReadService implements ReadService<MyObj, Integer> {
    @Inject
    public MyReadService() {
    }

    @Override
    public Optional<MyObj> get(Integer id) {
        return Optional.empty();
    }
}
