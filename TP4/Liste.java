import java.util.ArrayList;
public class Liste {

    ArrayList<String> liste;
    public Liste(){
        this.liste = new ArrayList<String>();
    }

    public void ajouter(String s){
        this.liste.add(s);
    }

    public void supprimer(String s){
        this.liste.remove(s);
    }

    public int taille(){
        return this.liste.size();
    }

    public boolean contient(String s){
        return this.liste.contains(s);
    }

    public void reverse(){
        Liste nouv = new Liste();
        for(int i = this.taille()-1; i >= 0; i--){
            nouv.ajouter(this.liste.get(i));
        }
        this.liste = nouv.liste;
    }

    @Override
    public String toString(){
        String a = "";
        for(int i = 0; i < this.liste.size(); i++){
            a += this.liste.get(i);
            a += "|";
        }
        return a;
    }

    public static void main(String[] args){
        Liste l = new Liste();
        l.ajouter("1");
        l.ajouter("2");
        l.ajouter("3");
        System.out.println(l);
        l.reverse();
        System.out.println(l);
        // ArrayList ne réalise pas de liste d'entiers, il faut donc faire une liste d'un autre type, puis faire une conversion en entier afin de récupérer les éléments.
    }

}
