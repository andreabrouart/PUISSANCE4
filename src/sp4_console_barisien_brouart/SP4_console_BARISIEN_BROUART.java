/*BARISIEN / BROUART TDB 18/11/22 */
package sp4_console_barisien_brouart;
import java.util.Scanner;
/**
 *
 * @author Asus
 */


public class SP4_console_BARISIEN_BROUART {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Jeton jeton1 = new Jeton("rouge");
     jeton1.lireCouleur();
     Jeton jeton2 = new Jeton("jaune");
     jeton2.lireCouleur();
     
     System.out.println("Vous entrez dans le jeu puissance 4");
     
     System.out.println("Entrez le nom du joueur 1");
     Scanner sc = new Scanner(System.in);
     String nomjoueur1 =sc.nextLine();
     Joueur j1 = new Joueur(nomjoueur1);
     
     System.out.println("Entrez le nom du joueur 2");
     String nomjoueur2 =sc.nextLine();
     Joueur j2 = new Joueur(nomjoueur2);
     
     Partie une_partie = new Partie(j1,j2);
     une_partie.lancerPartie();
     
     
    }
    
}
