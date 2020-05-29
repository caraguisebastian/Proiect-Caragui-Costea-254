package main.java.Classes.PackageProiect;
import main.java.Configs.DatabaseConnection;

import java.sql.*;




public class testStuff {
    public static void main(String[] args) {

        try{
          //  Class.forName("com.mysql.jdbc.Driver");

            Connection con = DatabaseConnection.getConnection();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from Account");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4) );
//          stmt.executeUpdate("INSERT INTO Account " + "VALUES (null,'VSL','parolaluiIon','Vasile Silviu')");
//          stmt.executeUpdate("INSERT INTO Account " + "VALUES (null,'MD','cisco12345','Dragan Mihaita')");
//          stmt.executeUpdate("INSERT INTO Account " + "VALUES (null,'AP','codC','Andrei Patrascu')");
//          stmt.executeUpdate("INSERT INTO Account " + "VALUES (null,'AD','iloveC++','Anca Dobrovat')");
//             stmt.executeUpdate("INSERT INTO Followers " + "VALUES (5,3)");
//             stmt.executeUpdate("INSERT INTO Followers " + "VALUES (2,3)");
//             stmt.executeUpdate("INSERT INTO Followers " + "VALUES (2,5)");
            // stmt.executeUpdate("INSERT INTO Groupp " + "VALUES (null,'Trinity')");
            // stmt.executeUpdate("INSERT INTO Belongs " + "VALUES (2,5)");
            // stmt.executeUpdate("INSERT INTO Belongs " + "VALUES (2,2)");
            // stmt.executeUpdate("INSERT INTO Belongs " + "VALUES (2,3)");
            //stmt.executeUpdate("INSERT INTO Message " + "VALUES (null,5,2,null,'i love oop',null)");

            //con.close();
        }catch(Exception e){
            System.out.println(e);
        }


//        String s = new String ("acasa");
//        String b = "acasa";
//        String c;
//        c = "acasa";
//            System.out.println(c==b);
//
//         Account User1 = new Account("user1","primaparola","nonick");
//         Account User2 = new Account("userDoi","adouaparola","longnick");
//        Followers f = new Followers (User1.getID(),User2.getID());
//            System.out.println(f);
//            Group g = new Group("RandomName");
//            System.out.println(g);
//
//        Message m = new Message (User1.getUsername(),g.getID(),"alksijjhdt 09",0);
//
//            System.out.println(m);

    }

}
