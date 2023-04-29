package dbconnection;
import Queries.UpdateFilm;
import Queries.InsertNewFilm;
import Queries.SelectFilm;
import Queries.DeleteFilm;
import dbconn.DBConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import Queries.UpdateRev;
public class RunApp {
    public static void main(String[] args) throws SQLException{
        Scanner sc = new Scanner(System.in);
        int volba = 0;
        boolean run = true;       
        int zanr;
        while(run){            
                System.out.println(" ");
                System.out.println("Vyberte jednu z moznosti:");
                System.out.println("1. Pridat film");
                System.out.println("2. Upravit film");
                System.out.println("3. Smazat film");
                System.out.println("4. Pridat hodnoceni");
                System.out.println("5. Vypis filmu");
                System.out.println("6. Vyhledani filmu");
                System.out.println("7. Vypis hercu nebo animatoru, kteri se podileli na vic nez jednom filmu");
                System.out.println("8. Vypis filmu podle konktretniho herce nebo animatora");
                System.out.println("9. Ulozeni informaci o filmu do souboru podle jeho jmena");
                System.out.println("10. Nacteni informaci o filmu");
                System.out.println("11. Ukonceni programu");               
            volba=sc.nextInt();
            switch(volba){
                case 1:
                    InsertNewFilm i = new InsertNewFilm(); 
                    System.out.println("Jaky film chcete pridat? 1=hrany, 2=animovany");                  
                    zanr = sc.nextInt();           
                    if(zanr == 1){                        
                        System.out.println("Zadejte nazev filmu: ");
                        String nazev = sc.next();
                        System.out.println("Zadejte rezisera filmu: ");
                        String reziser = sc.next();
                        System.out.println("Zadejte rok vydani: ");
                        int rok = sc.nextInt();     
                        sc.nextLine();
                        System.out.println("Zadejte jmena hercu");
                        while (true) {
                        String herci = sc.nextLine();
                        if (herci.equals("")) {
                        break;
                        }
                        i.insertherci(nazev, herci);
                        }                       
                        i.insertnewhrany(nazev, reziser, rok);
                      
                        
                    }                   
                        else if(zanr == 2){
                        System.out.println("Zadejte nazev filmu: ");
                        String nazevA = sc.next();
                        System.out.println("Zadejte rezisera filmu: ");
                        String reziserA = sc.next();
                        System.out.println("Zadejte rok vydani: ");
                        int rokA = sc.nextInt();                     
                        System.out.println("Zadejte doporuceny vek: ");
                        int vek = sc.nextInt();   
                        sc.nextLine();
                        System.out.println("Zadejte jmena animatoru");  
                        while(true){
                            String animatori = sc.nextLine();
                            if(animatori.equals("")){
                                break;
                            }
                            i.insertanimatori(nazevA, animatori);
                        }
                        i.insertnewanimovany(nazevA, reziserA, rokA,vek);  
      
                        }
                    break;
                case 2:
                    System.out.println("Jaky film chcete uptavit?");
                    UpdateFilm uf = new UpdateFilm();
                    zanr = sc.nextInt();
                    switch(zanr){                  
                        case 1:
                    System.out.println("Chcete provest zmenu jmena?");                  
                    System.out.println("Zadejte jmeno filmu?");
                    String nazevS = sc.next();                
                    System.out.println("Zadejte novy nazev: ");
                    String nazevUp = sc.next();
                    uf.UpdateNazevH(nazevUp,nazevS);
                    break;
                        case 2:
                    System.out.println("Zadejte jmeno filmu?");
                    String nazevA = sc.next();                   
                    System.out.println("Zadejte novy nazev: ");
                    String nazevUpA = sc.next();
                    uf.UpdateNazevA(nazevUpA,nazevA);
                    }
       
                    break;
                case 3:
                    DeleteFilm df = new DeleteFilm();
                    System.out.println("Jaky film chcete smazat? 1=hrane 2=animovane");
                    zanr = sc.nextInt();
                    switch(zanr){
                        case 1:                    
                     System.out.println("Zadejte jmeno filmu, ktery chcete odstranit.");
                     String nazevH = sc.next();
                     df.deleteF(nazevH);
                     df.deleteFR(nazevH);
                     break;
                        case 2:             
                     System.out.println("Zadejte jmeno filmu, ktery chcete odstranit.");
                     String nazevA = sc.next();
                     df.deleteA(nazevA); 
                     df.deleteAF(nazevA);
                     break;
                    }
                    break;
                case 4:
                    UpdateRev ur = new UpdateRev();
                    System.out.println("Jaky film chcete hodnotit? 1 = hrany 2 = animovany");
                    zanr = sc.nextInt();
                    switch(zanr){
                        case 1:
                            System.out.println("Zadejte jmeno filmu, ktery chcete hodnotit.");
                            String nazev = sc.next();
                            System.out.println("Ohodnotte film 1 az 5 hvezdami");
                            String hodnoceni = sc.next();                          
                            //inf.inserthranyrev(nazev, hodnoceni);
                            break;
                        case 2:
                            System.out.println("Zadejte jmeno filmu, ktery chcete hodnotit.");
                            String nazev1 = sc.next();
                            System.out.println("Ohodnotte film 1-10");
                            int hodnoceni1 = sc.nextInt();                          
                            ur.updatemovanyrev(nazev1, hodnoceni1);
                            break;
                    }
                    break;
                case 5:
                    SelectFilm sf = new SelectFilm();
                    sf.getHrane();        
                    sf.getHranerev();               
                    sf.getAnimovane();                
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    run = false;
                        DBConnection.closeConnection();
                    break;
                default:
                    run = false;
                        DBConnection.closeConnection();
                    break;
            }
        }
    }
}

