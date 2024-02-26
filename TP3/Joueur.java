public abstract class Joueur{

    private String nom;
    protected Paquet P;

    public abstract Carte choisirCarte();

    public Joueur(String N){
        this.nom = N;
        this.P = new Paquet();
    }

    public String GetNom(){
        return this.nom;
    }

    public boolean aPerdu(){
        return this.P.estVide();
    }

    public Carte jouer(){
        return choisirCarte();
    }

    public void recupererCarte(Carte carte){
        this.P.ajouter(carte);
    }

    @Override
    public String toString(){
        return this.nom+"\n"+this.P;
    }

}