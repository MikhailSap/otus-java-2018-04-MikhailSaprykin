package sap.mikhail.HW08;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class MyJSON {

    private enum  Type {IS_ARRAY, IS_ITERABLE, IS_MAP, IS_OBJECT, OTHER}

    public String toJSON(Object o) {
        Object postParse = parser(o);
        if (postParse instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) postParse;
            return jsonObject.toJSONString();
        } else return JSONValue.toJSONString(postParse);
    }

    private Object parser(Object o) {
        Object result = null;
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        switch (whatIsIt(o)) {
            case IS_ARRAY: {
                for (int i = 0 ; i < Array.getLength(o) ; i++) {
                    jsonArray.add(parser(Array.get(o, i)));
                }
                result = jsonArray;
            } break;
            case IS_ITERABLE: {
                Iterator iterator = ((Iterable)o).iterator();
                while (iterator.hasNext()) {
                    jsonArray.add(parser(iterator.next()));
                }
                result = jsonArray;
            } break;
            case IS_MAP: {
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
            case IS_OBJECT: {
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
            case OTHER: {
                if (o.getClass().equals(Character.class))
                    result = Character.toString((char)o);
                else
                    result = o;
            } break;
        }
        return result;
    }

    private Type whatIsIt(Object o) {
        Type whatIsIt;
        String isObject = JSONValue.toJSONString(o);

        if (o.getClass().isArray()) {
            whatIsIt = Type.IS_ARRAY;
        } else
        if (o instanceof Iterable) {
            whatIsIt = Type.IS_ITERABLE;
        } else
        if (o instanceof Map) {
            whatIsIt = Type.IS_MAP;
        } else
        if (isObject.contains("@") && !(o instanceof String)) {
            whatIsIt = Type.IS_OBJECT;
        } else {whatIsIt = Type.OTHER;}
        return whatIsIt;
    }
}
