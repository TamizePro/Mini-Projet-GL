package Modele;

import java.sql.*;
import java.util.Properties;
import io.github.cdimascio.dotenv.Dotenv;

public class MySQLConnection {
    private static Connection connextion = null;

    public static Connection getInstance(){
        if (connextion == null){
            Dotenv dotenv = Dotenv.configure()
            .directory("./")
            .load();
            Properties connConfig = new Properties();
            connConfig.setProperty("user", dotenv.get("DB_USER"));
            connConfig.setProperty("password", dotenv.get("DB_USER_PASSWORD"));
            connConfig.setProperty("characterEncoding", "utf-8");
            try{
                /*Class.forName("com.mysql.cj.jdbc.Driver"); // for mysql*/
                Class.forName("org.mariadb.jdbc.Driver"); // for mariadb
                connextion = DriverManager.getConnection(dotenv.get("DB_URL"), connConfig);
            } catch (ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }
        }
        return connextion;
    }

    public static void closeInstance(){
        if (connextion != null){
            try{
                connextion.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
