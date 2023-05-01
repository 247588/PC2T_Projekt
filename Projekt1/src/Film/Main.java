package Film;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
   
    private static Manager editor = new Manager();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        List<AnimovanyFilm> animovaneFilmy = new ArrayList<AnimovanyFilm>();
        List<HranyFilm> hraneFilmy = new ArrayList<HranyFilm>();
        List<Herci> herci = new ArrayList<Herci>();
        int choice;
        DBConnect.nactiData(animovaneFilmy, hraneFilmy, herci);
        do{
            System.out.println("Vyberte akci:");
            System.out.println("1 - Vytvořit nový film");
            System.out.println("2 - Upravit film");
            System.out.println("3 - Smazat film");
            System.out.println("4 - Přidat hodnocení");
            System.out.println("5 - Výpis filmů");
            System.out.println("6 - Vyhledávání filmů");
            System.out.println("7 - Výpis herců nebo animatorů");
            System.out.println("8 - Výpis filmů podle herce nebo animatora");
            System.out.println("9 - Uložit data do souboru");
            System.out.println("10 - Načíst data ze souboru");
            System.out.println("11 - Ukončit program");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Manager.novyfilm(hraneFilmy, animovaneFilmy);
                    break;
                case 2:
                   Manager.upravitfilm(hraneFilmy, animovaneFilmy);
                    break;
                case 3:
                    Manager.deletefilm(hraneFilmy, animovaneFilmy);
                    break;
                case 4:
                   Manager.pridatHodnoceni(hraneFilmy, animovaneFilmy);
                    break;
                case 5:
                    Manager.vypisFilmy(hraneFilmy, animovaneFilmy);
                    break;
                case 6:
                    Manager.vypispodlenazvu(hraneFilmy, animovaneFilmy);
                    break;
                case 7:
                    
                    break;
                case 8:
                   
                    break;
                case 9:
                   Manager.txtfile(hraneFilmy, animovaneFilmy);
                    break;
                case 10:
                   Manager.filmztxt(hraneFilmy, animovaneFilmy, herci);
                    break;
                case 11:
                    DBConnect.zapisData(hraneFilmy,animovaneFilmy);
                    break;
                default:
                    System.out.println("Neplatná volba.");
            }
        }while(choice !=11);
    }
}

