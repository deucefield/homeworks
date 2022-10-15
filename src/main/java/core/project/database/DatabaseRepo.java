package core.project.database;

import core.project.weather.Primary;
import core.project.workset.WeatherResponse;

import java.sql.*;

public class DatabaseRepo {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String createTableFact = "CREATE TABLE IF NOT EXISTS fact (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "city TEXT NOT NULL,\n" +
            "now_dt TEXT NOT NULL,\n" +
            "condition TEXT NOT NULL,\n" +
            "temp REAL NOT NULL" +
            ");";

    String createTablePeriod = "CREATE TABLE IF NOT EXISTS period (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "period TEXT NOT NULL,\n" +
            "city TEXT NOT NULL,\n" +
            "now_dt TEXT NOT NULL,\n" +
            "condition TEXT NOT NULL,\n" +
            "temp REAL NOT NULL" +
            ");";

    String insertWeatherFact = "INSERT INTO fact (city, now_dt, condition, temp) VALUES (?,?,?,?)";
    String insertWeatherPeriod = "INSERT INTO period (period, city, now_dt, condition, temp) VALUES (?,?,?,?,?)";

    private Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\study\\Java\\homeworks\\src\\main\\resources\\database.db");
        conn.setAutoCommit(true);
        System.out.println("Connected");
        return conn;
    }

    public void createTableIfNotExist() throws SQLException {
        Statement stmtFact = getConnection().createStatement();
        stmtFact.executeUpdate(createTableFact);

        Statement stmtPeriod = getConnection().createStatement();
        stmtPeriod.executeUpdate(createTablePeriod);
    }

    public void insertWeatherFactResponse(Primary primary, String city) throws SQLException {
        try (PreparedStatement ps = getConnection().prepareStatement(insertWeatherFact)) {
            ps.setString(1, city);
            ps.setString(2, primary.getCurrTime());
            ps.setString(3, primary.getFact().getCondition());
            ps.setString(4, String.valueOf(primary.getFact().getTemp()));
            ps.execute();
        }
    }

    public void insertWeatherPeriodResponse(Primary primary, String city, int increment) throws SQLException {
        try (PreparedStatement ps = getConnection().prepareStatement(insertWeatherPeriod)) {
            ps.setString(1, primary.getForecast().getParts().get(increment).getPartName());
            ps.setString(2, city);
            ps.setString(3, primary.getForecast().getDate());
            ps.setString(4, primary.getForecast().getParts().get(increment).getCondition());
            ps.setString(5, String.valueOf(primary.getForecast().getParts().get(increment).getTemp()));
            ps.execute();
        }
    }

    public void showFactTable() throws SQLException {
        Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM fact;");

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getString(3) + " | " +
                    rs.getString(4) + " | " +
                    rs.getDouble(5));
        }

    }


    public void showPeriodTable() throws SQLException {
        Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM period;");

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getString(3) + " | " +
                    rs.getString(4) + " | " +
                    rs.getString(5) + " | " +
                    rs.getDouble(6));
        }
    }


/*    public void insertTest(String v1) throws SQLException {
        try (PreparedStatement ps = getConnection().prepareStatement(insertWeatherQuery)) {
            ps.setString(1, v1);
            ps.setString(2, v1);
            ps.setString(3, v1);
            ps.setString(4, v1);
            ps.execute();
        }

    }*/


}
