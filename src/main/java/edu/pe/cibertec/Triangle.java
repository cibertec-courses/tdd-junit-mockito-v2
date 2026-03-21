package edu.pe.cibertec;

public class Triangle {


    public enum TriangleType {
        EQUILATERAL,
        ISOSCELES,
        SCALENE,
        INVALID
    }

    public TriangleType classfy(int a, int b, int c) {
        if (!isValid(a, b, c)) {
            return TriangleType.INVALID;
        }
        if (a == b && b == c) {
            return TriangleType.EQUILATERAL;
        }
        if (a == b || b == c || a == c) {
            return TriangleType.ISOSCELES;
        }
        return TriangleType.SCALENE;
    }

    private boolean isValid(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return false;
        return (a < b + c) && (b < a + c) && (c < a + b);
    }

}
