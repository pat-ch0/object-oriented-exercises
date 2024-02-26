import java.lang.Object;

public class Mot{
    private String mot;

    public Mot(){
        this.mot=System.console().readLine("Mot : ");
    }

    public String GetMot(){
        return this.mot;
    }

    @Override
    public String toString() {
        return String.format("%s", GetMot());
    }

    public void afficheVoyelles(){
        int taille=this.mot.length();
        String finalWord="";
        for(int i=0; i<taille; i++){
            if(this.mot.charAt(i)=='a' || this.mot.charAt(i)=='e' || this.mot.charAt(i)=='i' || this.mot.charAt(i)=='o' || this.mot.charAt(i)=='u' || this.mot.charAt(i)=='y'){
               finalWord+=this.mot.charAt(i); 
            }
        }
        System.out.println(finalWord);
    }

    public boolean estPalindrome(){
        int taille=this.mot.length();
        for(int i = 0; i<taille; i++){
            if(this.mot.charAt(i)!=this.mot.charAt(taille-i-1)){
                return false;
            }
        }
        return true;
    }

    public boolean estContenu(Mot word){
        int taille=word.GetMot().length();
        int taille2=this.mot.length();
        for(int i=0; i<taille; i++){
            boolean stop=true;
            if(word.GetMot().charAt(i) == this.mot.charAt(0)){
                for(int j=i+1, x=1; j<taille2; j++, x++){
                    if (word.GetMot().charAt(j) != this.mot.charAt(x)){
                        stop=false;
                        break;
                    }
                }
                if(stop==true){
                    return true;
                }
            }
        }
        return false;
        /* if (word.contains(this.mot)){
            return true;
        } */
    }

    public String motTrier(){
        String s = "";
        if(this.mot.length() > 0){
            s += this.mot.charAt(0);
        }
        for(int i=1; i<this.mot.length(); i++){
            char c = this.mot.charAt(i);
            String prec = "";
            boolean placer = false;
            for(int j=0; j<s.length(); j++){
                char cs = s.charAt(j);
                if((int)cs < (int) c){
                    prec = prec + cs;
                } else if(!placer){
                    prec = prec + c + cs;
                    placer = true;
                } else{
                    prec = prec + cs;
                }
            }
            if (!placer){
                s = prec+c;
            } else{
                s = prec;
            }
        }
        return s;
    }

    public static void main(String[] args){
        Mot canner= new Mot();
        Mot test = new Mot();
        canner.afficheVoyelles();
        System.out.printf("Palindrome ? %b%n", canner.estPalindrome());
        System.out.printf("Le mot propose contient le mot courant ? %b%n", canner.estContenu(test));
        System.out.printf("Mot trie : %s%n", canner.motTrier());
    }
}