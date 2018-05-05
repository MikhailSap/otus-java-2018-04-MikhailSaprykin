package sap.mikhail.HW03;


import java.util.Collections;


public class TestMyArrayList {
    public static void main(String[] args) {

        MyArrayList<Integer> listA = new MyArrayList<Integer>();
        MyArrayList<Integer> listB = new MyArrayList<Integer>();


        Collections.addAll(listA, -10,45,70,3,5,7,8,9,13,12,45,56,676787,1,2,3,4,5,6,7,8,9,1,2,3,
                                                      4,5,6,7,8,9,1,2,3,4,5,4,3,2,1,1,3,4,5,123,22,44,555,0);

        Collections.addAll(listB, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                                   0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);

        System.out.print("listA after addAll() ");
        for(int x : listA) {
            System.out.print(x + " ");
        }
        System.out.println();

        System.out.print("listB after addAll() ");
        for(int x : listB) {
            System.out.print(x + " ");
        }
        System.out.println();

        Collections.copy(listB, listA);

        System.out.print("listB after copy() ");
        for(int x : listB) {
            System.out.print(x + " ");
        }
        System.out.println();


        Collections.sort(listA, new MyComparator<Integer>());

        System.out.print("listA after sort() ");
        for(int x : listA) {
            System.out.print(x + " ");
        }













    }
}
