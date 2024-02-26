public class Jeu {

    private Ordinateur J1;
    private Humain J2;
    private Paquet P;

    private Jeu(){
        this.J2 = new Humain(System.console(),System.console().readLine("Quel est votre Nom ?\n"));
        this.J1 = new Ordinateur(System.console().readLine("Quel est le nom de votre adversaire ?\n"));
        this.P = new Paquet();
    }

    private void jouerCoup(){
        Carte J1 = this.J1.choisirCarte();
        Carte J2 = this.J2.choisirCarte();
        if(J1.compareTo(J2) == 1){
            this.J1.recupererCarte(J2);
            this.J2.P.Retirer(J2);
            //System.out.println("+1 pour J1, taille Ordi:"+this.J1.P.taille()+" taille Joueur:"+this.J2.P.taille());
        }else{
            this.J2.recupererCarte(J1);
            this.J1.P.Retirer(J1);
            //System.out.println("+1 Pour J2, taille Ordi:"+this.J1.P.taille()+" taille Joueur:"+this.J2.P.taille());
        }
    }

    private void creerNouveauPaquet(){
        for(int i=2;i<15;i++){
            for (int j=0;j<4;j++){
                this.P.ajouter(new Carte(i,Couleur.values()[j]));
            }
        }
        this.P.melanger();
    }

    private void distribuerPaquet(){
        int taille=this.P.taille();
        for(int i=0;i<taille;i++){
            if(i%2 == 0){
                this.J1.recupererCarte(this.P.get(0));
            }else{
                this.J2.recupererCarte(this.P.get(0));
            }
            this.P.retirer(0);
        }
    }

    private void jouerPartie(){
        creerNouveauPaquet();
        distribuerPaquet();
        while(!this.J1.aPerdu() && !this.J2.aPerdu()){
            jouerCoup();
        }
        if(this.J1.aPerdu()){
            System.out.println(this.J2.GetNom()+" a gané !!!");
        }else{
            System.out.println(this.J1.GetNom()+" a gané !!!");
        }
    }

    public static void main(String[] args){
        Jeu Test = new Jeu();
        //System.out.println(Test.P);
        Test.jouerPartie();
    }
}
