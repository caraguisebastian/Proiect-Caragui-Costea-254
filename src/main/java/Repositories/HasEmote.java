package main.java.Repositories;

import main.java.Classes.MEPackage.ME;
import main.java.Classes.MessagePackage.Message;

import java.util.List;

public class HasEmote {
    public static int HE(Message mess, List<ME> me)
    {
        for(int i = 0; i < me.size(); i++)
        {
            ME tempME = me.get(i);
            if(tempME.getMessageID()==mess.getID())
                return tempME.getEmoteID();
        }
        return 0;
    }
}
