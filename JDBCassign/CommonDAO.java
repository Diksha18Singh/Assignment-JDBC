package com.JDBCassign;

import java.util.List;

public interface CommonDAO<T> {

	void create(T object);

	List<T> findAll();

	public T findById(int i);

	// void create(Card object);

}
