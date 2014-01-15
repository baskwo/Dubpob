package org.dubpob.orm.pojo.impl;

import java.util.Map;

import org.dubpob.orm.annotations.Entity;
import org.dubpob.orm.exceptions.EntityAlreadyMappedException;
import org.dubpob.orm.exceptions.EntityNotMappedException;
import org.dubpob.orm.pojo.EntityFactory;
import org.dubpob.orm.pojo.EntityModel;

import com.google.common.collect.Maps;

import static com.google.common.base.Throwables.propagate;

public class SimpleEntityFactory implements EntityFactory{
	private Map<Class<?>,EntityModel> models = Maps.newHashMap();

	public boolean register(EntityModel model) {
		if(!models.containsKey(model.getEntity())) {
			propagate(new EntityAlreadyMappedException());
			return false;
		}
		models.put(model.getEntity(), model);
		return true;
	}

	public boolean createModel(Class<?> entity) {
		if(entity.getAnnotation(Entity.class) != null) {
			EntityModel model = new EntityModel(entity);
			if(!model.buildMetadata())
				return false;
			return register(model);
		}
		return false;
	}

	public EntityModel getModel(Class<?> entity) {
		if(!models.containsKey(entity)) {
			propagate(new EntityNotMappedException());
			return null;
		}
		return models.get(entity);
	}

}
