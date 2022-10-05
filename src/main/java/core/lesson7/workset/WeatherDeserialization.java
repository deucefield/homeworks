package core.lesson7.workset;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.lesson7.weather.Primary;

import java.io.File;
import java.io.IOException;

public class WeatherDeserialization {

    private ObjectMapper om = new ObjectMapper();
    private WeatherResponse wr = new WeatherResponse();
    private Primary primary = new Primary();
    private int cityKey;

    public void deserialize() throws IOException {
        if(cityKey==1) {wr.setCity(1);} else if(cityKey==2) {wr.setCity(2);}
        primary = om.readValue(wr.getWeather(), Primary.class);
    }

    public void currentWeather() {
        String cityStr = "";
        if(cityKey==1) {cityStr = "Санкт-Петербург ";} else
            if(cityKey==2) {cityStr = "Москва ";}
        System.out.println(primary.getCurrTime() + ": в городе " + cityStr +
                "ожидается " + primary.getFact().getCondition() + ", температура сейчас равна " +
                primary.getFact().getTemp() + " градусам");
    }

    public void periodsWeather() {
        String cityStr = "";
        if(cityKey==1) {cityStr = "Санкт-Петербург ";} else
            if(cityKey==2) {cityStr = "Москва ";}
        for(int i=0; i<2; i++) {
            System.out.println(primary.getForecast().getDate() + ": в период " + primary.getForecast().getParts().get(i).getPartName() +
                    " в городе "  + cityStr + "ожидается " +
                    primary.getForecast().getParts().get(i).getCondition() + ", средняя температура будет равна " +
                    primary.getForecast().getParts().get(i).getTemp() + " градусам");
        }
    }

    public void setCityKey(int cityKey) {this.cityKey = cityKey;}

}
