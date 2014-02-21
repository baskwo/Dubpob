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
    	SimpleMatrix A = new SimpleMatrix(2,2);
    	
    	A.getMatrix()[0][0] = 1;
    	A.getMatrix()[0][1] = 1;
    	A.getMatrix()[1][0] = 2;
    	A.getMatrix()[1][1] = -1;
    	
    	SimpleMatrix B = new SimpleMatrix(2,1);
    	
    	B.getMatrix()[0][0] = 5;
    	B.getMatrix()[1][0] = 6;
    	
    	SimpleMatrix inverse = MatrixHelper.getInverse(A);
    	
    	SimpleMatrix test = MatrixHelper.multiply(inverse, B);
    	
    	SimpleMatrix I = new SimpleMatrix(2,1);
    	
    	I.getMatrix()[0][0] = (float)11/3;
    	I.getMatrix()[1][0] = (float)4/3;
    	
        assertEquals(I.toString(), test.toString());
    }
}
