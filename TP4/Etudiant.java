public class Etudiant {
    private int num;
    private int note;

    public Etudiant(int nu, int not){
        this.num = nu;
        this.note = not;
    }

    public int getNote(){
        return this.note;
    }

    public int getNum(){
        return this.num;
    }

    @Override
    public String toString(){
        return String.format("num: " + this.num + " | note: " + this.note + " ");
    }
}
