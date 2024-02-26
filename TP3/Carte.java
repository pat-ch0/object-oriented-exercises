public class Carte implements Comparable<Carte>{
    private final int Valeur;
    private Couleur couleur;

    public Carte(int val,Couleur Coul){
        this.couleur = Coul;
        if (val < 15 && val > 1){
            this.Valeur = val;
        }else{
            throw new IllegalArgumentException("Valeur de la carte invalide");
        }
    }


    public int getValeur() {
        return Valeur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public int getInt(){
        if(this.couleur == Couleur.Pique){
            return 0;
        }else if(this.couleur == Couleur.Coeur){
            return 1;
        }else if(this.couleur == Couleur.Carreau){
            return 2;
        }else{
            return 3;
        }
    }


    @Override
    public String toString(){
        String s="";
        if (this.Valeur == 11){
            s = "Valet";
        }
        else if(this.Valeur == 12){
            s = "Reine";
        }
        else if(this.Valeur == 13){
            s = "Roi";
        }else if(this.Valeur == 14){
            s = "As";
        }else{
            s += this.Valeur;
        }
        return String.format("%s de %s",s,this.couleur);
    }

    @Override
    public int compareTo(Carte Other){
        if(this.Valeur == Other.getValeur()){
            return Integer.compare(getInt(), Other.getInt());
        }else{
            return Integer.compare(this.Valeur, Other.getValeur());
        }
    }
}