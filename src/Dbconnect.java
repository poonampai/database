

import java.sql.*;



public class Dbconnect {
    private String dbname, username, password;
    private Connection con;
    private Statement stmt;
    private ResultSet res;
    
    public  Dbconnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            dbname = "jdbc:mysql://localhost:3306/mini";
            username = "root";
            password = "";
            con = DriverManager.getConnection(dbname, username, password);
        }catch(Exception ex){
            System.out.println("Connection Error:");
            ex.printStackTrace();
        }
    }
    public void getData(){
        try{
            stmt = con.createStatement();
            String query = "select  * from persons";
            res = stmt.executeQuery(query);
            System.out.println("Records from database");
            while (res.next()){
                String name = res.getString("name");
                String age = res.getString("age");
                System.out.printf("Name: %s Age: %s\n", name, age);
            }
        }catch (Exception ex){
            System.out.println("Fetching Error:");
            ex.printStackTrace();
        }
    }
}

