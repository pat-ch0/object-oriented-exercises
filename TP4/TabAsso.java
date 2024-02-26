import java.util.HashMap;
public class TabAsso {
    private HashMap<String, Liste> m;
    private HashMap<Integer, Integer> n;

    public TabAsso(){
        this.m = new HashMap<String, Liste>();
        this.n = new HashMap<Integer, Integer>();
    }
    
    public void put(String key, Liste v){
        this.m.put(key, v);
    }
    //Q2 : OUI
    public void put(Integer key, Integer i){
        this.n.put(key, i);
    }

    public Liste get(String key){
        return this.m.get(key);
    }
    public int get(Object key){
        return this.n.get(key);
    }
    //Q2 : OUI



    public static void main(String[] args){
        int i = 1;
        Integer j = 2;
        TabAsso tab = new TabAsso();
        tab.put(j, i);
        Integer k = 3;
        int l = 6;
        tab.put(k, l);
        System.out.println(tab.n);
        //Q2 : On peut ajouter un int dans notre tableau associative même lorsque que le type attendu est un Integer, je ne peux donc pas faire la différence entre un int et un Integer.

    }
}
