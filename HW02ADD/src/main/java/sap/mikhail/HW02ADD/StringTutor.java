package sap.mikhail.HW02ADD;

import java.util.ArrayList;

public class StringTutor {

    public static void main(String[] args) {

        System.out.println(checkGreeting("Привет, Иван Петров !"));

    }

    public static boolean checkGreeting(String greeting) {
        ArrayList<String> list = new ArrayList<String>();
        char lastSimb;
        String fSimb = "";
        int checkPointsRWords = 0;
        int checkPointsFSimb = 0;
        int resultCheckPoints = 0;

        while (greeting.length() > 0) {   //парсим входящую строку на слова
            if (greeting.contains(",")) {
                list.add(greeting.substring(0, greeting.indexOf(',') + 1));
                greeting = greeting.substring(greeting.indexOf(',') + 1, greeting.length());
            }
            if (greeting.contains(" ")) {
                list.add(greeting.substring(0, greeting.indexOf(' ')));
                greeting = greeting.substring(greeting.indexOf(' ') + 1, greeting.length());
            } else {
                list.add(greeting);
                greeting = "";
            }
        }

        if (list.contains("")) {
            list.remove("");
        }

        if (list.size() != 0) {

            checkPointsRWords = list.get(0).equals("Привет,") ? ++checkPointsRWords:checkPointsRWords;

            if (list.size() == 3) {
                checkPointsRWords = list.get(1).length() > 2 ? ++checkPointsRWords : checkPointsRWords;
                checkPointsRWords = list.get(2).length() > 3 ? ++checkPointsRWords : checkPointsRWords;
                lastSimb = list.get(2).toCharArray()[list.get(2).toCharArray().length - 1];
                checkPointsRWords = lastSimb == '!' ? ++checkPointsRWords : checkPointsRWords;

                for (String s : list) {  //выбираем первые буквы слов
                    char ch = s.toCharArray()[0];
                    fSimb += ch;
                }

            } else if (list.size() == 4) {
                checkPointsRWords = list.get(1).length() > 2 ? ++checkPointsRWords : checkPointsRWords;
                checkPointsRWords = list.get(2).length() > 2 ? ++checkPointsRWords : checkPointsRWords;
                checkPointsRWords = list.get(3).equals("!") ? ++checkPointsRWords : checkPointsRWords;

                for (String s : list) {   //выбираем первые буквы слов
                    if (list.indexOf(s) == list.size() - 1) {
                        } else {
                        char ch = s.toCharArray()[0];
                        fSimb += ch;
                    }
                }
            }

        }

        char[] chFSimb = fSimb.toCharArray(); //проверяем заглавные ли первые буквы слов
        for (char ch : chFSimb) {
            if (ch > 1039 && ch < 1072) {
                checkPointsFSimb++;
            }
        }

        //собираем проверочные баллы
        resultCheckPoints = list.size() > 1 && list.size() < 5 ? ++resultCheckPoints:resultCheckPoints;
        resultCheckPoints = checkPointsRWords == 4 ? ++resultCheckPoints:resultCheckPoints;
        resultCheckPoints = checkPointsFSimb == 3 ? ++resultCheckPoints:resultCheckPoints;



        return resultCheckPoints == 3 ? true:false;
    }
}
