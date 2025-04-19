public class TriangleClassifier {

    public static String classifyTriangle(int a, int b, int c) {
        // Kiểm tra nếu không phải tam giác
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            return "không phải là tam giác";
        }

        // Tam giác đều
        if (a == b && b == c) {
            return "tam giác đều";
        }

        // Tam giác cân
        if (a == b || a == c || b == c) {
            return "tam giác cân";
        }

        // Tam giác thường
        return "tam giác thường";
    }
}
