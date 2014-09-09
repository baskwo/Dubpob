package org.dubpob.base;

import org.dubpob.base.impl.RealBaseNumber;
import org.dubpob.base.impl.SimpleBaseNumber;

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
    	RealBaseNumber firstNumber = RealBaseNumber.fromBase((byte)42);
    	RealBaseNumber secondNumber = RealBaseNumber.fromBase((byte)11);
    	
    	long time = System.nanoTime();
    	
    	firstNumber.setDecVal(1649);
    	secondNumber.setDecVal(50);
    	
    	System.out.println(firstNumber.getValue());
    	System.out.println(secondNumber.getValue());
    	
    	firstNumber.mul(secondNumber);
    	
    	System.out.println(firstNumber.getValue());
    	
    	System.out.println(System.nanoTime() - time);
        assertEquals(82450, firstNumber.getDecVal());
    }
}
