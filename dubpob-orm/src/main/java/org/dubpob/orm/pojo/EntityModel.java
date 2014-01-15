package org.dubpob.orm.pojo;

public class EntityModel {
	private Class<?> entity = null;
	
	public EntityModel(Class<?> entity) {
		this.entity = entity;
	}
	
	public boolean buildMetadata() {
		return true;
	}

	public Class<?> getEntity() {
		return entity;
	}

	public void setEntity(Class<?> entity) {
		this.entity = entity;
	}
}
