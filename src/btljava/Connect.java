package btljava;


import java.sql.*;

public class Connect{
    Connection c;
    Statement s;
    public Connect(){
        try{

            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/qlks","root","hung2001");
            s =c.createStatement();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}




