package main.java.Classes.MEPackage;

import main.java.Classes.GroupPackage.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

public class ME {
    private int EmoteID;
    private int MessageID;
    private int GroupID;

    public void insert (Connection con)
    {
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO meem VALUES(?,?,?)");
            pstmt.setInt(1,EmoteID);
            pstmt.setInt(2,MessageID);
            pstmt.setInt(3, GroupID);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getGroupID() {
        return GroupID;
    }

    public void setGroupID(int groupID) {
        GroupID = groupID;
    }

    public int getEmoteID() {
        return EmoteID;
    }

    public void setEmoteID(int emoteID) {
        EmoteID = emoteID;
    }

    public int getMessageID() {
        return MessageID;
    }

    public void setMessageID(int messageID) {
        MessageID = messageID;
    }

    public ME(int emoteID, int messageID,int groupID) {
        EmoteID = emoteID;
        MessageID = messageID;
        GroupID = groupID;
    }

    @Override
    public String toString() {
        return "Emote-ul " + EmoteID +
                " a fost folosit in mesajul " + MessageID;
    }

    public boolean equals(ME o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ME me =  o;
        return EmoteID == me.EmoteID &&
                MessageID == me.MessageID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(EmoteID, MessageID);
    }

}
