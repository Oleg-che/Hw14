package com.cherednik;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Method name");
        String name = scanner.nextLine();
        System.out.println("Enter first count");
        int a = scanner.nextInt();
        System.out.println("Enter last count");
        int b = scanner.nextInt();
        getClazz(name, calculator, a, b);
    }

    private static void getClazz(String name, Calculator calculator, int a, int b) {
        Class clazz = calculator.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        Method method = null;
        for (Method value : methods) {
            if (value.getName().equals(name)) {
                method = value;
                break;
            }
        }
        try {
            assert method != null;
            double res = (double) method.invoke(calculator, a, b);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
