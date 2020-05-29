package main.java.Classes.EmotePackage;

import main.java.Classes.MEPackage.ME;
import main.java.Configs.DatabaseConnection;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Emote {
    private int ID;
    private String Name;


    public Emote getEmote(int id)
    {
     Emote em = new Emote();
        try{
            Connection con = DatabaseConnection.getConnection();
            Statement stmt= DatabaseConnection.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery("select * from Emote");
            while(rs.next())
            {
                if(rs.getInt(1)==id)
                {
                    em = new Emote(rs.getInt(1),rs.getString(2));
                    return em;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

     return em;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Emote(int ID, String name) {
        this.ID = ID;
        this.Name = name;

    }

    public Emote() {
    }

    @Override
    public String toString() {
        return "Emote-ul " + Name + " ( " + ID + " ) ";
    }

    public boolean equals(Emote o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emote emote = o;
        return ID == emote.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }


}
