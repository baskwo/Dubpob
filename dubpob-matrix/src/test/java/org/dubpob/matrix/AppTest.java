package org.dubpob.matrix;

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
    
    public void testApp()
    {
    	SimpleMatrix A = new SimpleMatrix(2,3);
    	SimpleMatrix B = new SimpleMatrix(3,2);
    	
    	A.getMatrix()[0][0] = 1;
    	A.getMatrix()[0][1] = 2;
    	A.getMatrix()[0][2] = 3;
    	A.getMatrix()[1][0] = 4;
    	A.getMatrix()[1][1] = 5;
    	A.getMatrix()[1][2] = 6;
    	
    	B.getMatrix()[0][0] = 7;
    	B.getMatrix()[0][1] = 8;
    	B.getMatrix()[1][0] = 9;
    	B.getMatrix()[1][1] = 10;
    	B.getMatrix()[2][0] = 11;
    	B.getMatrix()[2][1] = 12;
    	
    	SimpleMatrix result = MatrixHelper.multiply(A, B);
    	
    	System.out.println(result.toString());
    	
        assertEquals(36, result.getDeterminant());
    }
}
