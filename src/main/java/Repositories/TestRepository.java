package main.java.Repositories;

import main.java.Classes.AccountPackage.Account;
import main.java.Configs.DatabaseConnection;

import java.sql.*;

public class TestRepository {

    public static Account findByID(int id)
    {
        try
        {
            PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement("SELECT * FROM proiect.account where ID = ?");
            Account tempAccount;
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                tempAccount = new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                rs.close();

                return tempAccount;
            }
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }


}
