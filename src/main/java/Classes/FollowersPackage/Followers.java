package main.java.Classes.FollowersPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class Followers {

    private int FirstID;
    private int SecondID;

    public void insert (Connection con)
    {
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO FOLLOWERS VALUES(?,?)");
            pstmt.setInt(1,FirstID);
            pstmt.setInt(2,SecondID);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getFirstID() {
        return FirstID;
    }

    public void setFirstID(int firstID) {
        FirstID = firstID;
    }

    public int getSecondID() {
        return SecondID;
    }

    public void setSecondID(int secondID) {
        SecondID = secondID;
    }

    public Followers(int firstID, int secondID) {
        FirstID = firstID;
        SecondID = secondID;
    }

    @Override
    public String toString() {
        return "The user with the ID " + FirstID +
                " follows the user with the ID " + SecondID;
    }

    public boolean equals(Followers o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Followers friends = o;
        return (FirstID == friends.FirstID &&
                SecondID == friends.SecondID) ||
                (FirstID == friends.SecondID &&
                        SecondID == friends.FirstID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstID, SecondID);
    }

}
