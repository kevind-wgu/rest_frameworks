package edu.wgu.ai.service;

public interface CreateService<CreateObject, KeyType> {
    KeyType create(CreateObject obj);
}
