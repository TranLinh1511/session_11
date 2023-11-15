package com.ra.model.dao;

import java.util.List;

public interface IGenericDAO<T, ID> {
    List<T> getAll();
    boolean save(T t);
    boolean save(T t, ID id);
    boolean delete(ID id);
    T findById(ID id);
}
