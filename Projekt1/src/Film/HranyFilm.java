package Film;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HranyFilm extends Film {
    private List<String> seznamHercu;
    private int hodnoceni;
    private String hodnoceniSlovne;

    public HranyFilm(String nazev, String reziser, int rokVydani) {
        super(nazev, reziser, rokVydani);
        this.seznamHercu = new ArrayList<>();
        this.hodnoceni = hodnoceni;
        this.hodnoceniSlovne = hodnoceniSlovne;
    }

    public HranyFilm(String nazev, String reziser, int rokVydani,List<String> seznamHercu) {
        super(nazev, reziser, rokVydani);
        this.seznamHercu = seznamHercu;
    }

    public HranyFilm(String nazev,String reziser,int rokVydani, List<String> seznamHercu, int hodnoceni, String hodnoceniSlovne) {
        super(nazev, reziser, rokVydani);
        this.seznamHercu = seznamHercu;
        this.hodnoceni = hodnoceni;
        this.hodnoceniSlovne = hodnoceniSlovne;
    }

       @Override
    public String filmToString() {
        String herci = "Seznam herců:\n";
        for (String herc : seznamHercu) {
            herci += "- " + herc + "\n";
        }
        return (super.filmToString() + herci);
    }
    

    public List<String> getSeznamHercu() {
        return seznamHercu;
    }

    public void setSeznamHercu(List<String> seznamHercu) {
        this.seznamHercu = seznamHercu;
    }

    public int getHodnoceni() {
        return hodnoceni;
    }

    public void setHodnoceni(Scanner sc) {
    System.out.print("Zadej hodnocení (1-5): ");
    int hodnoceni = ConsoleInput.getInt(sc);
    if (hodnoceni >= 1 && hodnoceni <= 5) {
        this.hodnoceni = hodnoceni;
    } else {
        System.out.println("Hodnocení musí být v rozsahu 1-5.");
        setHodnoceni(sc);
    }
}

    public String getHodnoceniSlovne() {
        if(hodnoceniSlovne == null){
            return " nebylo zatim zadane zadne slovni hodnoceni";
        }else{
        return hodnoceniSlovne;
        }
    }

    public void setHodnoceniSlovne(String hodnoceniSlovne) {
        this.hodnoceniSlovne = hodnoceniSlovne;
    }


}
