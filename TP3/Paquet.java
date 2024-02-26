import java.util.*;

public class Paquet {
    private List <Carte> P;

    public Paquet(){
        this.P = new ArrayList<Carte>();
    }

    public void ajouter(Carte c){
        this.P.add(c);
    }

    public Carte retirer(int i){
        Carte C = this.P.get(i);
        this.P.remove(i);
        return C; 
    }

    public Carte Retirer(Carte C){
        for(int i=0;i<this.P.size();i++){
            if(this.P.get(i) == C){
                return this.retirer(i);
            }
        }
        return C;
    }

    public Carte get(int i){
        return this.P.get(i);
    }

    public int taille(){
        return this.P.size();
    }

    public boolean estVide(){
        return this.P.size() == 0;
    }

    @Override
    public String toString(){
        Collections.sort(this.P, Collections.reverseOrder());
        String P="";
        for(int i=0; i<this.P.size();i++){
            P += (i+1)+": "+this.P.get(i);
            if(i < this.P.size()-1){
                P += ", ";
            }
        }
        return "Paquet:\n" + P;
    }

    public void melanger(){
        Random rand = new Random();
        for(int i=0;i<2*this.P.size();i++){
            Collections.swap(this.P, rand.nextInt(this.P.size()), rand.nextInt(this.P.size()));
        }
    }
}