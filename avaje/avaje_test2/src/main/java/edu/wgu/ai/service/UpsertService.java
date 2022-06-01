package edu.wgu.ai.service;

public interface UpsertService<T, KeyType> extends ReadService<T, KeyType> {
    void upsert(T obj);
}
