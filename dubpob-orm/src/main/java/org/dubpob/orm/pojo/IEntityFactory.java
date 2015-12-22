package org.dubpob.orm.pojo;

public interface EntityFactory {
	public boolean register(EntityModel model);
	public boolean createModel(Class<?> entity);
	public EntityModel getModel(Class<?> entity);
}
