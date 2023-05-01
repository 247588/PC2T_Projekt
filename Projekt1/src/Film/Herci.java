 
package Film;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Herci {

    private Map<String, List<String>> filmyPodleHercu; 
    String jmeno;
    public Herci() {
        filmyPodleHercu = new HashMap<>();
    }
 public static String vytvoritSeznam(List<String> seznamHercu){
        String seznam="";
        if(seznamHercu!=null){
            for (String jmeno : seznamHercu){
                seznam+=jmeno+";";
            }
            seznam= seznam.substring(0, seznam.length()-1);
        }
        return seznam;
    }
    public void pridejFilm(String nazevFilmu, List<String> herci) {
        for (String herc : herci) {
            if (!filmyPodleHercu.containsKey(herc)) {
                filmyPodleHercu.put(herc, new ArrayList<>());
            }
            filmyPodleHercu.get(herc).add(nazevFilmu);
        }
    }


    public void vypisOpakujiciSeHerci(List<String> seznamHercu) {
        Map<String, List<String>> opakujiciSeHerci = new HashMap<>();
        for (String herc : filmyPodleHercu.keySet()) {
            List<String> filmy = filmyPodleHercu.get(herc);
            if (filmy.size() > 1) {
                opakujiciSeHerci.put(herc, filmy);
            }
        }

        if (opakujiciSeHerci.isEmpty()) {
            System.out.println("Žádný herec se neobjevil ve více než jednom filmu.");
        } else {
            System.out.println("Herci, kteří se objevili ve více než jednom filmu:");
            for (String herc : opakujiciSeHerci.keySet()) {
                List<String> filmy = opakujiciSeHerci.get(herc);
                System.out.println(herc + " (" + filmy.size() + " film/y):");
                for (String nazevFilmu : filmy) {
                    System.out.println("  - " + nazevFilmu);
                }
            }
        }
    }

    public Herci(String jmeno) {
        this.jmeno = jmeno;
    }

    public Map<String, List<String>> getFilmyPodleHercu() {
        return filmyPodleHercu;
    }

    public void setFilmyPodleHercu(Map<String, List<String>> filmyPodleHercu) {
        this.filmyPodleHercu = filmyPodleHercu;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }
    
}