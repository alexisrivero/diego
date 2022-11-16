package repo2;

import java.util.List;

public abstract class Repository<T> implements InterfaceRepository<T>{
    protected List<T> list;
}
