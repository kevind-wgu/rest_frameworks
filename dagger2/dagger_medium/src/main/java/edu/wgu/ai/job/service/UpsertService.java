package edu.wgu.ai.job.service;

public interface UpsertService<T, KeyType> extends ReadService<T, KeyType> {
    void upsert(T obj);
}
