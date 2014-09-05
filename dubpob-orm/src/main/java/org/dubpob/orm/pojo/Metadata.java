package org.dubpob.orm.pojo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.dubpob.orm.annotations.Id;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;

public class Metadata {
	private String name = "";
	private boolean isPrimary = false;
	
	public static final Attribute<Metadata, String> META_NAME = new SimpleAttribute<Metadata, String>("name") {
        public String getValue(Metadata meta) { return meta.name; }};
	
	public Metadata(Field field) {
		this.name = field.getName();
	}
	
	public boolean build(Field field) {
		boolean succeed = false;
		for(Annotation annot : field.getAnnotations()) {
			if (annot.annotationType().isAssignableFrom(Id.class)) {
				setPrimary(true);
				succeed = true;
			}
		}
		return succeed;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
}
