package core.project.workset;

import core.project.database.DatabaseRepo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {
    private WeatherDeserialization wd = new WeatherDeserialization();
    private int city;
    DatabaseRepo dbr = new DatabaseRepo();

    public void runDialog() throws Exception {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Выберите город: 1 — Санкт-Петербург, 2 — Москва");
            city = Integer.valueOf(sc.nextLine());

            cityCheck();

            wd.deserialize();

            System.out.println("Введите ответ: " + "\n" + "1 — получить текущую погоду, " +
                    "2 — получить погоду на два ближайших периода, " + "\n" +
                    "3 — посмотреть все записи по запросам о текущей погоде, " +
                    "4 — посмотреть все записи по запросам о периодах" + "\n" +
                    "выход — для завершения работы программы");

            String result = sc.nextLine();
            checkIsExit(result);
            mainFunction(result);

            System.out.println('\n');

        }
    }
    private void mainFunction(String result) throws SQLException {
        if(Integer.valueOf(result)==1) {wd.currentWeather();}
        else if(Integer.valueOf(result)==2) {wd.periodsWeather();}
        else if(Integer.valueOf(result)==3) {dbr.showFactTable();}
        else if(Integer.valueOf(result)==4) {dbr.showPeriodTable();}
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