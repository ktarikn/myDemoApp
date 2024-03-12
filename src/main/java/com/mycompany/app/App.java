package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;



/**
 * Hello world!
 *
 */
public class App 
{
    /* 
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
    */
    public static int[] vectorMultipication(ArrayList<Integer> vector1, ArrayList<Integer> vector2, boolean inner, int times) {
        if(vector1 == null || vector2 == null) return new int[]{0};
        if(times <= 0) return new int[]{1};
        if(inner){
          int sum =0;
          if(vector1.size()!= vector2.size()) return null;
          for(int i = 0;i<vector1.size();i++){
            sum+=vector1.get(i) * vector2.get(i);
          }
          return new int[]{sum*times};
          
        }
        else{
          int[] matrix = new int[vector1.size()*vector2.size()];
          for(int i = 0;i<vector1.size();i++){
            for (int j = 0; j < vector2.size(); j++) {
              matrix[i*vector2.size()+ j] = vector1.get(i)*vector2.get(j);
            }
          }
          if(times ==1) return matrix;
          ArrayList<Integer> matrixList = new ArrayList<>();
          for (int integer : matrix) {
            matrixList.add(integer);
          }
          return vectorMultipication(matrixList, vector2, inner, times-1);
        }
    }
    
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World123");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          System.out.println(inputList);


          
          String input2 = req.queryParams("input2");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> input2List = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            input2List.add(value);
          }
          System.out.println(input2List);

          String input3 = req.queryParams("input3");
          boolean param3 = input3.equals("inner");

          String input4 = req.queryParams("input4");
          int param4 = Integer.parseInt(input4);
          int[] result = App.vectorMultipication(inputList, input2List,param3,param4);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}

   
  

