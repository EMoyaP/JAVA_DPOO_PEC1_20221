package edu.uoc.pac1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PAC1Ex2Test {


    @Test
    void testStepForward1() {
        assertEquals(1,PAC1Ex2.stepForward(0,1,3));
        assertEquals(2,PAC1Ex2.stepForward(0,2,3));
        assertEquals(0,PAC1Ex2.stepForward(1,2,3));
        assertEquals(1,PAC1Ex2.stepForward(2,2,3));
        assertEquals(2,PAC1Ex2.stepForward(2,3,3));
        assertEquals(0,PAC1Ex2.stepForward(0,0,3));

        assertEquals(3,PAC1Ex2.stepForward(0,3,7));
        assertEquals(6,PAC1Ex2.stepForward(3,3,7));
        assertEquals(2,PAC1Ex2.stepForward(6,3,7));
        assertEquals(5,PAC1Ex2.stepForward(2,3,7));

        assertEquals(-1,PAC1Ex2.stepForward(-2,3,7));
        assertEquals(-1,PAC1Ex2.stepForward(-2,-3,7));
        assertEquals(-1,PAC1Ex2.stepForward(2,-3,7));
        assertEquals(-1,PAC1Ex2.stepForward(7,3,7));
        assertEquals(-1,PAC1Ex2.stepForward(8,3,7));
        assertEquals(1,PAC1Ex2.stepForward(1,0,7));
    }

    @Test
    void testStepForward2() {
        assertArrayEquals(new int[]{1,2},PAC1Ex2.stepForward(0,1,0,2,3));
        assertArrayEquals(new int[]{0,1},PAC1Ex2.stepForward(1,2,2,2,3));
        assertArrayEquals(new int[]{2,0},PAC1Ex2.stepForward(2,3,0,0,3));

        assertArrayEquals(new int[]{3,6},PAC1Ex2.stepForward(0,3,3,3,7));
        assertArrayEquals(new int[]{2,5},PAC1Ex2.stepForward(6,3,2,3,7));

        assertArrayEquals(new int[]{-1,-1},PAC1Ex2.stepForward(-2,3,-2,-3,7));
        assertArrayEquals(new int[]{-1,-1},PAC1Ex2.stepForward(2,-3,7,3,7));
        assertArrayEquals(new int[]{-1,2},PAC1Ex2.stepForward(8,3,2,0,7));
    }

    @Test
    void testWhenTheyMeet() {
        assertArrayEquals(new int[]{1,0},PAC1Ex2.whenTheyMeet(0,0,0,0,8));
        assertArrayEquals(new int[]{1,0},PAC1Ex2.whenTheyMeet(0,0,7,1,8));
        assertArrayEquals(new int[]{1,2},PAC1Ex2.whenTheyMeet(0,2,1,1,8));
        assertArrayEquals(new int[]{2,3},PAC1Ex2.whenTheyMeet(1,1,6,2,7));
        assertArrayEquals(new int[]{3,3},PAC1Ex2.whenTheyMeet(0,1,2,2,5));
        assertArrayEquals(new int[]{-1,-1},PAC1Ex2.whenTheyMeet(0,-2,1,1,8));
        assertArrayEquals(new int[]{-1,-1},PAC1Ex2.whenTheyMeet(-10,2,1,1,8));
        assertArrayEquals(new int[]{-1,-1},PAC1Ex2.whenTheyMeet(10,2,1,1,8));
        assertArrayEquals(new int[]{-1,-1},PAC1Ex2.whenTheyMeet(7,2,-1,1,8));
    }
}
