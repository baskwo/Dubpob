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
    	SimpleMatrix A = new SimpleMatrix(3,3);
    	
    	A.getMatrix()[0][0] = 1;
    	A.getMatrix()[0][1] = -1;
    	A.getMatrix()[0][2] = 1;
    	A.getMatrix()[1][0] = 2;
    	A.getMatrix()[1][1] = 0;
    	A.getMatrix()[1][2] = 4;
    	A.getMatrix()[2][0] = 9;
    	A.getMatrix()[2][1] = -1;
    	A.getMatrix()[2][2] = 1;

    	
    	SimpleMatrix result = MatrixHelper.getInverse(A);
    	
    	SimpleMatrix test = MatrixHelper.multiply(A, result);
    	
    	SimpleMatrix I = new SimpleMatrix(3,3);
    	
    	I.getMatrix()[0][0] = 1;
    	I.getMatrix()[0][1] = 0;
    	I.getMatrix()[0][2] = 0;
    	I.getMatrix()[1][0] = 0;
    	I.getMatrix()[1][1] = 1;
    	I.getMatrix()[1][2] = 0;
    	I.getMatrix()[2][0] = 0;
    	I.getMatrix()[2][1] = 0;
    	I.getMatrix()[2][2] = 1;
    	
        assertEquals(I.toString(), test.toString());
    }
}
