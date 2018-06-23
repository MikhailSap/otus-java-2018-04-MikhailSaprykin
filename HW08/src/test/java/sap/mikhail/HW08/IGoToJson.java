package sap.mikhail.HW08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IGoToJson extends Father{
    private Integer integer = null;
    private transient Double aDouble = 5.6;
    private Byte aByte = 100;
    private boolean b = true;
    private char ch = 'h';
    private int[] array = {4,2,1};
    private List<Integer[]> list = new ArrayList<>();
    private HashMap<Integer, Integer> map = new HashMap<>();
    private IGoToJsonToo g = new IGoToJsonToo();

    public IGoToJson() {
        Integer[] x = {1};
        Integer[] y = {3,4};
        Integer[] z = {8,7,6};
        list.add(x);
        list.add(y);
        list.add(z);

        map.put(7, 8);
        map.put(1, 0);
        map.put(5, 10000);
    }
}
