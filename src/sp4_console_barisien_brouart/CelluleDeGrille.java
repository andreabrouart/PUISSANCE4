/*BARISIEN / BROUART TDB 18/11/22 */
package sp4_console_barisien_brouart;

/**
 *
 * @author Asus
 */
public class CelluleDeGrille {
    private Jeton jetonCourant;
    private boolean avoirTrouNoir;
    private boolean avoirDesintegrateur;
    
    public CelluleDeGrille(){
        jetonCourant = null;
        avoirTrouNoir = false;
        avoirDesintegrateur = false;
        
    }
    public boolean presenceJeton(){
        if (jetonCourant == null){
            return false;
            
        }else{
            return true;
        }
    }
    public String lireCouleurDuJeton(){
    if (jetonCourant != null){
        if(jetonCourant.toString() == "R"){
            return "rouge";
        }else{
            return "jaune";
        }
    }else{
            return "vide";
 }    
    }
    
public void placerTrouNoir(){
    if (avoirTrouNoir ==false){
        avoirTrouNoir = true;
    }else{
        avoirTrouNoir = true;
    }
}
public void supprimerTrouNoir(){
    if (avoirTrouNoir == true){
        avoirTrouNoir = false;
    }else{
        avoirTrouNoir= false;
    }
    
}
public boolean presenceTrouNoir(){
    if (avoirTrouNoir ==true){
        return true;
    }else{
        return false;
    }
}
}




