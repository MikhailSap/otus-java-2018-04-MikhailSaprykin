package sap.mikhail.HW08;

import java.util.HashMap;

public class IGoToJsonToo {
    int y = 10;
    private transient String lol = "lol";
    private HashMap<String, Integer> map = new HashMap<>();

    public IGoToJsonToo() {
        map.put("Vasya", 45);
        map.put("Lena", 37);
    }
}
