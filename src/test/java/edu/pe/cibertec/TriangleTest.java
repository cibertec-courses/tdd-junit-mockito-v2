package edu.pe.cibertec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static edu.pe.cibertec.Triangle.TriangleType.EQUILATERAL;
import static edu.pe.cibertec.Triangle.TriangleType.ISOSCELES;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Triangle - Triangle Classifier")
public class TriangleTest {
    private Triangle  triangle;

    @BeforeEach
    void setUp(){
        triangle = new Triangle();
    }

    @Test
    @DisplayName("Three equal sides return EQUILATERAL")
    void givenThreeEqualSides_whenClassify_thenEquilateral(){
        assertEquals(EQUILATERAL, triangle.classfy(4,4,4));
    }

    @Test
    @DisplayName("Two equal sides returns ISOSCELES")
    void givenTwoEqualSides_whenClassfiy_thenIsosceles(){
        assertEquals(ISOSCELES, triangle.classfy(5,5,4));
    }

}
