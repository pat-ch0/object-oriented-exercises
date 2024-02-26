class Dog extends Animal{
    public Dog(String n){
        super(n);
      }
  
      @Override
      public String toString() {
          return "Dog [name=" + name + "]";
    } 
    
    public void woof(){
        System.out.println("Woof");
    }
}