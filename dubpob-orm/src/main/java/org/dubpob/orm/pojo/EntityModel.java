package org.dubpob.orm.pojo;

import static com.google.common.base.Throwables.propagate;

import java.lang.reflect.Field;
import java.util.Map;

import org.dubpob.orm.annotations.Skip;
import org.dubpob.orm.exceptions.EntityNotMappedException;

import com.google.common.collect.Maps;

public class EntityModel {
	private Class<?> entity = null;
	private Map<String,Metadata> metadatas = Maps.newHashMap();
	
	public EntityModel(Class<?> entity) {
		this.entity = entity;
	}
	
	public boolean buildMetadata() {
		Field[] fields = entity.getDeclaredFields();
		boolean result = true;
		for(Field field : fields) {
			if(field.getAnnotation(Skip.class) != null)
				continue;
			try {
				Metadata metadata = new Metadata(field);
				metadatas.put(field.getName(), metadata);
			} catch (EntityNotMappedException e) {
				propagate(e);
				result = false;
				break;
			}
			
		}
		return result;
	}

	public Class<?> getEntity() {
		return entity;
	}

	public void setEntity(Class<?> entity) {
		this.entity = entity;
	}

	public Map<String,Metadata> getMetadatas() {
		return metadatas;
	}

	public void setMetadatas(Map<String,Metadata> metadatas) {
		this.metadatas = metadatas;
	}
}
