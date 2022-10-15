package core.project.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fact {
    private byte temp;
    private String condition;


    public void setTemp(byte temp) {this.temp = temp;}
    public byte getTemp() {return temp;}

    public void setCondition(String condition) {this.condition = condition;}
    public String getCondition() {return condition;}
}
