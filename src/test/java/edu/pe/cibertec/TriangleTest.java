package edu.pe.cibertec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static edu.pe.cibertec.Triangle.TriangleType.*;
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
    void givenTwoEqualSides_whenClassify_thenIsosceles(){
        assertEquals(ISOSCELES, triangle.classfy(5,5,4));
    }

    @Test
    @DisplayName("Two equal sides returns SCALENE")
    void givenTwoEqualSides_whenClassify_thenScalene(){
        assertEquals(SCALENE, triangle.classfy(6,5,4));
    }

    @Test
    @DisplayName("Side equal to sum of other two returns INVALID")
     void givenSideEqualToSumOfOtherTwo_whenClassify_thenInvalid(){
        assertEquals(INVALID, triangle.classfy(1,2,3));
    }

    @Test
    @DisplayName("Side greater than sum of other two returns INVALID")
    void givenSideEqualToGraterThanSumOfOtherTwo_whenClassify_thenInvalid(){
        assertEquals(INVALID, triangle.classfy(1,2,10));
    }

    @Test
    @DisplayName("Side with zero value returns INVALID")
    void givenZeroSide_whenClassify_thenInvalid(){
        assertEquals(INVALID, triangle.classfy(8,0,8));
    }

    @Test
    @DisplayName("Side with negative value returns INVALID")
    void givenNegativeSide_whenClassify_thenInvalid(){
        assertEquals(INVALID, triangle.classfy(8,-4,8));
    }

}
