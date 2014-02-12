package org.dubpob.orm.pojo;

import java.lang.reflect.Field;

import org.dubpob.orm.exceptions.EntityNotMappedException;

public class Metadata {
	
	public Metadata(Field field) throws EntityNotMappedException{
		if(!build(field))
			throw new EntityNotMappedException();
	}
	
	private boolean build(Field field) {
		return true;
	}
}
