package org.dubpob.orm.sql.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dubpob.orm.pojo.EntityModel;
import org.dubpob.orm.sql.IDAO;
import org.dubpob.orm.sql.Packable;
import org.dubpob.orm.sql.Unpackable;

import com.google.common.collect.Lists;
import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;

import static com.google.common.base.Throwables.propagate;

public class DAOImpl<T extends Packable & Unpackable> implements IDAO<T> {
	@SuppressWarnings("rawtypes")
	public static final Attribute<DAOImpl, String> DAO_ENTITY = new SimpleAttribute<DAOImpl, String>("entity") {
		public String getValue(DAOImpl dao) { return dao.model.getEntity().getCanonicalName(); }};
	
	private Connection connection;
	private String tableName;
	private EntityModel model;
	
	public DAOImpl(Connection connection, String tableName, EntityModel model) {
		this.connection = connection;
		this.tableName = tableName;
		this.model = model;
	}
	
	@Override
	public long countAll(Map<String, Object> params) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			propagate(e);
		}
		
		if(statement == null) {
			propagate(new SQLException());
			return 0;
		}
		
		StringBuilder builder = new StringBuilder("SELECT COUNT(1) AS COUNT FROM ");
		builder.append(tableName).append(" WHERE ");
		
		for(Entry<String, Object> entry : params.entrySet()) {
			builder.append(entry.getKey()).append(" = ").append(entry.getValue()).append(", ");
		}
		
		builder.delete(builder.length() - 2, builder.length());
		
		try {
			ResultSet result = statement.executeQuery(builder.toString());
			if(result != null && result.next()) {
				return result.getLong("COUNT");
			}
		} catch (SQLException e) {
			propagate(e);
		}
		
		return 0;
	}

	@Override
	public void create(T t) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			propagate(e);
		}
		
		if(statement == null) {
			propagate(new SQLException());
			return;
		}
		
		Map<String, Object> values = t.pack();
		StringBuilder builder = new StringBuilder("INSERT INTO ");
		builder.append(tableName).append(" VALUES(");
		
		for(Object obj : values.values()) {
			builder.append(obj.toString()).append(", ");
		}
		
		builder.delete(builder.length() - 2, builder.length()).append(")");
		
		try {
			statement.execute(builder.toString());
		} catch (SQLException e) {
			propagate(e);
		}
	}

	@Override
	public void delete(long id) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			propagate(e);
		}
		
		if(statement == null) {
			propagate(new SQLException());
			return;
		}
		
		StringBuilder builder = new StringBuilder("DELETE FROM ");
		builder.append(tableName).append(" WHERE ")
		.append(model.getPrimaryKeyColumn()).append(" = ").append(id);
		
		try {
			statement.execute(builder.toString());
		} catch (SQLException e) {
			propagate(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T find(Map<String, Object> params) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			propagate(e);
		}
		
		if(statement == null) {
			propagate(new SQLException());
			return null;
		}
		
		StringBuilder builder = new StringBuilder("SELECT * FROM ");
		builder.append(tableName).append(" WHERE ");
		
		for(Entry<String, Object> entry : params.entrySet()) {
			builder.append(entry.getKey()).append(" = ").append(entry.getValue()).append(", ");
		}
		
		builder.delete(builder.length() - 2, builder.length());
		
		try {
			ResultSet result = statement.executeQuery(builder.toString());
			if(result != null && result.next()) {
				T obj = (T)model.getEntity().newInstance();
				obj.unpack(result);
				return obj;
			}
		} catch (SQLException | InstantiationException | IllegalAccessException e) {
			propagate(e);
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Map<String, Object> params) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			propagate(e);
		}
		
		if(statement == null) {
			propagate(new SQLException());
			return null;
		}
		
		List<T> ts = Lists.newArrayList();
		
		StringBuilder builder = new StringBuilder("SELECT * FROM ");
		builder.append(tableName).append(" WHERE ");
		
		for(Entry<String, Object> entry : params.entrySet()) {
			builder.append(entry.getKey()).append(" = ").append(entry.getValue()).append(", ");
		}
		
		builder.delete(builder.length() - 2, builder.length());
		
		try {
			ResultSet result = statement.executeQuery(builder.toString());
			if(result != null) {
				while(result.next()) {
					T obj = (T)model.getEntity().newInstance();
					obj.unpack(result);
					ts.add(obj);
				}
			}
		} catch (SQLException | InstantiationException | IllegalAccessException e) {
			propagate(e);
		}
		
		return ts;
	}

	@Override
	public void update(T t) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			propagate(e);
		}
		
		if(statement == null) {
			propagate(new SQLException());
			return;
		}
		
		Map<String, Object> values = t.pack();
		StringBuilder builder = new StringBuilder("UPDATE ");
		builder.append(tableName).append(" SET ");
		
		for(Entry<String,Object> entry : values.entrySet()) {
			builder.append(entry.getKey()).append(" = ").append(entry.getValue().toString()).append(", ");
		}
		
		builder.delete(builder.length() - 2, builder.length());
		
		builder.append(" WHERE ").append(model.getPrimaryKeyColumn()).append(" = ");
		
		try {
			builder.append(model.getPrimaryKey(t));
		} catch (IllegalArgumentException | IllegalAccessException e1) {
			propagate(e1);
		}
		
		try {
			statement.execute(builder.toString());
		} catch (SQLException e) {
			propagate(e);
		}
	}
}
