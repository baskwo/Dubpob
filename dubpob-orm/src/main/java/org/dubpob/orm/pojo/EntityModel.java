package org.dubpob.orm.pojo;

import static com.google.common.base.Throwables.propagate;

import java.lang.reflect.Field;

import org.dubpob.orm.annotations.Skip;

import com.googlecode.cqengine.CQEngine;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.index.unique.UniqueIndex;

public class EntityModel {
	private Class<?> entity = null;
	private IndexedCollection<Metadata> metadatas = CQEngine.newInstance();
	
	public static final Attribute<EntityModel, Class<?>> MODEL_CLASS = new SimpleAttribute<EntityModel, Class<?>>("class") {
        public Class<?> getValue(EntityModel model) { return model.entity; }};
	
	public EntityModel(Class<?> entity) {
		this.entity = entity;
		metadatas.addIndex(UniqueIndex.onAttribute(Metadata.META_NAME));
	}
	
	public boolean buildMetadata() {
		Field[] fields = entity.getDeclaredFields();
		boolean result = true;
		for(Field field : fields) {
			if(field.getAnnotation(Skip.class) != null)
				continue;
				Metadata metadata = new Metadata(field);
				metadatas.add(metadata);
			
		}
		return result;
	}

	public Class<?> getEntity() {
		return entity;
	}

	public void setEntity(Class<?> entity) {
		this.entity = entity;
	}

	public IndexedCollection<Metadata> getMetadatas() {
		return metadatas;
	}

	public void setMetadatas(IndexedCollection<Metadata> metadatas) {
		this.metadatas = metadatas;
	}
}
