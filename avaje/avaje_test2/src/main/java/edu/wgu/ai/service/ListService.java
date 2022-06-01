package edu.wgu.ai.service;

import java.util.List;

public interface ListService<T,SearchObj> {
    List<T> list(SearchObj search);
}
