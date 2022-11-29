/*BARISIEN / BROUART TDB 18/11/22 */
package sp4_console_barisien_brouart;

/**
 *
 * @author Asus
 */
public class PlateauDeJeu {
    CelluleDeGrille[][] grille = new CelluleDeGrille[6][7];

public PlateauDeJeu(){
for (int i =0; i<6; i++){
    for (int j =0; j<7; j++){
        grille[i][j] = new CelluleDeGrille();
    }
}
}
public int ajouterJetonDansColonne(Jeton j, int a){
    for (int k=5; k>=0; k++){
        if ("R".equals(grille[k][a].lireCouleurDuJeton())|| grille[k][a].lireCouleurDuJeton()=="J"){
            grille[k+1][a].affecterJeton(j);
            return k+1;
        }
}
    return 0;
}
public boolean grilleRemplie(){
   for (int j=0; j<7; j++){
       if (grille[5][j]==null){
           return false;
       }
   } 
   return true;
}
public void afficherGrilleSurConsole(){
    for (int i=0; i<6; i++){
        for (int j=0; j<7; j++){
            if (j==6){
                System.out.println(grille[i][j]+"\n");
            }else{
                System.out.println(grille[i][j] + " ");
            }
        }
    }
}
public boolean presenceJeton(int x, int y){
    if (grille[x][y].presenceJeton()==true){
        return true;
    }else{
    return false;
}
}
public String lireCouleurDuJeton(int x, int y){
    return grille[x][y].lireCouleurDuJeton();
}
public boolean ligneGagnantePourCouleur(String couleur){
    int cjg =0; //compte jeton gagnant
    for (int i=0; i<6; i++){
        for (int j=0; j<7; j++){
            if (grille[i][j].lireCouleurDuJeton()==couleur){
                cjg+=1;
                if (cjg==4){
                    return true;
                }
            }else{
                cjg=0;
            }
        }
        cjg=0;
    }
    return false;
}

public boolean colonneGagnantePourCouleur(String couleur){
    int cjg =0;
    for (int j=0; j<7; j++){
        for (int i=0; i<6; i++){
            if (grille[i][j].lireCouleurDuJeton()==couleur){
                cjg+=1;
                if (cjg==4){
                    return true;
            }
        }else{
                cjg=0;
            }
        }
        cjg=0;
        
}
    return false;
}
//public boolean diagonaleMontanteGagnantePourCouleur(String couleur){
//    int cjg=0;
//    for (int i=0; i<3; i++){
//        for (int j=0; j<4; j++)
//    }
//}
}


