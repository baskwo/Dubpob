package org.dubpob.orm.pojo;

import java.lang.reflect.Field;

import org.dubpob.orm.annotations.ColumnName;
import org.dubpob.orm.annotations.Id;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;

public class Metadata {
	private Field field = null;
	
	public static final Attribute<Metadata, String> META_NAME = new SimpleAttribute<Metadata, String>("name") {
        public String getValue(Metadata meta) { return meta.getColumnName(); }};
    public static final Attribute<Metadata, Boolean> META_PRIMARY = new SimpleAttribute<Metadata, Boolean>("primary") {
        public Boolean getValue(Metadata meta) { return meta.isPrimary(); }};
	
	public Metadata(Field field) {
		this.field = field;
	}
	
	public String getFieldName() {
		return field.getName();
	}
	
	public String getColumnName() {
		ColumnName name = field.getAnnotation(ColumnName.class);
		if(name != null)
			return name.name();
		return getFieldName();
	}

	public boolean isPrimary() {
		return field.getAnnotation(Id.class) != null;
	}
	
	public Object value(Object obj) throws IllegalArgumentException, IllegalAccessException {
		return field.get(obj);
	}
}
