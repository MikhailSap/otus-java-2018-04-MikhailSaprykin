package sap.mikhail.HW03;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Collections;

public class MyArrayListTest {

    @Test
    public void testForAddAll() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Collections.addAll(list, 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14);
        assertTrue(list.size() == 15);
    }

    @Test
    public void testForCopy() {
        MyArrayList<Integer> listA = new MyArrayList<>();
        MyArrayList<Integer> listB = new MyArrayList<>();

        Collections.addAll(listA, 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14);
        Collections.addAll(listB, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);

        Collections.copy(listB, listA);

        boolean check = true;
        for (int i=0; i<listA.size(); i++) {
            if (listA.get(i) != listB.get(i))
                check = false;
        }
        assertTrue(check);
    }

    @Test
    public void testForSort() {
        MyArrayList<Integer> list = new MyArrayList<>();

        Collections.addAll(list, 5,3,-6,2,567,23,87);
        Collections.sort(list);

        boolean check = true;
        int icheck = list.get(0);
        for (int i=1; i<list.size(); i++) {
            if (icheck > list.get(i))
                check = false;
            icheck = list.get(i);
        }
        assertTrue(check);

    }


}
