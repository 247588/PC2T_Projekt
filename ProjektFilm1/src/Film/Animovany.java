package Film;

import java.util.List;

public class Animovany extends Film {
int vek;
int cishod;
    public Animovany(String nazev, String reziser, int rok, List<String> obsazeni, int hodnoceni) {
        super(nazev, reziser, rok, obsazeni, hodnoceni);
        this.vek=vek;
        this.cishod=cishod;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

    public int getCishod() {
        return cishod;
    }

    public void setCishod(int cishod) {
        this.cishod = cishod;
    }

    @Override
    public void vypis() {
        System.out.println("Nazev: "+getNazev());
        System.out.println("Reziser: "+getReziser());
        System.out.println("Rok: "+getRok());
        System.out.println("Obsazeni: "+getObsazeni());
        System.out.println("Hodnoceni: "+getHodnoceni());
        System.out.println("Nazev: "+getCishod());
        System.out.println("Vekova hrannice"+getVek());
    }
    
}
