package Queries;

import dbconn.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateRev {
    public void updatemovanyrev(String nazev,int hodnoceni){
        
        Connection conn = DBConnection.getDBConnection();
        String insertanimovanyRev = "INSERT INTO hodnoceni (hodnoceni,nazev) VALUES(?,?)";
        try(PreparedStatement prmt = conn.prepareStatement(insertanimovanyRev)){
            prmt.setInt(1, hodnoceni); 
            prmt.setString(2,nazev);
            prmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Chyba v Prikazu");
        }
    }
}
