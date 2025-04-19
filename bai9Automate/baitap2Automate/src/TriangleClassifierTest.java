import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TriangleClassifierTest {

    @Test
    public void testEquilateralTriangle() {
        assertEquals("tam giác đều", TriangleClassifier.classifyTriangle(2, 2, 2));
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals("tam giác cân", TriangleClassifier.classifyTriangle(2, 2, 3));
    }

    @Test
    public void testNormalTriangle() {
        assertEquals("tam giác thường", TriangleClassifier.classifyTriangle(3, 4, 5));
    }

    @Test
    public void testNotATriangle1() {
        assertEquals("không phải là tam giác", TriangleClassifier.classifyTriangle(8, 2, 3));
    }

    @Test
    public void testNotATriangle2() {
        assertEquals("không phải là tam giác", TriangleClassifier.classifyTriangle(0, 1, 1));
    }
}
