package core.lesson4.task2;

import java.util.HashMap;

public class Phonebook {

    private HashMap<String, String> phonebook = new HashMap<>();

    public void add(String lastName, String phonenumber) {phonebook.put(phonenumber, lastName);}

    public String getPhonenumber(String lastName) {
        if(phonebook.containsValue(lastName)) {
            String result = "Телефонные номера по фамилии " + lastName + ": ";
            for(String s: phonebook.keySet()) {
                if(phonebook.get(s).equals(lastName)) result += s + "; ";
            }
            return result;
        } else return "Такой фамилии не найдено!";
    }

}
