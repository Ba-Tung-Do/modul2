import org.junit.Test;
import static org.junit.Assert.*;

public class NextDayCalculatorTest {
    @Test
    public void test1_1_2018() {
        assertEquals("2/1/2018", NextDayCalculator.findNextDay(1, 1, 2018));
    }

    @Test
    public void test31_1_2018() {
        assertEquals("1/2/2018", NextDayCalculator.findNextDay(31, 1, 2018));
    }

    @Test
    public void test28_2_2018() {
        assertEquals("1/3/2018", NextDayCalculator.findNextDay(28, 2, 2018));
    }

    @Test
    public void test29_2_2020() {
        assertEquals("1/3/2020", NextDayCalculator.findNextDay(29, 2, 2020));
    }

    @Test
    public void test31_12_2019() {
        assertEquals("1/1/2020", NextDayCalculator.findNextDay(31, 12, 2019));
    }
}
