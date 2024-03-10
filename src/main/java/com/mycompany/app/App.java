package com.mycompany.app;

import java.util.Arrays;
import java.util.ArrayList;
import main.java.com.mycompany.app.methods;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        int[] arr = {14,234,123,54,6,31,42,69,42};
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : arr){
            list.add(i);
        }
        search(list, 42);
    }
    public static boolean search(ArrayList<Integer> array, int e) {
        System.out.println("inside search");
        if (array == null) return false;
    
        for (int elt : array) {
          if (elt == e) return true;
        }
        return false;
    }
   
  
}
