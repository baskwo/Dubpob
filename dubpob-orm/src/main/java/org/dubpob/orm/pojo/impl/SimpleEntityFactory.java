package org.dubpob.orm.pojo.impl;

import org.dubpob.orm.annotations.Entity;
import org.dubpob.orm.exceptions.EntityAlreadyMappedException;
import org.dubpob.orm.exceptions.EntityNotMappedException;
import org.dubpob.orm.pojo.EntityFactory;
import org.dubpob.orm.pojo.EntityModel;

import com.googlecode.cqengine.CQEngine;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.index.unique.UniqueIndex;
import com.googlecode.cqengine.resultset.ResultSet;

import static com.google.common.base.Throwables.propagate;
import static com.googlecode.cqengine.query.QueryFactory.*;

public class SimpleEntityFactory implements EntityFactory{
	private IndexedCollection<EntityModel> models = CQEngine.newInstance();
	
	public SimpleEntityFactory() {
		models.addIndex(UniqueIndex.onAttribute(EntityModel.MODEL_CLASS));
	}

	public boolean register(EntityModel model) {
		if(getModel(model.getEntity()) != null) {
			propagate(new EntityAlreadyMappedException());
			return false;
		}
		models.add(model);
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
		EntityModel em = null;
		ResultSet<EntityModel> rs = models.retrieve(equal(EntityModel.MODEL_CLASS,entity));
		if(rs != null && rs.isNotEmpty())
			em = rs.uniqueResult();
		else {
			propagate(new EntityNotMappedException());
		}
		return em;
	}

}
