import java.io.Console;
import java.util.Random;

public class Ordinateur extends Joueur{

    private Random random;

    public Ordinateur(String N){
        super(N);
        this.random = new Random();       
    }

    public Carte choisirCarte(){
        return P.get(random.nextInt(P.taille()));
    }

}
