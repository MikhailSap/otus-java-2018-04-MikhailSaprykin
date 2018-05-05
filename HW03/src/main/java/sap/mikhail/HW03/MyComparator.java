package sap.mikhail.HW03;

import java.util.Comparator;

public class MyComparator<T> implements Comparator<T> {

    public int compare(T o1, T o2) {
        if ((Integer)o1 > (Integer)o2)
            return 1;
        else if ((Integer)o1 < (Integer)o2)
            return -1;
        else
            return 0;
    }
}
