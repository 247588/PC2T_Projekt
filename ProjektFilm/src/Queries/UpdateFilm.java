package Queries;
import dbconnection.RunApp;
import dbconn.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateFilm {
  
    public void UpdateNazevH(String nazev,String nazevS){
    Connection conn = DBConnection.getDBConnection();
   
    String nazevUp = "UPDATE hrane SET nazev=? WHERE nazev=?";
    try (PreparedStatement prStmt = conn.prepareStatement(nazevUp);) {
      prStmt.setString(2, nazev);
      prStmt.setString(3, nazevS);
      int rowsUpdated = prStmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
}
        public void UpdateNazevA(String nazev,String nazevS){
    Connection conn = DBConnection.getDBConnection();  
    String nazevUp = "UPDATE animovane SET nazev=? WHERE nazev=?";
    try (PreparedStatement prStmt = conn.prepareStatement(nazevUp);) {
      prStmt.setString(2, nazev);
      prStmt.setString(3, nazevS);
      int rowsUpdated = prStmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
}
}
