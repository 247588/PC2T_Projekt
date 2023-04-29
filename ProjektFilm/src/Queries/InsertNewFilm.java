package Queries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import dbconn.DBConnection;
import java.sql.Array;
public class InsertNewFilm {

    public void insertnewhrany(String nazev, String reziser,int rok){
        Connection conn = DBConnection.getDBConnection();
        
        String insertHranyfilm = "INSERT INTO hrane " + "(nazev,reziser,rok)"+ " VALUES(?,?,?)";
        try (PreparedStatement prStmt = conn.prepareStatement(insertHranyfilm)) {
      prStmt.setString(1, nazev);
      prStmt.setString(2, reziser);
      prStmt.setInt(3, rok);

      prStmt.executeUpdate();

      System.out.println("Novy hrany film zadan do databaze");
    } catch (SQLException e) {
      System.out.println("Film byl jiz zadan do databaze.");
      
    }
  }
   
    public void insertnewanimovany(String nazev, String reziser,int rok, int vek){
  
        Connection conn = DBConnection.getDBConnection();
        String insertAnimovanyfilm = "INSERT INTO animovane " + "(nazev, reziser, rok, vek)"+ " VALUES(?,?,?,?)";
        try (PreparedStatement prStmt = conn.prepareStatement(insertAnimovanyfilm)) {
      prStmt.setString(1, nazev);
      prStmt.setString(2, reziser);
      prStmt.setInt(3, rok);
      prStmt.setInt(4, vek);
      prStmt.executeUpdate();

      System.out.println("Novy hrany film zadan do databaze");
    } catch (SQLException e) {
      System.out.println("Film byl jiz zadan do databaze.");
      
    }
  }
    public void inserthranyrev(String nazevH){
    int pocetHvezdicek = 0;
    int maxPocetHvezdicek = 0;

    //for(int i = 0; i < hodnoceni.length(); i++) {
       // if(hodnoceni.charAt(i) == '*') {
       //     pocetHvezdicek++;
       //     if(pocetHvezdicek > maxPocetHvezdicek) {
       //         maxPocetHvezdicek = pocetHvezdicek;
       //     }
       // } else {
          //  pocetHvezdicek = 0;
       // }
    //}   
        Connection conn = DBConnection.getDBConnection();
        String insertHranyRev = "INSERT INTO hodnoceniH (nazevH, hodnoceni) VALUES (?,?)";
        try(PreparedStatement prmt = conn.prepareStatement(insertHranyRev)){
            prmt.setString(1, nazevH);
            //prmt.setInt(2, maxPocetHvezdicek);
            prmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Chyba v Prikazu");
        }
    }
    public void insertanimovanyrev(String nazev){
   
        Connection conn = DBConnection.getDBConnection();
        String insertanimovanyRev = "INSERT INTO hodnoceni (nazev, hodnoceni) VALUES (?,?)";
        try(PreparedStatement prmt = conn.prepareStatement(insertanimovanyRev)){
            prmt.setString(1, nazev);          
            prmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Chyba v Prikazu");
        }
    }
    public void insertherci(String nazev, String herci){
        Connection conn = DBConnection.getDBConnection();
        String insertHerci = "INSERT INTO herci (nazevH, herci) VALUES (?,?)";
        try(PreparedStatement prmt = conn.prepareStatement(insertHerci)){
            prmt.setString(1, nazev);
            prmt.setString(2, herci);
            prmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Chyba v Prikazu");
        }
                
    }
    public void insertanimatori(String nazev, String animatori){
        Connection conn = DBConnection.getDBConnection();
        String insertHerci = "INSERT INTO animatori (nazev, animatori) VALUES (?,?)";
        try(PreparedStatement prmt = conn.prepareStatement(insertHerci)){
            prmt.setString(1, nazev);
            prmt.setString(2, animatori);
            prmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Chyba v Prikazu");
        }
                
    }
}
