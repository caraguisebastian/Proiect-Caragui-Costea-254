package main.java.Repositories;

import main.java.Classes.MessagePackage.Message;
import main.java.Configs.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.Statement;

public class DoesHeExist {
 public static int exists(String s)
 {
     try{
         Statement stmt= DatabaseConnection.getConnection().createStatement();
         ResultSet rs=stmt.executeQuery("select * from Account");
         while(rs.next())
         {
             if(s.equals(rs.getString(2)))
             {
                 return rs.getInt(1);
             }
         }
     }catch(Exception e){
         System.out.println(e);
     }
     return 0;
 }
}
