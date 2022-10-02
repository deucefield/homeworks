package core.lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class MainApp {

    static Properties prop = new Properties();

    public static void main(String[] args) throws IOException {
        getProperties();
        OkHttpClient client = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(prop.getProperty("BASE_HOST"))
                .addPathSegment(prop.getProperty("VERSION"))
                .addPathSegment(prop.getProperty("INFO"))
                .addQueryParameter("lat", "59.9386")
                .addQueryParameter("lon", "30.3141")
                .addQueryParameter("lang", "ru_RU")
                .build();

        System.out.println(url.toString());

        Request request = new Request.Builder()
                .addHeader("X-Yandex-API-Key", "ea544ebb-73cb-45fb-a1bc-8ee52ca68187")
                .url(url)
                .build();

        System.out.println(request.toString());

        String jsonResponse = client.newCall(request).execute().body().string();
        String[] parsedResponse = jsonResponse.split(", ");
        String[] ultraParsedResponse = new String[1000];
        System.out.println(jsonResponse);
    }

    private static void getProperties() throws IOException {
        FileInputStream config = new FileInputStream("src/main/resources/lesson6.properties");
        prop.load(config);
    }
}
