package main.java.Classes.GroupPackage;

import java.util.Objects;

public class Group {
    private int ID;
    private String Name;

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Group(int ID, String name) {
        this.ID = ID;
        Name = name;
    }

    @Override
    public String toString() {
        return  Name +
                " ( " + ID +
                " ) ";
    }

    public boolean equals(Group o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group =  o;
        return ID == group.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }


}
