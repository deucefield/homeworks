package core.lesson7.workset;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    private WeatherDeserialization wd = new WeatherDeserialization();
    private int city;


    public void runDialog() throws IOException {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Выберите город: 1 — Санкт-Петербург, 2 — Москва");
            city = Integer.valueOf(sc.nextLine());

            cityCheck();

            wd.deserialize();

            System.out.println("Введите ответ: " + "\n" + "1 — получить текущую погоду, " +
                    "2 — получить погоду на два ближайших периода" + "\n" +
                    "выход — для завершения работы программы");

            String result = sc.nextLine();
            checkIsExit(result);
            mainFunction(result);

            System.out.println('\n');

        }
    }
    private void mainFunction(String result) {
        if(Integer.valueOf(result)==1) {wd.currentWeather();}
        else if(Integer.valueOf(result)==2) {wd.periodsWeather();}
        else System.out.println("Вы ввели неверное значение!");
    }

    private void cityCheck() throws IOException {
        if(city==1) {
            wd.setCityKey(1);
            System.out.println("Выбран город Санкт-Петербург");
        } else if(city==2){
            wd.setCityKey(2);
            System.out.println("Выбран город Москва");
        } else System.out.println("Вы ввели неверное значение!");
    }

    private void checkIsExit(String result) {
        if(result.toLowerCase().equals("выход")) {
            System.out.println("Завершение работы");
            System.exit(0);
        }
    }

}