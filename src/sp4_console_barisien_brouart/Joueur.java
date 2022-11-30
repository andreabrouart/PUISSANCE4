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
    public void affecterCouleur(String couleur){
    Couleur = couleur;    
    
    
}

    public String lireCouleur() {
        return Couleur;
    }
    
    public int nombredeJetons(){
      int nbrjetons = reserveJetons.size();
      return nbrjetons;
    }
    public void ajouterJeton(Jeton jeton1){
        reserveJetons.add(jeton1);
    }
    public Jeton jouerJeton(){
        Jeton jet = reserveJetons.remove(0);
        return jet;
    }
    public void obtenirDesintegrateur(){
        nombreDesintegrateurs +=1;
    }
    public void utiliserDesintegrateur(){
        nombreDesintegrateurs-=1;
    }
    
}
