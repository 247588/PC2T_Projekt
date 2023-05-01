package Film;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimovanyFilm extends Film {

    private List<String> seznamHercu;
    private int hodnoceni;
    private String slovniHodnoceni;
    private int doporucenyVek;

    public AnimovanyFilm(String nazev, String reziser, int rokVydani, int doporucenyVek) {
        super(nazev, reziser, rokVydani);
        this.seznamHercu = new ArrayList<>();
        this.doporucenyVek = doporucenyVek;
    }

    public AnimovanyFilm(String nazev, String reziser, int rokVydani, List<String> seznamHercu, int doporucenyVek) {
        super(nazev, reziser, rokVydani);
        this.seznamHercu = seznamHercu;
        this.doporucenyVek = doporucenyVek;
    }

    public AnimovanyFilm(String nazev, String reziser, int rokVydani, List<String> seznamHercu, int hodnoceni, String slovniHodnoceni, int doporucenyVek) {
        super(nazev, reziser, rokVydani);
        this.seznamHercu = seznamHercu;
        this.hodnoceni = hodnoceni;
        this.slovniHodnoceni = slovniHodnoceni;
        this.doporucenyVek = doporucenyVek;
    }

    @Override
    public String filmToString() {
        String herci = "\n    Seznam animatoru: \n";
        if (this.seznamHercu != null) {
            for (String jmeno : this.seznamHercu) {
                herci += "    " + jmeno + "\n";
            }
        }
        return super.filmToString() + herci + "    Doporučený věk: " + this.doporucenyVek;
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
        System.out.print("Zadej hodnocení (1-10): ");
        int hodnoceni = ConsoleInput.getInt(sc);
        if (hodnoceni > 1 && hodnoceni < 10) {
            this.hodnoceni = hodnoceni;
        } else {
            System.out.println("Hodnocení musí být v rozmezí 1-10.");
            setHodnoceni(sc);
        }
    }

    public String getSlovniHodnoceni() {
        if (slovniHodnoceni == null || slovniHodnoceni.equals("")) {
            return "nebylo zatím zadáne zadne slovni hodnoceni";
                    } else {
            return slovniHodnoceni;
        }
    }

    public void setHodnoceniSlovne(String hodnoceniSlovne) {
        this.slovniHodnoceni = hodnoceniSlovne;
    }

    public int getDoporucenyVek() {
        return doporucenyVek;
    }

    public void setDoporucenyVek(int doporucenyVek) {
        this.doporucenyVek = doporucenyVek;
    }
}