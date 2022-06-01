package edu.wgu.ai.job.service;

public interface CRUDService<T, KeyType> extends
        ReadService<T, KeyType>,
        CreateService<T, KeyType>,
        UpdateService<T>,
        DeleteService<KeyType>
{
}
