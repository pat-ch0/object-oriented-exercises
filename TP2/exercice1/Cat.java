public class Cat extends Animal{
    public Cat(String n){
        super(n);
      }
  
  
    @Override
    public String toString() {
        return "Cat [name=" + name + "]";
    }

    public void meow(){
        System.out.println("Meow");
    }
}
