
package Film;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Manager {
    public static void novyfilm(List<HranyFilm> hraneFilmy, List<AnimovanyFilm> animovanyFilmy) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zadejte název filmu: ");
        String nazev = scanner.nextLine();

        System.out.print("Zadejte jméno režiséra: ");
        String reziser = scanner.nextLine();

        System.out.print("Zadejte rok vydání: ");
        int rok = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Zadejte počet herců nebo animatorů: ");
        int pocet = scanner.nextInt();
        scanner.nextLine();

        ArrayList<String> seznamHercu = new ArrayList<>();
        for (int i = 0; i < pocet; i++) {
            System.out.print("Zadejte jméno herce nebo animátora: ");
            String jmeno = scanner.nextLine();
            seznamHercu.add(jmeno);
        }
        
        System.out.print("Je film animovaný? (ano/ne) ");
        String odpoved = scanner.nextLine();
        boolean animovany = false;
        if (odpoved.equals("ano")) {
            animovany = true;
        }

        
        if (animovany) {
            System.out.print("Zadejte doporučený věk pro film: ");
            int vek = scanner.nextInt();
            scanner.nextLine();
            animovanyFilmy.add(new AnimovanyFilm(nazev, reziser, rok, seznamHercu,vek));
        } else {
            hraneFilmy.add(new HranyFilm(nazev, reziser, rok, seznamHercu));
        }

        System.out.println("Byl vytvořen film: " +nazev);
    }
    public static void upravitfilm(List<HranyFilm> hraneFilmy, List<AnimovanyFilm> animovanyFilmy) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zadejte název filmu, který chcete upravit: ");
        String nazev = scanner.nextLine();
        int search = 0;
        int j=0;
     
        boolean jeAnimovany = false;

        for (HranyFilm film : hraneFilmy) {
            if (film.getNazev().equals(nazev)) {
             
                search = 1;
                break;
            }
        }

        if (search == 0) {
            for (AnimovanyFilm film : animovanyFilmy) {
                if (film.getNazev().equals(nazev)) {
                   
                    jeAnimovany = true;
                    search = 2;
                    break;
                }
                j++;
            }
        }


        switch(search){
            case 1:
        HranyFilm nalezenyFilm = hraneFilmy.get(j);
        System.out.println("Zadejte, co chcete upravit (nazev, reziser, rok, herci, vek):");
        String coChceteUpravit = scanner.nextLine();

        switch (coChceteUpravit) {
            case "nazev":
                System.out.print("Zadejte nový název filmu: ");
                String novyNazev = scanner.nextLine();
                nalezenyFilm.setNazev(novyNazev);
                break;
            case "reziser":
                System.out.print("Zadejte nového režiséra: ");
                String novyReziser = scanner.nextLine();
                nalezenyFilm.setReziser(novyReziser);
                break;
            case "rok":
                System.out.print("Zadejte nový rok vydání: ");
                int novyRok = scanner.nextInt();
                scanner.nextLine();
                nalezenyFilm.setRokVydani(novyRok);
                break;
            case "herci":            
                System.out.print("Zadejte počet herců nebo animatorů: ");
                int pocet = scanner.nextInt();
                scanner.nextLine();
                ArrayList<String> seznamHercu = new ArrayList<>();
                for (int i = 0; i < pocet; i++) {
                    System.out.print("Zadejte jméno herce nebo animátora: ");
                    String jmeno = scanner.nextLine();
                    seznamHercu.add(jmeno);
                }
                nalezenyFilm.setSeznamHercu(seznamHercu);
                break;
            default:
                System.out.println("Neplatná volba.");
                break;
        }
        break;
            case 2:
                AnimovanyFilm nalezenyFilm1 = animovanyFilmy.get(j);
                 System.out.println("Zadejte, co chcete upravit (nazev, reziser, rok, herci, vek):");
                   String coChceteUpravit1 = scanner.nextLine();
                 switch (coChceteUpravit1) {
            case "nazev":
                System.out.print("Zadejte nový název filmu: ");
                String novyNazev = scanner.nextLine();
                nalezenyFilm1.setNazev(novyNazev);
                break;
            case "reziser":
                System.out.print("Zadejte nového režiséra: ");
                String novyReziser = scanner.nextLine();
                nalezenyFilm1.setReziser(novyReziser);
                break;
            case "rok":
                System.out.print("Zadejte nový rok vydání: ");
                int novyRok = scanner.nextInt();
                scanner.nextLine();
                nalezenyFilm1.setRokVydani(novyRok);
                break;
            case "herci":            
                System.out.print("Zadejte počet herců nebo animatorů: ");
                int pocet = scanner.nextInt();
                scanner.nextLine();
                ArrayList<String> seznamHercu = new ArrayList<>();
                for (int i = 0; i < pocet; i++) {
                    System.out.print("Zadejte jméno herce nebo animátora: ");
                    String jmeno = scanner.nextLine();
                    seznamHercu.add(jmeno);
                }
                nalezenyFilm1.setSeznamHercu(seznamHercu);
                break;
            case "vek":
                if (jeAnimovany) {
                    System.out.print("Zadejte nový doporučený věk pro film: ");
                    int novyVek = scanner.nextInt();
                    scanner.nextLine();
                    ((AnimovanyFilm) nalezenyFilm1).setDoporucenyVek(novyVek);
                } else {
                    System.out.println("Tento film není animovaný a nelze upravit věk.");
                }
                break;
            }
        }
    }
    public static void deletefilm(List<HranyFilm> hraneFilmy, List<AnimovanyFilm> animovanyFilmy) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Zadejte název filmu, který chcete smazat: ");
    String nazev = scanner.nextLine();

    boolean bylSmazan = false;

    for (int i = 0; i < hraneFilmy.size(); i++) {
        if (hraneFilmy.get(i).getNazev().equals(nazev)) {
            hraneFilmy.remove(i);
            bylSmazan = true;
            break;
        }
    }

    if (!bylSmazan) {
        for (int i = 0; i < animovanyFilmy.size(); i++) {
            if (animovanyFilmy.get(i).getNazev().equals(nazev)) {
                animovanyFilmy.remove(i);
                bylSmazan = true;
                break;
            }
        }
    }

    if (bylSmazan) {
        System.out.println("Film byl úspěšně smazán.");
    } else {
        System.out.println("Film nebyl nalezen.");
    }
}
 public static void pridatHodnoceni(List<HranyFilm> hraneFilmy, List<AnimovanyFilm> animovanyFilmy) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Zadejte název filmu: ");
    String nazev = scanner.nextLine();

    System.out.print("Jaky film chcete hodnotit? (1=hrany,2=animovany) ");
    int hodnoceni = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Přidat slovní hodnocení? (ano/ne) ");
    String odpoved = scanner.nextLine();
    String slovniHodnoceni = "";
    if (odpoved.equals("ano")) {
        System.out.print("Zadejte slovní hodnocení: ");
        slovniHodnoceni = scanner.nextLine();
    }

   
    boolean nalezene = false;
    for (HranyFilm film : hraneFilmy) {
        if (film.getNazev().equals(nazev)) {
            film.setHodnoceni(scanner);
            film.setHodnoceniSlovne(slovniHodnoceni);
            nalezene = true;
            break;
        }
    }
    if (!nalezene) {
        for (AnimovanyFilm film : animovanyFilmy) {
            if (film.getNazev().equals(nazev)) {
                film.setHodnoceni(scanner);
                film.setHodnoceniSlovne(slovniHodnoceni);
                nalezene = true;
                break;
            }
        }
    }
    if (!nalezene) {
        System.out.println("Film nebyl nalezen.");
    } else {
        System.out.println("Hodnocení bylo přidáno.");
    }
} 
 public static void vypisFilmy(List<HranyFilm> hraneFilmy, List<AnimovanyFilm> animovanyFilmy) {
    System.out.println("Seznam všech filmů:");
    
    System.out.println("Hrané filmy:");
    for (HranyFilm film : hraneFilmy) {
        System.out.println(film.getNazev() + ", " + film.getReziser() + ", " + film.getRokVydani()+ ", " + film.getSeznamHercu());
    }
    
    System.out.println("Animované filmy:");
    for (AnimovanyFilm film : animovanyFilmy) {
        System.out.println(film.getNazev() + ", " + film.getReziser() + ", " + film.getRokVydani() + ", " + film.getSeznamHercu() + ", " + film.getDoporucenyVek());
    }
}
public static void vypispodlenazvu(List<HranyFilm> hraneFilmy, List<AnimovanyFilm> animovanyFilmy) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Zadejte nazev filmu, ktery chcete vyhledat.");
    String nazevFilmu = sc.next();
    boolean nalezene = false;
    for (HranyFilm film : hraneFilmy) {
        if (film.getNazev().equals(nazevFilmu)) {
            System.out.println("Název: " + film.getNazev());
            System.out.println("Reziser: " +film.getReziser());
            System.out.println("Rok vydání: " + film.getRokVydani());
            System.out.println("Herci: " + film.getSeznamHercu());
            System.out.println("Hodnocení: " + film.getHodnoceni());  
            System.out.println("Slovni hodnoceni: " +film.getHodnoceniSlovne());
            nalezene = true;
        }
    }
    if (!nalezene) {
        for (AnimovanyFilm film : animovanyFilmy) {
            if (film.getNazev().equals(nazevFilmu)) {
            System.out.println("Název: " + film.getNazev());
            System.out.println("Reziser: " +film.getReziser());
            System.out.println("Rok vydání: " + film.getRokVydani());
            System.out.println("Animatori: " + film.getSeznamHercu());
            System.out.println("Hodnocení: " + film.getHodnoceni());
                System.out.println("Slovni hodnoceni: " +film.getSlovniHodnoceni());
                System.out.println("Doporuceny vek: " + film.getDoporucenyVek());
                nalezene = true;
            }
        }
    }
    if (!nalezene) {
        System.out.println("Film nebyl nalezen.");
    }
}
public static void txtfile(List<HranyFilm> hraneFilmy, List<AnimovanyFilm> animovanyFilmy) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Zadejte název filmu, který chcete zapsat do souboru:");
    String nazevFilmu = sc.nextLine();
    System.out.println("Zadejte název souboru, do kterého se mají informace o filmu zapsat:");
    String nazevSouboru = sc.nextLine();
    boolean nalezene = false;
    for (HranyFilm film : hraneFilmy) {
        if (film.getNazev().equals(nazevFilmu)) {
            try (FileWriter fw = new FileWriter(nazevSouboru, true)) {
                fw.write("Druh : 1 \n");
                fw.write("Název: " + film.getNazev() + "\n");
                fw.write("Režisér: " + film.getReziser() + "\n");
                fw.write("Rok vydání: " + film.getRokVydani() + "\n");
                fw.write("Herci: " + film.getSeznamHercu() + "\n");
                fw.write("Hodnocení: " + film.getHodnoceni() + "\n");
                fw.write("Slovni hodnoceni: " + film.getHodnoceniSlovne() + "\n");
                nalezene = true;
            } catch (IOException e) {
                System.err.println("Nepodařilo se zapsat do souboru: " + e.getMessage());
            }
        }
    }
    if (!nalezene) {
        for (AnimovanyFilm film : animovanyFilmy) {
            if (film.getNazev().equals(nazevFilmu)) {
                try (FileWriter fw = new FileWriter(nazevSouboru, true)) {
                    fw.write("Druh : 2 \n");
                    fw.write("Název: " + film.getNazev() + "\n");
                    fw.write("Režisér: " + film.getReziser() + "\n");
                    fw.write("Rok vydání: " + film.getRokVydani() + "\n");
                    fw.write("Animatori: " + film.getSeznamHercu() + "\n");
                    fw.write("Hodnocení: " + film.getHodnoceni() + "\n");
                    fw.write("Slovni hodnoceni: " + film.getSlovniHodnoceni() + "\n");
                    fw.write("Doporučený věk: " + film.getDoporucenyVek() + "\n");
                    nalezene = true;
                } catch (IOException e) {
                    System.err.println("Nepodařilo se zapsat do souboru: " + e.getMessage());
                }
            }
        }
    }
    if (!nalezene) {
        System.out.println("Film nebyl nalezen.");
    } else {
        System.out.println("Informace o filmu byly úspěšně zapsány do souboru.");
    }
}

