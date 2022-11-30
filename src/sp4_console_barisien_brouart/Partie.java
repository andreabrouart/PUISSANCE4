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
public void lancerPartie(){
    
}
}
