package example.com;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Junit 4 sample test
 *
 */
public class SampleTest {

    public SampleTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("once at the start");
    }

    @Before
    public void setUp() {
        System.out.println("before every test");
    }

    @After
    public void tearDown() {
        System.out.println("after every test");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("once at the end");
    }

    @Test
    public void test1division() {
        System.out.println("@Test - divison");
        double d = 1.0 / 8.0;
        assertEquals(0.125, d, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void test2divisionWithException() {
        System.out.println("@Test - divisonbyzero");
        int i = 1 / 0;
    }

}
