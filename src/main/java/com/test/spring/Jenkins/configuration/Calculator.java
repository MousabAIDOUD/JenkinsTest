package com.test.spring.Jenkins.configuration;

public class Calculator {

    public static int sum(int a, int b ){
        return  a+b;
    }
    public static int multiple(int a, int b ){
        return  a*b;
    }
    public static float divison(int a, int b ){
        if (b == 0){
            return 0;
        }
        return a/b;
    }
    public static float sous(int a, int b ){
        return  (float)a-b;
    }
}
