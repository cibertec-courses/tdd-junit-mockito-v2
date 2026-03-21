package edu.pe.cibertec;

public class Triangle {


    public enum TriangleType {
        EQUILATERAL,
        ISOSCELES,
        SCALENE,
        INVALID
    }

    public TriangleType classfy(int a, int b, int c) {
        if (a == b && b == c) {
            return TriangleType.EQUILATERAL;
        }
        if (a == b || b == c || a == c  ){
            return  TriangleType.ISOSCELES;
        }
        return TriangleType.SCALENE;
    }

}
