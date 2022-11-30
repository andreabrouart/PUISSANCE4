/*BARISIEN / BROUART TDB 18/11/22 */
package sp4_console_barisien_brouart;

import java.util.ArrayList;


/**
 *
 * @author Asus
 */
public class Joueur {
    private String Nom;
    private String Couleur;
    private ArrayList<Jeton> reserveJetons =new ArrayList();
    private int nombreDesintegrateurs;
    
    public Joueur(String nom, String couleur, int des){
        Nom = nom;
        Couleur = couleur;
        nombreDesintegrateurs =des;
        des =0;
        
    }
}
