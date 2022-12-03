/*BARISIEN / BROUART TDB 18/11/22 */
package sp4_console_barisien_brouart;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Asus
 */

public class Partie {
    private Joueur[] listeJoueur  = new Joueur[2];
    private Joueur joueurCourant;
    private PlateauDeJeu plateau = new PlateauDeJeu();
    
    public Partie(Joueur joueur1, Joueur joueur2){
        listeJoueur[0]=joueur1;
        listeJoueur[1]=joueur2;
    }
    public void attribuerCouleurAuxJoueurs(){
        Random c = new Random();
        int var = c.nextInt(0,2);
        if (var==1){
            listeJoueur[0].affecterCouleur("jaune");
            listeJoueur[1].affecterCouleur("rouge");
        }else{
            listeJoueur[0].affecterCouleur("rouge");
            listeJoueur[1].affecterCouleur("jaune");
        }
        
    }
    public void creerEtAffecterJeton(Joueur joueur){
        Jeton[] jetonsjoueur = new Jeton[30];
        for (int i=0; i<30; i++){
            jetonsjoueur[i] = new Jeton(joueur.lireCouleur());
            joueur.ajouterJeton(jetonsjoueur[i]); 
        }
    }
    public void placerTrousNoirsEtDesintegrateurs(){
        Random l = new Random();
        Random c = new Random();
        for (int i=0; i<3; i++){
            int ligne =l.nextInt(0,6);
            int colonne =c.nextInt(0,7);
            if (plateau.presenceTrouNoir(ligne, colonne)==false && plateau.presenceDesintegrateur(ligne, colonne)==false){
                plateau.placerTrouNoir(ligne, colonne);
                plateau.placerDesintegrateur(ligne,colonne);
            }else{
                i-=1;
        }
    }
        for (int j=0; j<2; j++){
            int ligne =l.nextInt(0,6);
            int colonne =c.nextInt(0,7);
            if (plateau.presenceTrouNoir(ligne, colonne)==false && plateau.presenceDesintegrateur(ligne, colonne)==false){
            plateau.placerTrouNoir(ligne, colonne);
        }else{
                j-=1;
            }
        }
        for (int k=0; k<2; k++){
            int ligne =l.nextInt(0,6);
            int colonne =c.nextInt(0,7);
            if (plateau.presenceTrouNoir(ligne, colonne)==false && plateau.presenceDesintegrateur(ligne, colonne)==false){
                plateau.placerDesintegrateur(ligne, colonne);
        }else{
                k-=1;
    }
        }
    }
public void initialiserPartie(){
    attribuerCouleurAuxJoueurs();
    creerEtAffecterJeton(listeJoueur[0]);
    creerEtAffecterJeton(listeJoueur[1]);
    placerTrousNoirsEtDesintegrateurs();   
}
public void lancerPartie() {
        initialiserPartie();
        
        // on choisit un joueur pour commencer
        joueurCourant = listeJoueur[0];
        
        // tant que le joueur a pas gagne, ni l'auter joueur, et que la grille est pas remplie
        while (plateau.partieGagnante( listeJoueur[0].lireCouleur())== false && plateau.partieGagnante( listeJoueur[1].lireCouleur())== false && plateau.grilleRemplie() == false) {
            
            // demander au joueur son coup à jouer
            System.out.println("Si vous voulez ajouter un jeton, tapez 1\nSi vous voulez retirer un de vos jetons, tapez 2\nSi vous voulez desintégrer un jeton du joueur adverse, tapez 3");
            Scanner sc = new Scanner(System.in);
            int cas = sc.nextInt();
            
            // exécuter le coup
            // cas 1: ajout d'un jeton : on ajoute, on active le trou noir potentiel et je donne le desintegrateur potentiel
            if (cas==1){
                System.out.println("Donnez le numéro de la colonne");
                String col=sc.nextLine();
                int y = Integer.parseInt(col);
                
                Jeton j = joueurCourant.jouerJeton();
                plateau.ajouterJetonDansColonne(j, y);
                plateau.placerTrouNoir(y, y);
                plateau.placerDesintegrateur(y, y);
            }
            
            // cas 2 : recupeter jeton : je recupere le jeton de la grille, le redonne au joueur, et tasse la colonne
            if (cas==2){
                System.out.println("Donnez le numéro de la ligne");
                String lig=sc.nextLine();
                int x = Integer.parseInt(lig);
                System.out.println("Donnez le numéro de la colonne");
                String col=sc.nextLine();
                int y = Integer.parseInt(col);
                plateau.recupererJeton(x, y);
                plateau.ajouterJeton(jeton);
                plateau.tasserColonne(y);
            }
            
            // cas 3 : desintegrateur : je supprime le jeton de la grille ,et je tasse la colonne
            if (cas==3){
                System.out.println("Donnez le numéro de la ligne");
                String lig=sc.nextLine();
                int x = Integer.parseInt(lig);
                System.out.println("Donnez le numéro de la colonne"); 
                String col=sc.nextLine();
                int y = Integer.parseInt(col);
                plateau.placerDesintegrateur(x, y);
                plateau.supprimerJeton(x, y);
                plateau.tasserColonne(y);               
            }
            
        }
        
        
}
}