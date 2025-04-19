import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    @Test
    public void testDivisibleBy3() {
        assertEquals("Fizz", FizzBuzz.checkFizzBuzz(9));
    }

    @Test
    public void testDivisibleBy5() {
        assertEquals("Buzz", FizzBuzz.checkFizzBuzz(10));
    }

    @Test
    public void testDivisibleBy3And5() {
        assertEquals("FizzBuzz", FizzBuzz.checkFizzBuzz(15));
    }

    @Test
    public void testNotDivisibleBy3Or5() {
        assertEquals("7", FizzBuzz.checkFizzBuzz(7));
    }

    @Test
    public void testInvalidInput() {
        assertEquals("Invalid input", FizzBuzz.checkFizzBuzz(0));
    }
}
