package core.lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static final String filePath = "src/main/resources/data.csv";
    public static File csvFile = new File(filePath);
    public static String[] header = {"V1;", "V2;", "V3;", "V4;", "V5;\n"};
    public static int[][] data = {{1,2,3,4,5},{6,7,8,9,10}};

    public static void main(String[] args) throws IOException {
        writeToFile();

        readFile();
    }

    public static void writeToFile() throws IOException {
        FileOutputStream writer = new FileOutputStream(csvFile);
        for(String s: header) {writer.write(s.getBytes());}
        String result = "";
        for(int[] row: data) {
            for(int element: row) {
                result+=element + ";";
            }
            result+="\n";
        }
        writer.write(result.getBytes());
        writer.close();
    }

    public static AppData readFile() throws IOException {
        AppData appData = new AppData();
        FileReader fr = new FileReader(csvFile);
        BufferedReader reader = new BufferedReader(fr);

        List<List<String>> records = new ArrayList<>();

        String header = reader.readLine();
        appData.setHeader(header.split(";"));


        while ((header = reader.readLine()) != null) {
            String[] values = header.split(";");
            records.add(Arrays.asList(values));
        }

        int[][] resultData = new int[records.size()][5];

        for(int i=0;i<records.size();i++){
            for(int j=0;j<records.get(i).size();j++){
                resultData[i][j] = Integer.valueOf(records.get(i).get(j));
            }
        }
        appData.setData(resultData);

        /*String data = reader.readLine(true);*/


        return appData;
    }
}