public static void filmztxt(List<HranyFilm> hraneFilmy, List<AnimovanyFilm> animovaneFilmy, List<Herci> herci) throws FileNotFoundException {

    Scanner sc = new Scanner(System.in);
    System.out.println("Zadejte název souboru, ze kterého chcete načíst informace:");
    String nazevSouboru = sc.nextLine();
    try (Scanner souborSc = new Scanner(new File(nazevSouboru))) {
        while (souborSc.hasNextLine()) {
            String radek = souborSc.nextLine();
            String[] atributy = radek.split(":");
            int typFilmu = Integer.parseInt(atributy[1]);
            if (typFilmu == 1) {
                String nazev = "";
                String reziser = "";
                int rokVydani = 0;
                List<String> seznamHercu = new ArrayList<>();
                int hodnoceni = 0;
                String hodnoceniSlovne = "";

                while (souborSc.hasNextLine() && !(radek = souborSc.nextLine()).isEmpty()) {
                    atributy = radek.split(":");
                    switch (atributy[0]) {
                        case "Nazev":
                            nazev = atributy[1];
                            break;
                        case "Reziser":
                            reziser = atributy[1];
                            break;
                        case "Rok vydani":
                            rokVydani = Integer.parseInt(atributy[1]);
                            break;
                        case "Seznam hercu":
                            seznamHercu = Arrays.asList(atributy[1].split(", "));
                            break;
                        case "Hodnoceni":
                            hodnoceni = Integer.parseInt(atributy[1]);
                            break;
                        case "Hodnoceni slovne":
                            hodnoceniSlovne = atributy[1];
                            break;
                    }
                }

                HranyFilm film = new HranyFilm(nazev, reziser, rokVydani, seznamHercu, hodnoceni, hodnoceniSlovne);
                hraneFilmy.add(film);
            } else if (typFilmu == 2) {
                String nazev = "";
                String reziser = "";
                int rokVydani = 0;
                List<String> seznamHercu = new ArrayList<>();
                int hodnoceni = 0;
                String hodnoceniSlovne = "";
                int doporucenyVek = 0;

                while (souborSc.hasNextLine() && !(radek = souborSc.nextLine()).isEmpty()) {          
                       atributy = radek.split(":");
                    switch (atributy[0]) {
                        case "Nazev":
                            nazev = atributy[1];
                            break;
                        case "Reziser":
                            reziser = atributy[1];
                            break;
                        case "Rok vydani":
                            rokVydani = Integer.parseInt(atributy[1]);
                            break;
                        case "Seznam hercu":
                            seznamHercu = Arrays.asList(atributy[1].split(", "));
                            break;
                        case "Hodnoceni":
                            hodnoceni = Integer.parseInt(atributy[1]);
                            break;
                        case "Hodnoceni slovne":
                            hodnoceniSlovne = atributy[1];
                            break;
                        case "Doporuceny vek":
                            doporucenyVek = Integer.parseInt(atributy[1]);
                            break;
                    }
                }
                AnimovanyFilm film = new AnimovanyFilm(nazev, reziser, rokVydani, seznamHercu, hodnoceni, hodnoceniSlovne, doporucenyVek);
                animovaneFilmy.add(film);
            }
        }
        System.out.println("Film byl nacten.");
    }
}

}


