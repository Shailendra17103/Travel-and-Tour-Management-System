package travel.tour.mang.system;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    Connection c;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql:///travelmanagementsys","root","Shailendra@17");
            s=c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
