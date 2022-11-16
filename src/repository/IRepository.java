package repository;

import java.util.List;

public interface IRepository<T> {
    boolean save(T element);
    int count();
    T find();
    List<T> getAllSortedBy(String atribute);
}
