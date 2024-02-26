import java.io.Console;

public class Humain extends Joueur{

    private Console console;

    public Humain(Console C,String N){
        super(N);
        this.console = C;
    }

    public Carte choisirCarte(){
        boolean boucle = true;
        int nb=0,id=0;
        while(boucle){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if(nb > 0){
                System.out.println("Attention écrire un nombre entre 1 et "+this.P.taille()+".\n");
            }
            System.out.println(this.P+"\n");
            String N = this.console.readLine("Quel indice de carte vous choisissez (1 à "+this.P.taille()+") ?\n");
            id = Integer.parseInt(N);
            if(id <= this.P.taille() && id > 0){
                boucle = false;
            }
            nb++;
        }
        return this.P.get(id-1);
    }
    
}
