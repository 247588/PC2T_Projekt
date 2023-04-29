package Queries;

import dbconn.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteFilm {
public void deleteF(String nazev){
    Connection conn = DBConnection.getDBConnection();
    String filmdelete = "DELETE FROM hrane WHERE nazev=?";
    try(PreparedStatement prmt = conn.prepareStatement(filmdelete)){
        prmt.setString(1, nazev);
        int delete = prmt.executeUpdate();
        System.out.println("Film " +nazev+ "byl odebran.");
    }catch(SQLException e){
        e.printStackTrace();
    }
} 
public void deleteFR(String nazev){
    Connection conn = DBConnection.getDBConnection();
    String filmdelete = "DELETE FROM hodnoceniH WHERE nazevH =?";
    try(PreparedStatement prmt = conn.prepareStatement(filmdelete)){
        prmt.setString(1, nazev);
        int delete = prmt.executeUpdate();       
    }catch(SQLException e){
        e.printStackTrace();
    }
}
public void deleteA(String nazev){
    Connection conn = DBConnection.getDBConnection();
    String filmdelete = "DELETE FROM animovane WHERE nazev=?";
    try(PreparedStatement prmt = conn.prepareStatement(filmdelete)){
        prmt.setString(1, nazev);
        int delete = prmt.executeUpdate();
        System.out.println("Film " +nazev+ "byl odebran.");
    }catch(SQLException e){
        e.printStackTrace();
    }
} 
public void deleteAF(String nazev){
    Connection conn = DBConnection.getDBConnection();
    String filmdelete = "DELETE FROM hodnoceni WHERE nazev =?";
    try(PreparedStatement prmt = conn.prepareStatement(filmdelete)){
        prmt.setString(1, nazev);
        int delete = prmt.executeUpdate();
    }catch(SQLException e){
        e.printStackTrace();
    }
}
}
