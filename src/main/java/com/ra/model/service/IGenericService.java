package com.ra.model.service;

import java.util.List;

public interface IGenericService<T, ID> {
    List<T> getAll();
    boolean save(T t);
    boolean save(T t, ID id);
    boolean delete(ID id);
    T findById(ID id);
}
