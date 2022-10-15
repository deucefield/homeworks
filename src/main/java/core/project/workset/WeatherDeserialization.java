package core.project.workset;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.project.database.DatabaseRepo;
import core.project.weather.Primary;

import java.io.IOException;
import java.sql.SQLException;

public class WeatherDeserialization {

    private ObjectMapper om = new ObjectMapper();
    private WeatherResponse wr = new WeatherResponse();
    private Primary primary = new Primary();
    private int cityKey;
    DatabaseRepo dbr = new DatabaseRepo();

    public void deserialize() throws IOException, SQLException {
        if(cityKey==1) {wr.setCity(1);} else if(cityKey==2) {wr.setCity(2);}
        primary = om.readValue(wr.getWeather(), Primary.class);
        DatabaseRepo dbr = new DatabaseRepo();
        dbr.createTableIfNotExist();
    }

    public void currentWeather() throws SQLException {
        String cityStr = "";
        if(cityKey==1) {cityStr = "Санкт-Петербург ";} else
            if(cityKey==2) {cityStr = "Москва ";}
        System.out.println(primary.getCurrTime() + ": в городе " + cityStr +
                "ожидается " + primary.getFact().getCondition() + ", температура сейчас равна " +
                primary.getFact().getTemp() + " градусам");
        dbr.insertWeatherFactResponse(primary, cityStr);
    }

    public void periodsWeather() throws SQLException {
        String cityStr = "";
        if(cityKey==1) {cityStr = "Санкт-Петербург ";} else
            if(cityKey==2) {cityStr = "Москва ";}
        for(int i=0; i<2; i++) {
            System.out.println(primary.getForecast().getDate() + ": в период " + primary.getForecast().getParts().get(i).getPartName() +
                    " в городе "  + cityStr + "ожидается " +
                    primary.getForecast().getParts().get(i).getCondition() + ", средняя температура будет равна " +
                    primary.getForecast().getParts().get(i).getTemp() + " градусам");
            dbr.insertWeatherPeriodResponse(primary, cityStr, i);
        }
    }

    public void setCityKey(int cityKey) {this.cityKey = cityKey;}

}
