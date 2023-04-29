package Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dbconn.DBConnection;
import java.sql.DatabaseMetaData;
public class SelectFilm {
    public static void printStars(int number) {
    for (int i = 0; i < number; i++) {
        System.out.print("* ");
    }
}

    public void getHrane(){
    Connection conn = DBConnection.getDBConnection();
    String hrane = "SELECT * FROM hrane JOIN hodnoceniH ON hodnoceniH.nazevH = hrane.nazev JOIN herci ON herci.nazevH = hrane.nazev";
    
    try (PreparedStatement prStmt = conn.prepareStatement(hrane);
        ResultSet rs = prStmt.executeQuery()) {
      while (rs.next()) {   
        System.out.println("Nazev: " +rs.getString("nazev")+ " Reziser: " + rs.getString("reziser")+ " Rok: " + rs.getInt("rok")+ " Herci: " +rs.getString("herci"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }   
  }
    public void getHranerev(){
       Connection conn = DBConnection.getDBConnection();
   String hranerev = "SELECT hodnoceniH.hodnoceni FROM hodnoceniH JOIN hrane ON hodnoceniH.nazevH = hrane.nazev";
    
    try (PreparedStatement prStmt = conn.prepareStatement(hranerev);
        ResultSet rs = prStmt.executeQuery()) {
      while (rs.next()) {
          for (int i = 0; i < rs.getInt("hodnoceni"); i++) {
        System.out.print("* ");
    }
    System.out.println();   
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    }
public void getAnimovane() throws SQLException {
    Connection conn = DBConnection.getDBConnection();
    String animovane = "SELECT animovane.nazev, animovane.reziser, animovane.rok, animovane.vek, ";
    String hodnoceni = "hodnoceni.hodnoceni";
    DatabaseMetaData dbm = conn.getMetaData();
    ResultSet rs = dbm.getColumns(null, null, "animovane", "hodnoceni");
    boolean existujeSloupecHodnoceni = rs.next();

    if (existujeSloupecHodnoceni) {
        animovane += hodnoceni + ", ";
    }

    animovane += "GROUP_CONCAT(animatori.animatori) AS animatori FROM animovane JOIN animatori ON animovane.nazev = animatori.nazev";

    if (existujeSloupecHodnoceni) {
        animovane += " LEFT JOIN hodnoceni ON hodnoceni.nazev = animovane.nazev";
        animovane += " WHERE hodnoceni IS NULL";
    }

    animovane += " GROUP BY animovane.nazev";

    try (PreparedStatement prStmt = conn.prepareStatement(animovane);
            ResultSet rs2 = prStmt.executeQuery()) {

        while (rs2.next()) {
            System.out.println("Nazev: " + rs2.getString("nazev") + " Reziser: " + rs2.getString("reziser") + " Rok: " + rs2.getInt("rok") + " Doboruceny vek: " + rs2.getInt("vek") + " Animatori: " + rs2.getString("animatori"));

            if (existujeSloupecHodnoceni) {
                System.out.println("Hodnoceni: " + rs2.getInt("hodnoceni"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}