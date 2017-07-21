import java.sql.*;

/**
 * Created by Violetta on 21-07-2017.
 */
public class Main {
    private static Connection connection = null;
    private static String username = "root";
    private static String password = "root";
    private static String URL = "jdbc:mysql://localhost:3306/shop";

    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver()); // download Driver
        Main.connection = DriverManager.getConnection(Main.URL, Main.username, Main.password); // connect
        if (Main.connection != null)
            System.out.println("Connection is successful!");
        else
            System.exit(0);
        Statement statement = Main.connection.createStatement(); // It lets to send requests to DataBase
        ResultSet resultSet = statement.executeQuery("select * from customers");
        int x = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= x; i++) {
                System.out.println(resultSet.getString(i) + "\t");
            }
            System.out.println();
        }
        System.out.println();
        if (resultSet != null)
            resultSet.close();
        if (statement != null)
            resultSet.close();
        if (Main.connection != null)
            Main.connection.close();

    }
}
