package edu.wgu.ai.job.service;

public interface CreateService<CreateObject, KeyType> {
    KeyType create(CreateObject obj);
}
