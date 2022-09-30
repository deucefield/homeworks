package core.lesson5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class MainApp {
    public static final String filePath = "src/main/java/resources/data.csv";
    public static File csvFile = new File(filePath);
    AppData appData = new AppData();

    public static void main(String[] args) throws IOException {

        String[] header = {"V1;", "V2;", "V3;", "V4;", "V5;\n"};
        int[][] data = {{1,2,3,4,5},{6,7,8,9,10}};


        writeToFile(csvFile, header, data);


    }

    public static void writeToFile(File file, String[] header, int[][] data) throws IOException {


        FileOutputStream writer = new FileOutputStream(file, true);
        for(String s: header) {writer.write(s.getBytes());}
        String result = "";
        for(int[] row: data) {
            for(int element: row) {
                result+=element + ";";
            }
            result+="\n";
        }
        writer.write(result.getBytes());
    }

}
