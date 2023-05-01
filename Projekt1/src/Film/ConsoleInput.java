package Film;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput {
    public static int getInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Neplatný vstup. Zadejte celé číslo: ");
            sc.next();
        }
        return sc.nextInt();
    }

    public static int getIntInRange(Scanner sc, int min, int max) {
        int input = getInt(sc);
        while (input < min || input > max) {
            System.out.printf("Neplatný vstup. Zadejte celé číslo v rozsahu %d až %d: ", min, max);
            input = getInt(sc);
        }
        return input;
    }
    public static boolean dotupnyNazev(String nazev, List<HranyFilm> hraneFilmy, List<AnimovanyFilm> animovaneFilmy){
        for (AnimovanyFilm film : animovaneFilmy) {
            if(film.getNazev().equals(nazev)){
                return false;
            }
        }
        for (HranyFilm film : hraneFilmy) {
            if(film.getNazev().equals(nazev)){
                return false;
            }
        }
        return true;
    }

    public static String upravJmeno(String jmeno)
    {
        jmeno=jmeno.toLowerCase();
        String[] slova  = jmeno.split(" ");
        jmeno="";
        for (String slovo : slova) {
            jmeno += slovo.substring(0, 1).toUpperCase()+slovo.substring(1)+" ";

        }
        jmeno = jmeno.substring(0, jmeno.length()-1);
        return jmeno;
    }

}

