package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;

public class Lab_11Test extends TestCase {

    public Lab_11Test(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(Lab_11Test.class);
    }

    public void testSumOfGeometricProgression() {
        double expected = 2 * (1 - Math.pow(0.5, 10)) / (1 - 0.5);
        assertEquals(expected, Lab_11.sumOfGeometricProgression(2, 0.5, 10), 1e-6);
    }

    public void testQuadrant() {
        assertEquals(1, Lab_11.quadrant(1, 1));
        assertEquals(2, Lab_11.quadrant(-1, 1));
        assertEquals(3, Lab_11.quadrant(-1, -1));
        assertEquals(4, Lab_11.quadrant(1, -1));
        assertEquals(0, Lab_11.quadrant(0, 1)); // на осі
        assertEquals(0, Lab_11.quadrant(1, 0)); // на осі
    }

    public void testComputeProduct() {
        double result = Lab_11.computeProduct(3);
        double expected = (1 + 1.0 / 1) * (1 + 1.0 / 4) * (1 + 1.0 / 9);
        assertEquals(expected, result, 1e-6);
    }

    public void testGetPrimesUnder100() {
        List<Integer> primes = Lab_11.getPrimesUnder100();
        assertTrue(primes.contains(2));
        assertTrue(primes.contains(97));
        assertFalse(primes.contains(100));
        assertEquals(25, primes.size());
    }

    public void testPointsInsideTriangle() {
        List<int[]> points = Lab_11.pointsInsideTriangle();
        assertFalse(points.isEmpty());
        for (int[] point : points) {
            assertEquals(2, point.length);
        }
    }
}
