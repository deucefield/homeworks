package core.lesson4.task2;

public class MainApp {


    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("SAV", "+79113182515");
        phonebook.add("SAV", "+79313912731");
        phonebook.add("KMO", "+79113189878");
        phonebook.add("SAV", "+79113188745");
        phonebook.add("REV", "+79102717728");
        phonebook.add("REV", "+79001882618");

        System.out.println(phonebook.getPhonenumber("REV"));

    }
}
