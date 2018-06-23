package sap.mikhail.HW08;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class MyJSON {
    public String toJSON(Object o) {
        Object postParse = parser(o);
        if (postParse instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) postParse;
            return jsonObject.toJSONString();
        } else return JSONValue.toJSONString(postParse);
    }

    private Object parser(Object o) {
        String whatIsIt;
        Object result = null;
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        String isObject = JSONValue.toJSONString(o);
        if (o.getClass().isArray()) {
            whatIsIt = "isArray";
        } else
        if (o instanceof Iterable) {
            whatIsIt = "isIterable";
        } else
        if (o instanceof Map) {
            whatIsIt = "isMap";
        } else
        if (isObject.contains("@") && !(o instanceof String)) {
            whatIsIt = "isObject";
        } else {whatIsIt = "Other";}

        switch (whatIsIt) {
            case "isArray": {
                for (int i = 0 ; i < Array.getLength(o) ; i++) {
                    jsonArray.add(parser(Array.get(o, i)));
                }
                result = jsonArray;
            } break;
            case "isIterable": {
                Iterator iterator = ((Iterable)o).iterator();
                while (iterator.hasNext()) {
                    jsonArray.add(parser(iterator.next()));
                }
                result = jsonArray;
            } break;
            case "isMap": {
                Map map = (Map) o;
                boolean checkKey = false;
                for (Object key : map.keySet()) {
                    if (key.toString().contains("@") && !(key instanceof String))
                        checkKey =true;
                    break;
                }
                map.forEach((k, v) -> {jsonObject.put(parser(k), parser(v));});
                if (checkKey)
                    result = map;
                else
                    result = jsonObject;
            } break;
            case "isObject": {
                List<Field> fields = new ArrayList<>();
                if (o.getClass().getSuperclass() != null)
                    Collections.addAll(fields, o.getClass().getSuperclass().getDeclaredFields());
                Collections.addAll(fields, o.getClass().getDeclaredFields());
                for (Field field : fields) {
                    if (Modifier.isTransient(field.getModifiers()))
                        continue;
                    field.setAccessible(true);
                    try {
                        Object value = field.get(o);
                        jsonObject.put(field.getName(), parser(value));
                    } catch (Exception e) {};
                }
                result = jsonObject;
            } break; 
            case "Other": {
                if (o.getClass().equals(Character.class))
                    result = Character.toString((char)o);
                else
                    result = o;
            } break;
        }
        return result;
    }
}
