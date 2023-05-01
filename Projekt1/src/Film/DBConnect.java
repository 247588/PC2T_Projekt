package Film;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class DBConnect {
   
public static void zapisData(List<HranyFilm> hraneFilmy, List<AnimovanyFilm> animovaneFilmy) {
    final String DB_URL = "jdbc:sqlite:db/film.db";

    try (Connection conn = DriverManager.getConnection(DB_URL);
         Statement stmt = conn.createStatement()) {

       
        String deleteSql = "DELETE FROM film";
        stmt.executeUpdate(deleteSql);

       
        String insertSql = "INSERT INTO film (druh, nazev, reziser, rok, herci, hodnoceni, hodnocenislovne, vek) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement prepStmt = conn.prepareStatement(insertSql);

     
        for (HranyFilm film : hraneFilmy) {
            prepStmt.setInt(1, 1);
            prepStmt.setString(2, film.getNazev());
            prepStmt.setString(3, film.getReziser());
            prepStmt.setInt(4, film.getRokVydani());
            prepStmt.setString(5, Herci.vytvoritSeznam(film.getSeznamHercu()));
            prepStmt.setInt(6, film.getHodnoceni());
            prepStmt.setString(7, film.getHodnoceniSlovne());
            prepStmt.setNull(8, Types.INTEGER);
            prepStmt.executeUpdate();
        }

     
        for (AnimovanyFilm film : animovaneFilmy) {
            prepStmt.setInt(1, 2);
            prepStmt.setString(2, film.getNazev());
            prepStmt.setString(3, film.getReziser());
            prepStmt.setInt(4, film.getRokVydani());

            if (!film.getSeznamHercu().isEmpty()) {
                prepStmt.setString(5, Herci.vytvoritSeznam(film.getSeznamHercu()));
            } else {
                prepStmt.setString(5, "nic");
            }

            prepStmt.setInt(6, film.getHodnoceni());
            prepStmt.setString(7, film.getSlovniHodnoceni());
            prepStmt.setInt(8, film.getDoporucenyVek());
            prepStmt.executeUpdate();
        }

        prepStmt.close();
        System.out.println("Data saved successfully.");

    } catch (SQLException e) {
        System.err.println("Error executing SQL statement.");
        e.printStackTrace();
    }
}
      public static void nactiData(List<AnimovanyFilm> animovanefilmy, List<HranyFilm> hranefilmy, List<Herci> herci)
    {   try
        {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:db/film.db";
            Connection con = DriverManager.getConnection(url);
            Statement statement = con.createStatement();
            String query = "SELECT * FROM film";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                int druh = rs.getInt(1);
                if(druh == 1)
                {
                    String nazev = rs.getString(2);
                    String reziser = rs.getString(3);
                    int rokVydani = rs.getInt(4);
                    List<String> seznamHercu= new ArrayList<String>(); 
                    String herciText = rs.getString(5);
                    if(!herciText.equals("nic")){
                        for (String herec : herciText.split(";")){
                            if(herec !=""){
                                herec = ConsoleInput.upravJmeno(herec);
                                seznamHercu.add(herec);
                                Boolean nalezeno = false;
                                for (Herci her : herci){
                                    if(her.getJmeno().equals(herec)){
                                        her.pridejFilm(nazev, seznamHercu);
                                        nalezeno = true;
                                        break;
                                    }
                                }
                                if(!nalezeno){
                                    herci.add(new Herci(herec));
                                }
                            }
                        }
                    }
                    int hodnoceni = rs.getInt(6);
                    String slovniHodnoceni = rs.getString(7);
                    HranyFilm film =new HranyFilm(nazev, reziser, rokVydani, seznamHercu, hodnoceni, slovniHodnoceni);
                    hranefilmy.add(film);
                }
                else
                {
                    String nazev = rs.getString(2);
                    String reziser = rs.getString(3);
                    int rokVydani = rs.getInt(4);
                    List<String> seznamHercu= new ArrayList<String>(); 
                    String herciText = rs.getString(5);
                    for (String herec : herciText.split(";")){
                        herec = ConsoleInput.upravJmeno(herec);
                        seznamHercu.add(herec);
                        Boolean nalezeno = false;
                        for (Herci her : herci){
                            if(her.getJmeno().equals(herec)){
                                her.pridejFilm(nazev, seznamHercu);
                                nalezeno = true;
                                break;
                            }
                        }
                        if(!nalezeno){
                            herci.add(new Herci(herec));
                        }
                    }
                    int hodnoceni = rs.getInt(6);
                    String slovniHodnoceni = rs.getString(7);
                    int doporucenyVek = rs.getInt(8);
                    AnimovanyFilm film =new AnimovanyFilm(nazev, reziser, rokVydani, seznamHercu, hodnoceni, slovniHodnoceni,doporucenyVek);
                    animovanefilmy.add(film);
                }
            }
            con.close();
        }catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

}
