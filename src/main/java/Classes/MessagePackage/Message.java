package main.java.Classes.MessagePackage;


import java.sql.*;
import java.util.Objects;

public class Message {
    private int ID;
    private int UserID;
    private int GroupID;
    private Timestamp Time;
    private String SendMessage;
    private Integer Reference;


    public void insert (Connection con)
    {
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO MESSAGE VALUES(null,?,?,?,?,?)");
            pstmt.setInt(1,UserID);
            pstmt.setInt(2, GroupID);
            pstmt.setString(4,SendMessage);
            pstmt.setTimestamp(3,Time);
           if(Reference == null || Reference == 0) pstmt.setNull(5, Types.INTEGER);
           else pstmt.setInt(5,Reference);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getID() {
        return ID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int accUsername) {
        UserID = accUsername;
    }

    public int getGroupID() {
        return GroupID;
    }

    public void setGroupID(int groupID) {
        GroupID = groupID;
    }

    public Timestamp getTime() {
        return Time;
    }

    public void setTime(Timestamp time) {
        Time = time;
    }

    public String getSendMessage() {
        return SendMessage;
    }

    public void setSendMessage(String sendMessage) {
        SendMessage = sendMessage;
    }

    public Integer getReference() {
        return Reference;
    }

    public void setReference(Integer reference) {
        Reference = reference;
    }

    public Message(int ID, int UserID, int groupID, Timestamp time, String sendMessage, Integer reference) {
        this.ID = ID;
        this.UserID = UserID;
        GroupID = groupID;
        SendMessage = sendMessage;
        Reference = reference;
        Time = time;
    }

    public Message() {
    }

    @Override
    public String toString() {
            return SendMessage + " (" + Time + ") ";

    }

    public boolean equals(Message o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = o;
        return ID == message.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

}
