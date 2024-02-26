public class Matrice{
    private int tab[][];
    private int lign;
    private int col;
    boolean triang;

    public Matrice(int l, int c){
        if((l>0)&&(c>0)){
            this.tab = new int[l][c];
            for(int i = 0; i < l; i++){
                for(int j = 0; j < c; j++){
                    this.tab[i][j] = 1;
                }
            }
            this.col = c;
            this.lign = l;
            this.triang = false;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public Matrice ajouter(Matrice autreMatrice){
        if((this.lign != autreMatrice.lign) || (this.col != autreMatrice.col)){
            throw new IllegalArgumentException();
        }
        else{
            Matrice sum = new Matrice(this.lign, this.col);
            for(int i = 0; i < this.lign; i++){
                for(int j = 0; j < this.col; j++){
                    sum.tab[i][j] = this.tab[i][j] + autreMatrice.tab[i][j];
                }
            }
            return sum;
        }
    }

    public Matrice triang(int l, int c){
        int T[][] = new int[l][];
        for(int i = 0; i<l; i++){
            for(int j = 0; j <= i; j++){
                T[i] = new int[j+1];
            }
        }
        for(int i = 0; i < l; i++){
            for(int j = 0; j <= i; j++){
                T[i][j] = 1;
            }
        }
        Matrice hey = new Matrice(l, c);
        hey.tab = T;
        hey.triang = true;
        return hey;
    }

    @Override
    public String toString(){
        String affiche = "";
        if(this.triang){
            for(int i = 0; i<this.lign; i++){
                for(int j = 0; j <= i; j++){
                    affiche += String.valueOf(this.tab[i][j]);
                    affiche += " ";
                }
                affiche += "\n";
            }
            return affiche;
        }
        else {
            for (int i = 0; i < this.lign; i++){
                for (int j = 0; j < this.col; j++){
                    affiche += String.valueOf(this.tab[i][j]);
                    affiche += " ";
                }
                affiche += "\n";
            }
            return affiche;
        }
    }

    public static void main(String[] args){
        Matrice test = new Matrice(3,3);
        test = test.triang(test.lign, test.col);
        System.out.println(test);
        System.out.println(test.tab[2][2]);
        System.out.println(test.tab[1][2]); 
    }

}