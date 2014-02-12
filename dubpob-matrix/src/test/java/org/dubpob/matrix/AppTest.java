package org.dubpob.matrix;

import org.dubpob.matrix.impl.SimpleMatrix;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	SimpleMatrix matrix = new SimpleMatrix(3,3);
    	matrix.getMatrix()[0][0] = -1;
    	matrix.getMatrix()[0][1] = 2;
    	matrix.getMatrix()[0][2] = 4;
    	matrix.getMatrix()[1][0] = 0;
    	matrix.getMatrix()[1][1] = 7;
    	matrix.getMatrix()[1][2] = 8;
    	matrix.getMatrix()[2][0] = 1;
    	matrix.getMatrix()[2][1] = 1;
    	matrix.getMatrix()[2][2] = 0;
    	
        assertEquals(-4, matrix.getDeterminant());
    }
}
