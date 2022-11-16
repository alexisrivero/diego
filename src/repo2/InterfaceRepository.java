package repo2;

import java.util.List;

public interface InterfaceRepository<T> {
    boolean save(T element);
    int count();
    T find();
    List<T> getAllSortedBy(String atribute);
}
