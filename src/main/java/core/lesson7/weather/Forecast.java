package core.lesson7.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    private ArrayList<Parts> parts;
    private String date;

    public void setParts(ArrayList<Parts> parts) {this.parts = parts;}
    public ArrayList<Parts> getParts() {return parts;}
    public void setDate(String date) {this.date = date;}
    public String getDate() {return date;}
}
