package core.project.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Primary {
    @JsonProperty(value = "now_dt")
    private String currTime;
    private Forecast forecast = new Forecast();
    private Fact fact = new Fact();

    public void setCurrTime(String currTime) {this.currTime = currTime;}
    public String getCurrTime() {return currTime;}

    public void setForecast(Forecast forecast) {this.forecast = forecast;}
    public Forecast getForecast() {return forecast;}

    public void setFact(Fact fact) {this.fact = fact;}
    public Fact getFact() {return fact;}
}
