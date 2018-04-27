package sap.mikhail.HW02ADD;

import java.util.ArrayList;

public class StringTutor {

    public static void main(String[] args) {

        System.out.println(checkGreeting("Привет, Иван Петров !"));

    }

    public static boolean checkGreeting(String greeting) {

        if (!greeting.startsWith("Привет,")) {
            return false;
        }
        if (!greeting.endsWith("!")) {
            return false;
        }
        greeting = greeting.substring(greeting.indexOf(",") + 1, greeting.indexOf("!"));
        greeting = greeting.trim();
        String[] sArray = greeting.split(" ");

        if (sArray.length!=2) {
            return false;
        }
        if (sArray[0].length()<3 || sArray[1].length()<3) {
            return false;
        }
        if (Character.isLowerCase(sArray[0].toCharArray()[0]) || Character.isLowerCase(sArray[1].toCharArray()[0])) {
            return false;
        }

        return true;
    }
}
