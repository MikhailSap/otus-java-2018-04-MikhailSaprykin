package sap.mikhail.HW02;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

public class MyMesureTestClass {
    private String testString = "Hello";
    private Integer testInteger = 8;
    private int testInt = 123;
    private boolean testBoolean;

    public static void main(String[] args) {

        Object o = new Object();
        String s = "";
        int[] i = new int[0];
        int[] i1000 = new int[1000];
        String wms = "WhatIsMySize?";


        System.out.println("ObjectSize = " + ObjectSizeCalculator.getObjectSize(o));
        System.out.println("StrinEmptygSize = " + ObjectSizeCalculator.getObjectSize(s));
        System.out.println("ArrayEmptySize = " + ObjectSizeCalculator.getObjectSize(i));
        System.out.println("Array1000Size = " + ObjectSizeCalculator.getObjectSize(i1000));
        System.out.println("StringWMSSize = " + ObjectSizeCalculator.getObjectSize(wms));
        System.out.println("MyMesureTestSlassObjectSize = " + ObjectSizeCalculator.getObjectSize(new MyMesureTestClass()));


    }
}
