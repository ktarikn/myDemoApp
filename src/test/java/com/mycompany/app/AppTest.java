package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

     public void testZeroTimes() {
        int[] temp = new int[]{32,4,12};
        ArrayList<Integer> vector1 = new ArrayList<>();
        for (int integer : temp) {
          vector1.add(integer);
        }
        temp = new int[]{3,4,32};
        ArrayList<Integer> vector2 = new ArrayList<>();
        for (int integer : temp) {
          vector2.add(integer);
        }
        
        int[] array = App.vectorMultipication(vector1, vector2, true, 0);
        assertTrue(array.length==1);
        assertEquals(array[0],1);
      }
  
      public void testNullVector() {
        int []temp = new int[]{3,4,32};
        ArrayList<Integer> vector2 = new ArrayList<>();
        for (int integer : temp) {
          vector2.add(integer);
        }
        int[] array = App.vectorMultipication(null,vector2, true, 1);
        assertTrue(array.length==1);
        assertEquals(array[0],0);
      }
  
      public void testEmptyVector() {
        int []temp = new int[]{3,4,32};
        ArrayList<Integer> vector2 = new ArrayList<>();
        for (int integer : temp) {
          vector2.add(integer);
        }
        int[] array = App.vectorMultipication(new ArrayList<>(), vector2, true, 1);
        assertTrue(array == null);
        
      }
  
      public void testInner() {
        int[] temp = new int[]{1,2,2};
        ArrayList<Integer> vector1 = new ArrayList<>();
        for (int integer : temp) {
          vector1.add(integer);
        }
        temp = new int[]{3,2,2};
        ArrayList<Integer> vector2 = new ArrayList<>();
        for (int integer : temp) {
          vector2.add(integer);
        }
        int[] array = App.vectorMultipication(vector1,vector2, true, 1);
        assertTrue(array.length==1);
        assertEquals(array[0],11);
      }
      public void testInnerTwice() {
        int[] temp = new int[]{1,2,2};
        ArrayList<Integer> vector1 = new ArrayList<>();
        for (int integer : temp) {
          vector1.add(integer);
        }
        temp = new int[]{3,2,2};
        ArrayList<Integer> vector2 = new ArrayList<>();
        for (int integer : temp) {
          vector2.add(integer);
        }
        int[] array = App.vectorMultipication(vector1,vector2, true, 2);
        assertTrue(array.length==1);
        assertEquals(array[0],22);
      }
      public void testOuter() {
        int[] temp = new int[]{1,2,2};
        ArrayList<Integer> vector1 = new ArrayList<>();
        for (int integer : temp) {
          vector1.add(integer);
        }
        temp = new int[]{3,2,2};
        ArrayList<Integer> vector2 = new ArrayList<>();
        for (int integer : temp) {
          vector2.add(integer);
        }
        int[] array = App.vectorMultipication(vector1,vector2, false, 1);
        assertTrue(array.length==9);
        int[] answer =  new int[]{3,2,2,6,4,4,6,4,4};
        for (int i = 0; i < answer.length; i++) {
          assertEquals(array[i],answer[i]);
        }
      }


      public void testOuterTwice() {
        int[] temp = new int[]{1,2};
        ArrayList<Integer> vector1 = new ArrayList<>();
        for (int integer : temp) {
          vector1.add(integer);
        }
        temp = new int[]{3,2};
        ArrayList<Integer> vector2 = new ArrayList<>();
        for (int integer : temp) {
          vector2.add(integer);
        }
        int[] array = App.vectorMultipication(vector1,vector2, false, 2);
        assertTrue(array.length==8);
        // 3,2 ,6,4 for once
        int[] answer =  new int[]{9,6,6,4,18,12,12,8};
        
        for (int i = 0; i < array.length; i++) {
          assertEquals(array[i],answer[i]);
        }
      }
    /**
     * Rigourous Test :-)
     */
   
}
