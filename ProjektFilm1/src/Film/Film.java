package Film;

import java.util.List;

public abstract class Film {
    private String nazev;
    private String reziser;
    private int rok;
    private List<String> obsazeni;
    private int hodnoceni;

    public Film(String nazev, String reziser, int rok, List<String> obsazeni, int hodnoceni) {
        this.nazev = nazev;
        this.reziser = reziser;
        this.rok = rok;
        this.obsazeni = obsazeni;
        this.hodnoceni = hodnoceni;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getReziser() {
        return reziser;
    }

    public void setReziser(String reziser) {
        this.reziser = reziser;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public List<String> getObsazeni() {
        return obsazeni;
    }

    public void setObsazeni(List<String> obsazeni) {
        this.obsazeni = obsazeni;
    }

    public int getHodnoceni() {
        return hodnoceni;
    }

    public void setHodnoceni(int hodnoceni) {
        this.hodnoceni = hodnoceni;
    }

public abstract void vypis();
    
}    
    
    

