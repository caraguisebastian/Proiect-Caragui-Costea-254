package main.java.Repositories;

import main.java.Classes.AccountPackage.Account;
import main.java.Configs.DatabaseConnection;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetParticipants {

    public static List<Account> getPpl(String groupid)
    {
        List<Account> accounts = new ArrayList<>();
        List<Integer> userIDs = new ArrayList<Integer>();
        try{
        Statement stmt=DatabaseConnection.getConnection().createStatement();
        ResultSet rs=stmt.executeQuery("select * from Belongs");
        while(rs.next())
        {
            if(rs.getInt(1)==Integer.parseInt(groupid))
                userIDs.add(rs.getInt(2));
        }
        rs=stmt.executeQuery("select * from Account");
        while(rs.next())
        {
                if(userIDs.contains((Integer)rs.getInt(1)))
                {
                    Account tempAcc = new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                    accounts.add(tempAcc);
                }
        }

    }catch(Exception e){
        System.out.println(e);
    }
        return accounts;
    }
}
