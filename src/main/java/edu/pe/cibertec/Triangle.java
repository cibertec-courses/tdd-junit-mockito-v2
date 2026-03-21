package edu.pe.cibertec;

public class Triangle {



    public enum TriangleType{
        EQUILATERAL,
        ISOSCELES,
        SCALENE,
        INVALID
    }

    public TriangleType classfy(int a, int b, int c) {
        if(a ==b & b==c){
            return TriangleType.EQUILATERAL;
        }
        return TriangleType.SCALENE;
    }

}
