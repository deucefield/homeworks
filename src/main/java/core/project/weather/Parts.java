package core.project.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Parts {
    @JsonProperty(value = "part_name")
    private String partName;
    @JsonProperty(value = "temp_avg")
    private int tempAVG;
    private String condition;

    public void setPartName(String partName) {this.partName = partName;}
    public String getPartName() {return partName;}

    public void setTemp(int tempAVG) {this.tempAVG = tempAVG;}
    public int getTemp() {return tempAVG;}

    public void setCondition(String condition) {this.condition = condition;}
    public String getCondition() {return condition;}

}
