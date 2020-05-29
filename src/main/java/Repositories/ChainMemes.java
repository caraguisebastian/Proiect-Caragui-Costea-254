package main.java.Repositories;

import main.java.Classes.AccountPackage.Account;
import main.java.Classes.MEPackage.ME;
import main.java.Configs.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChainMemes {
    public static List<ME> getEmotes(String groupID)
    {
        int gID = Integer.parseInt(groupID);
        List<ME> allEmotes = new ArrayList<>();
        try{
            Statement stmt= DatabaseConnection.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery("select * from meem");
            while(rs.next()) {
                if(rs.getInt(3)==gID) {
                    ME tempME = new ME(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                    allEmotes.add(tempME);
                }
            }

        }catch(Exception e){
            System.out.println(e);
        }

        return allEmotes;
    }
}
