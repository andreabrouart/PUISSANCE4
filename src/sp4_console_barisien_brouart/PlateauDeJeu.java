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
public int ajouterJetonDansColonne(Jeton j, int col){
    for (int k=5; k>=0; k++){
        if ("R".equals(grille[k][col].lireCouleurDuJeton())|| grille[k][col].lireCouleurDuJeton()=="J"){
            grille[k+1][col].affecterJeton(j);
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
public boolean diagonaleMontanteGagnantePourCouleur(String couleur){
    int cjg=0;
    for (int i=0; i<3; i++){
        for (int j=0; j<4; j++){
            for (int k=0; k<7; k++){
                if (grille[i+k][j+k].lireCouleurDuJeton()== couleur){
                    cjg +=1;
                }else{
                    cjg = 0;
                }
                if (cjg ==4){
                    return true;
                }
                if (i==5 && j==6){
                    break;
                }
            }
            cjg =0;
    }
}
    return false;
}
public boolean diagonaleDescendanteGagnantePourCouleur(String couleur){
    int cjg=0;
    for (int i=3; i<6; i++){
        for (int j=0; j<4; j++){
            for (int k=0; k<7; k++){
               if (grille[i-k][j+k].lireCouleurDuJeton()== couleur){
                   cjg +=1;
               }else{
                   cjg=0;
               }
               if (cjg ==4){
                    return true;
            }
               if (i==0 && j==6){
                    break;
                }
        }
            cjg=0;
    }
}
    return false;
}
public boolean partieGagnante(String couleur){
    if (ligneGagnantePourCouleur(couleur)==true){
        return true;
      }
    if (colonneGagnantePourCouleur(couleur)==true){
        return true;
    }
    if (diagonaleMontanteGagnantePourCouleur(couleur)==true){
        return true;
    }
    if (diagonaleDescendanteGagnantePourCouleur(couleur)==true){
        return true;
    }
    return false;
}
public void tasserColonne(int col){
 for (int i=0; i<6; i++){
     if (grille[i][col]==null){
         for (int j=i; j<5; j++){
             grille[i][col]=grille[i+1][col];
         }
         grille[5][col] = null;   
         }
     }
 } 
public boolean colonneRemplie(int col){
    if (presenceJeton(5,col)==true){
        return true;
    }else{
    return false;
    }
}
public boolean presenceTrouNoir(int ligne, int colonne){
    if (grille[ligne][colonne].presenceTrouNoir()==true){
        return true;
    }else{
        return false;
    }
}
public void placerTrouNoir(int lig, int col){
    if (grille[lig][col].presenceTrouNoir()==false){
    grille[lig][col].placerTrouNoir();
}
}
public void supprimerTrouNoir(int lig, int col){
    if (grille[lig][col].presenceTrouNoir()==true){
    grille[lig][col].supprimerTrouNoir();
}
}
public boolean presenceDesintegrateur(int ligne, int colonne){
    if (grille[ligne][colonne].presenceDesintegrateur()==true){
        return true;
    }else{
        return false;
    }
}
public void placerDesintegrateur(int lig, int col){
    if (grille[lig][col].presenceDesintegrateur()==false){
    grille[lig][col].placerDesintegrateur();
}
}
public void supprimerJeton(int lig, int col){
    if (grille[lig][col].presenceJeton()==true){
    grille[lig][col].supprimerJeton();
}
}
public void recupererJeton(int lig, int col){
    if (grille[lig][col].presenceJeton()==true){
    grille[lig][col].recupererJeton();
}
}

    void ajouterJeton(Jeton j) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}



