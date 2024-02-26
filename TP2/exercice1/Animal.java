abstract class Animal {
    protected final String name;

    public Animal(String n){
        this.name=n;
    }

    public String getName() {
        return name;
    }
    
    public static void main(String[] args){
        Dog medor = new Dog("Medor");
        Animal felix = new Cat ("Felix");
        System.out.println(medor);
        System.out.println(felix);
        medor.woof();
        felix.meow();  //existe pas non plus pas la méthode meow
        //((Dog)medor).woof();
        //((Cat)felix).meow(); pour pouvoir récuperer la méthode (quel type on veut avoir) force a être un chat
        //medor.meow(); fonction meow n'existe pas pour medor
    }
}