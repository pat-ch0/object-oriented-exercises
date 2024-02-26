import java.util.HashMap;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
public class Comp {
    HashMap<String, Etudiant> map;
    ArrayList<Etudiant> liste;
    Etudiant[][] tab;
    int l;

    public Comp(int taille){
        this.map = new HashMap<String, Etudiant>();
        this.liste = new ArrayList<Etudiant>();
        this.tab = new Etudiant[taille][100];
        this.l=0;
    }

    public void insertTab(int n){
        Random rdm = new Random();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 100; j++){
                this.tab[i][j] = new Etudiant(0, rdm.nextInt(21));
            }
        }
    }

    public float MoyTab(int n){
        float sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 100; j++){
                sum += this.tab[i][j].getNote();
            }
        }
        return sum/(n*100); 
    }

    public boolean searchTab(int n, Etudiant e){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 100; j++){
                if(this.tab[i][j] == e){
                    return true;
                }
            }
        }
        return false;
    }

    public void insertList(){
        Random rdm = new Random();
        for(int i = 0; i < 100; i++){
            this.liste.add(new Etudiant(0, rdm.nextInt(21)));
        }
    }

    public float moyList(){
        float sum = 0;
        for (int i = 0; i < this.liste.size(); i++){
            sum += this.liste.get(i).getNote();
        }
        return sum/this.liste.size();
    }

    public boolean searchList(Etudiant e){
        return this.liste.contains(e);
    }

    public void insertMap(){
        Random rdm = new Random();
        for(int i = 0; i < 100; i++){
            this.map.put(String.format("%d", this.l+i), new Etudiant(0, rdm.nextInt(21)));
        }
        this.l += 100;
    }

    public float moyMap(){
        float sum = 0;
        for (int i = 0; i < this.map.size(); i++){
            sum += this.map.get(String.valueOf(i)).getNote();
        }
        return sum/this.map.size();
    }

    public boolean searchMap(Etudiant e){
        return this.map.containsValue(e);
    }

    public static void main(String[] args){
        int n = 100000; //Nombre d'insertion de 100 étudiants
        Comp c = new Comp(n);
        //Temps pour un tableau
        LocalTime t1 = java.time.LocalTime.now();
        System.out.println("DEBUT DE L'EXECUTION  INSERTION [TAB]: " + t1);
        c.insertTab(n);
        LocalTime t2 = java.time.LocalTime.now();
        System.out.println("FIN DE L'EXECUTION INSERTION [TAB]: " + t2);
        System.out.println("TEMPS TAB : " + (t2.toSecondOfDay() - t1.toSecondOfDay()) + "s");


        System.out.println("----------------------------------------------------------");



        //Temps pour une liste
        t1 = java.time.LocalTime.now();
        System.out.println("DEBUT DE L'EXECUTION  INSERTION [LISTE]: " + t1);
        for(int i = 0; i < n; i++){
            c.insertList();
        }
        t2 = java.time.LocalTime.now();
        System.out.println("FIN DE L'EXECUTION INSERTION [LISTE]: " + t2);
        System.out.println("TEMPS LISTE : " + (t2.toSecondOfDay() - t1.toSecondOfDay()) + "s");


        System.out.println("----------------------------------------------------------");



        //Temps pour une hashmap
        t1 = java.time.LocalTime.now();
        System.out.println("DEBUT DE L'EXECUTION INSERTION [HASHMAP]: " + t1);
        for(long i = 0; i < n; i++){
            c.insertMap();
        }
        t2 = java.time.LocalTime.now();
        System.out.println("FIN DE L'EXECUTION INSERTION [HASHMAP]: " + t2);
        System.out.println("TEMPS HASHMAP : " + (t2.toSecondOfDay() - t1.toSecondOfDay()) + "s");



        System.out.println("----------------------------------------------------------");



        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        t1 = java.time.LocalTime.now();
        System.out.println("DEBUT DE L'EXECUTION  MOYENNE [TAB]: " + t1);
        System.out.println("MOYENNE TAB : " + c.MoyTab(n));
        t2 = java.time.LocalTime.now();
        System.out.println("FIN DE L'EXECUTION MOYENNE [TAB]: " + t2);
        System.out.println("TEMPS TAB : " + (t2.toSecondOfDay() - t1.toSecondOfDay()) + "s");



        System.out.println("----------------------------------------------------------");



        t1 = java.time.LocalTime.now();
        System.out.println("DEBUT DE L'EXECUTION  MOYENNE [LISTE]: " + t1);
        System.out.println("MOYENNE LISTE : " + c.moyList());
        t2 = java.time.LocalTime.now();
        System.out.println("FIN DE L'EXECUTION  MOYENNE [LISTE]: " + t2);
        System.out.println("TEMPS LISTE : " + (t2.toSecondOfDay() - t1.toSecondOfDay()) + "s");



        System.out.println("----------------------------------------------------------");




        t1 = java.time.LocalTime.now();
        System.out.println("DEBUT DE L'EXECUTION  MOYENNE [HASHMAP]: " + t1);
        System.out.println("MOYENNE LISTE : " + c.moyMap());
        t2 = java.time.LocalTime.now();
        System.out.println("FIN DE L'EXECUTION  MOYENNE [HASHMAP]: " + java.time.LocalTime.now());
        System.out.println("TEMPS HASHMAP : " + (t2.toSecondOfDay() - t1.toSecondOfDay()) + "s");



        ////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("----------------------------------------------------------");

        t1 = java.time.LocalTime.now();
        System.out.println("DEBUT DE L'EXECUTION  CHERCHE [TAB]: " + t1);
        System.out.println("RECHERCHE TAB : " + c.searchTab(n, new Etudiant(-1, -1)));
        t2 = java.time.LocalTime.now();
        System.out.println("FIN DE L'EXECUTION  CHERCHE [TAB]: " + t2);
        System.out.println("TEMPS TAB : " + (t2.toSecondOfDay() - t1.toSecondOfDay()) + "s");
        System.out.println("----------------------------------------------------------");



        t1 = java.time.LocalTime.now();
        System.out.println("DEBUT DE L'EXECUTION  CHERCHE [LISTE]: " + t1);
        System.out.println("RECHERCHE LISTE : " + c.searchList(new Etudiant(-1, -1)));
        t2 = java.time.LocalTime.now();
        System.out.println("FIN DE L'EXECUTION  CHERCHE [LISTE]: " + t2);
        System.out.println("TEMPS LISTE : " + (t2.toSecondOfDay() - t1.toSecondOfDay()) + "s");


        System.out.println("----------------------------------------------------------");


        t1 = java.time.LocalTime.now();
        System.out.println("DEBUT DE L'EXECUTION  CHERCHE [HASHMAP]: " + t1);
        System.out.println("RECHERCHE LISTE : " + c.searchMap(new Etudiant(-1, -1)));
        t2 = java.time.LocalTime.now();
        System.out.println("FIN DE L'EXECUTION  CHERCHE [HASHMAP]: " + t2);
        System.out.println("TEMPS HASHMAP : " + (t2.toSecondOfDay() - t1.toSecondOfDay()) + "s");
    }

}
