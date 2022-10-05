package core.lesson7.workset;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WeatherResponse {

    private int city;
    private Properties prop = new Properties();
    String lat = null;
    String lon = null;
    public String getWeather() throws IOException {
        getProperties();
        OkHttpClient client = new OkHttpClient();

        cityInit();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(prop.getProperty("BASE_HOST"))
                .addPathSegment(prop.getProperty("VERSION"))
                .addPathSegment(prop.getProperty("INFO"))
                .addQueryParameter("lat", lat)
                .addQueryParameter("lon", lon)
                .addQueryParameter("lang", "ru_RU")
                .build();

        Request request = new Request.Builder()
                .addHeader("X-Yandex-API-Key", "ea544ebb-73cb-45fb-a1bc-8ee52ca68187")
                .url(url)
                .build();

        String jsonResponse = client.newCall(request).execute().body().string();
        return jsonResponse;
    }
    public void cityInit() {
        String MSCLat = "55.7558";
        String MSCLon = "37.6176";
        String SPBLat = "59.9386";
        String SPBLon = "30.3141";

        if(city==2) {
            lat=MSCLat;
            lon=MSCLon;
        } else if(city==1) {
            lat=SPBLat;
            lon=SPBLon;
        }
    }
    public void setCity(int city) {this.city = city;}

    private void getProperties() throws IOException {
        FileInputStream config = new FileInputStream("src/main/resources/lesson6.properties");
        prop.load(config);
    }
}
