package day4;

import utility.ConfigurationReader;
import utility.DB_Utility;

public class MySqlTest2 {

    public static void main(String[] args) {
        String connectionStr = ConfigurationReader.getProperty("library2.database.url");
        String username = ConfigurationReader.getProperty("library2.database.username");
        String password = ConfigurationReader.getProperty("library2.database.password");

        DB_Utility.createConnection(connectionStr,username, password);

        DB_Utility.runQuery("SELECT * FROM books");
        DB_Utility.displayAllData();

        DB_Utility.destroy();
    }
}
