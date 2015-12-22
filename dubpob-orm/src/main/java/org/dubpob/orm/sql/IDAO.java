package org.dubpob.orm.sql;

import java.util.List;
import java.util.Map;

public interface IDAO<T extends Packable & Unpackable> {
	
    long countAll(Map<String, Object> params);

    void create(T t);

    void delete(long id);

    T find(Map<String, Object> params);
    List<T> findAll(Map<String, Object> params);

    void update(T t);
}
