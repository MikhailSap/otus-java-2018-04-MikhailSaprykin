package sap.mikhail.HW08;

import com.google.gson.Gson;
import org.json.simple.JSONValue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;


public class TestMyJSON {

    MyJSON myParser = new MyJSON();
    Gson gParser = new Gson();

    @Test
    public void objectToJSON() {
        IGoToJson iGoToJson = new IGoToJson();
        String myResult;
        String gResult;

        myResult = myParser.toJSON(iGoToJson);
        gResult = gParser.toJson(iGoToJson);

        Object myCheck = JSONValue.parse(myResult);
        Object gCheck = JSONValue.parse(gResult);
        assertTrue(myCheck.equals(gCheck));
    }

    @Test
    public void primitiveToJSON() {
        String myResult;
        String gResult;

        myResult = myParser.toJSON(5.7);
        gResult = gParser.toJson(5.7);

        Object myCheck = JSONValue.parse(myResult);
        Object gCheck = JSONValue.parse(gResult);
        assertTrue(myCheck.equals(gCheck));
    }

    @Test
    public void arrayToJSON() {
        int[] array = {1,2,3};
        String myResult;
        String gResult;

        myResult = myParser.toJSON(array);
        gResult = gParser.toJson(array);

        Object myCheck = JSONValue.parse(myResult);
        Object gCheck = JSONValue.parse(gResult);
        assertTrue(myCheck.equals(gCheck));
    }

    @Test
    public void collectionToJSON() {
        List<IGoToJsonToo> list = new ArrayList<>();
        list.add(new IGoToJsonToo());
        String myResult;
        String gResult;

        myResult = myParser.toJSON(list);
        gResult = gParser.toJson(list);

        Object myCheck = JSONValue.parse(myResult);
        Object gCheck = JSONValue.parse(gResult);
        assertTrue(myCheck.equals(gCheck));
    }

    @Test
    public void mapToJSON() {
        HashMap<Integer, IGoToJsonToo> map = new HashMap<>();
        map.put(67,new IGoToJsonToo());
        map.put(88,new IGoToJsonToo());
        String myResult;
        String gResult;

        myResult = myParser.toJSON(map);
        gResult = gParser.toJson(map);

        System.out.println(myResult);
        System.out.println(gResult);

        Object myCheck = JSONValue.parse(myResult);
        Object gCheck = JSONValue.parse(gResult);
        assertTrue(myCheck.equals(gCheck));
    }
}
