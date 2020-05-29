package main.java.Classes.BelongsPackage;

import java.util.Objects;

public class Belongs {
    private int GroupID;
    private int UserID;

    public int getGroupID() {
        return GroupID;
    }

    public void setGroupID(int groupID) {
        GroupID = groupID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public Belongs(int groupID, int userID) {
        GroupID = groupID;
        UserID = userID;
    }

    public boolean equals(Belongs o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Belongs belongs = o;
        return GroupID == belongs.GroupID &&
                UserID == belongs.UserID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(GroupID, UserID);
    }

    @Override
    public String toString() {
        return "Utilizatorul cu ID-ul " + UserID +
                " apartine grupului" + GroupID;
    }

}
