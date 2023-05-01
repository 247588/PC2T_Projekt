package Film;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class DBConnect {
   
      public static void zapisData(List<HranyFilm> hranefilmy,List<AnimovanyFilm> animovanefilmy){   
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:db/film.db";
            Connection con = DriverManager.getConnection(url);
            String sql = "DELETE FROM film";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();
            sql = "INSERT INTO film (druh, nazev, reziser, rok, herci, hodnoceni, hodnocenislovne) VALUES (?, ?, ?, ?, ?, ?, ?)";
            statement = con.prepareStatement(sql); 
            for (HranyFilm film : hranefilmy){
                statement.setInt(1, 1);
                statement.setString(2, film.getNazev());
                statement.setString(3, film.getReziser());
                statement.setInt(4, film.getRokVydani());
               statement.setString(5, Herci.vytvoritSeznam(film.getSeznamHercu())); 
                statement.setInt(6, film.getHodnoceni());
                statement.setString(7, film.getHodnoceniSlovne());
                statement.executeUpdate();
            }
            sql = "INSERT INTO film(druh,nazev,reziser,rok,herci,hodnoceni,hodnocenislovne,vek)VALUES(?,?,?,?,?,?,?,?)";
            statement = con.prepareStatement(sql); 
            for (AnimovanyFilm film : animovanefilmy) {
                statement.setInt(1, 2);
                statement.setString(2, film.getNazev());
                statement.setString(3, film.getReziser());
                statement.setInt(4, film.getRokVydani());
                if(!film.getSeznamHercu().isEmpty()){
                    statement.setString(5, Herci.vytvoritSeznam(film.getSeznamHercu()));
                }
                else{
                    statement.setString(5, "nic");
                }
                statement.setInt(6, film.getHodnoceni());
                statement.setString(7, film.getSlovniHodnoceni());
                statement.setInt(8, film.getDoporucenyVek());
                statement.executeUpdate();
            }
            statement.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
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