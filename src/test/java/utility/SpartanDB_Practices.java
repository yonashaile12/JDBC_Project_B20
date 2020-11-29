package utility;

public class SpartanDB_Practices {

    //create a main method
    public static void main(String[] args) {
        String connectionStr =  ConfigurationReader.getProperty("spartan.database.url");
        String username = ConfigurationReader.getProperty("spartan.database.username");
        String password = ConfigurationReader.getProperty("spartan.database.password");
        DB_Utility.createConnection(connectionStr, username, password);
        //call your create connection method with 3 params
        //provide username and password as SP SP
        // run query SELECT * FROM SPARTANS
        DB_Utility.runQuery("SELECT * FROM SPARTANS");
        // call few methods from DB_Utility
        System.out.println("DB_Utility.getRowCount() "+DB_Utility.getRowCount());

        //GTE ALL
        System.out.println("DB_Utility.getColumnNames() = \n\t" + DB_Utility.getColumnNames());


        DB_Utility.destroy();
    }



    //after you are done with this :
    // now add below to your properties file
    //spartan database.url =
    //spartan.database.username= SP
    //spartan database.password= SP

    //REPLACE YOUR HARDCODED CONNECTION INFO IN THIS
}
