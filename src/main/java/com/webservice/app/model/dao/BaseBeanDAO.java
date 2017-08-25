package com.webservice.app.model.dao;

import java.util.List;

public interface BaseBeanDAO<T>
{
    public List<T> list();

    public T get(Long id);

    public boolean create(T t);

    public boolean update(T t);

    public boolean delete(Long id);
}
