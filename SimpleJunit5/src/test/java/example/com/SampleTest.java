package example.com;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Junit 5 sample test
 *
 */
public class SampleTest {

    public SampleTest() {
    }

    @BeforeAll
    public static void setUpAll() {
        System.out.println("once at the start");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("before every test");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("after every test");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("once at the end");
    }

    @Test
    public void test1division() {
        System.out.println("@Test - divison");
        double d = 1.0 / 8.0;
        assertEquals(0.125, d, 0);
    }

    @Test()
    public void test2divisionWithException() {
        System.out.println("@Test - divisonbyzero");
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            int i = 1 / 0;
        });
    }

}
