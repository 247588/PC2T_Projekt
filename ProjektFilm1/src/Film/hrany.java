package Film;

import java.util.List;

public class hrany extends Film{
    private int hvezdicky;
    public hrany(String nazev, String reziser, int rok, List<String> obsazeni, int hodnoceni) {
        super(nazev, reziser, rok, obsazeni, hodnoceni);
        this.hvezdicky=hvezdicky;
    }

    public int getHvezdicky() {
        return hvezdicky;
    }

    public void setHvezdicky(int hvezdicky) {
        this.hvezdicky = hvezdicky;
    }

    @Override
    public void vypis() {
        System.out.println("Nazev: "+getNazev());
        System.out.println("Reziser: "+getReziser());
        System.out.println("Rok: "+getRok());
        System.out.println("Obsazeni: "+getObsazeni());
        System.out.println("Hodnoceni: "+getHodnoceni());
        System.out.println("Nazev: "+getHvezdicky());
        
    }
    
}
