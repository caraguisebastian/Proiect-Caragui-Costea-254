package main.java.Classes.AccountPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class Account {
    private int ID;
    private String Username;
    private String Password;
    private String Nickname;

    public void insert(Connection con)
    {
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO ACCOUNT VALUES(null,?,?,?)");
            pstmt.setString(1,Username);
            pstmt.setString(2,Password);
            pstmt.setString(3,Nickname);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account() {
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public void setNickname(String nickname) {
        this.Nickname = nickname;
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return Username;
    }

   public String getPassword() {
       return Password;
    } //??

    public String getNickname() {
        return Nickname;
    }

    public Account(int ID,String username, String password, String nickname) {
        this.ID = ID;
        Username = username;
        Password = password;
        Nickname = nickname;
    }

    @Override
    public String toString() {
        return Nickname +
                " ( " + Username + " ) ";
    }

    public boolean equals(Account o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account =  o;
        return ID == account.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }


}
