package com.dao;

import java.util.List;

public interface DAO<T> {
  public boolean create(T data);

  public List<T> getAll();

  public T find(int id);

  public List<T> getAllWhere(String query);

  public boolean update(int id, T data);

  public boolean destroy(int id);
}
