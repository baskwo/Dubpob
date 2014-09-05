package org.dubpob.matrix;

import java.util.logging.Level;

import org.dubpob.matrix.impl.SimpleMatrix;
import org.dubpob.matrix.utils.MatrixHelper;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    public AppTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    
    @SuppressWarnings("rawtypes")
	public void testApp()
    {
    	System.out.println(Level.SEVERE.getName());
    	String a = "1 1\n" + 
    			   "2 -1";
    	SimpleMatrix A = new SimpleMatrix(2,2,a);
    	
    	String b = "5\n" +
    			   "6";
    	SimpleMatrix B = new SimpleMatrix(2,1,b);
    	
    	TypeMatrix inverse = MatrixHelper.getInverse(A);
    	
    	TypeMatrix test = MatrixHelper.multiply(inverse, B);
    	
    	String i = ((float)11/3) + "\n" +
 			   	   ((float)4/3) + "";
    	SimpleMatrix I = new SimpleMatrix(2,1,i);
    	
        assertEquals(I.toString(), test.toString());
    }
}
