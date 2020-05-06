

import java.sql.*;



public class Dbconnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public  Dbconnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver'.");
            
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jk","root","");
            st = con.createStatement();
             
        }catch(Exception ex){
            System.out.println("Erro:"+ex);
        }
    }
    public void getData(){
        try{
            
            String query = "select  * from persons";
            rs = st.executeQuery(query);
            System.out.println("Records from database");
            while (rs.next()){
                
                String name=rs.getString("name");
                String age=rs.getString("age");
                System.out.println("Name: "+name+"  "+"Age: "+age);
            }
            
            
             }catch (Exception ex){
            System.out.println(ex);
        }
    }
}

