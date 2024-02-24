package org.example.dao.interfaces;

public interface Dao<T> {
    void create(T obj);
    T update(T obj, Class<T> tClass, int id);
    T read(int id, Class<T> tClass);
    void delete(int id, Class<T> tClass);
}
