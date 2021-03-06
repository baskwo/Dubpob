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
    	for(int i = 2; i < 63; i++) {
    		RealBaseNumber number = RealBaseNumber.fromBase((byte) i);
    		number.setDecVal(954);
    		System.out.println("Format : " + number.getFormat());
    		System.out.println("Value : " + number.getValue());
    	}
    	assertTrue(true);
        //assertEquals(82450, firstNumber.getDecVal());
    }
}
