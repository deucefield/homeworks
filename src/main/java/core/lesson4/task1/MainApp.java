package core.lesson4.task1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MainApp {

    static String[] array = {"Привет", "Hello", "Hola", "Hola", "Привет", "Привет", "Hallo", "Bonjour", "Bonjour", "Bonjour"};

    public static void main(String[] args) {
        HashSet<String> unique = new HashSet<>(Arrays.asList(array));
        //for(String str: array) {unique.add(str);} — Этот вариант был здесь, до того как я вспомнил о Array.asList =)

        HashMap<String,Integer> result = new HashMap<>();
        for(String s: unique) {result.put(s,counter(s));}

        System.out.println(result);
    }

    public static Integer counter(String s){
        int result=0;

        for(String str: array) {if(str.equals(s)) result++;} return result;
    }
}
