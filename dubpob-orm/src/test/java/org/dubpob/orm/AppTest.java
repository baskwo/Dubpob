package org.dubpob.orm;

import java.util.List;

import org.dubpob.orm.annotations.ColumnName;
import org.dubpob.orm.annotations.Entity;
import org.dubpob.orm.annotations.Id;
import org.dubpob.orm.annotations.Skip;
import org.dubpob.orm.pojo.EntityModel;
import org.dubpob.orm.pojo.IEntityFactory;
import org.dubpob.orm.pojo.impl.SimpleEntityFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {
	
    public AppTest( String testName ) {
        super( testName );
    }
    
    public static Test suite() {
        return new TestSuite( AppTest.class );
    }
    
    public void testApp() {
    	IEntityFactory factory = new SimpleEntityFactory();
    	assertTrue(factory.createModel(Dummy.class));
    	
    	EntityModel model = factory.getModel(Dummy.class);
    	assertEquals(1, model.getMetadatas().size());
    }
    
    @Entity
    private static class Dummy {
    	@Id
    	private int id;
    	@ColumnName(name = "name")
    	private String dummyName;
    	@Skip
    	private List<Object> objects;

		@SuppressWarnings("unused")
		public int getId() {
			return id;
		}

		@SuppressWarnings("unused")
		public void setId(int id) {
			this.id = id;
		}

		@SuppressWarnings("unused")
		public String getDummyName() {
			return dummyName;
		}

		@SuppressWarnings("unused")
		public void setDummyName(String dummyName) {
			this.dummyName = dummyName;
		}
    }
}
