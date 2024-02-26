package exercice5;

public class Person {

    private String firstName;
    private String lastName;
    private final Date birthDate;

    private Person spouse;
    private Date weddingDate;

    private Person father;
    private Person mother;
    
    private final Gender gender;

    public Person(String firstName, String lastName, Date birthDate, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Person(String firstName, String lastName, Date birthDate, Person father, Person mother, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.father = father;
        this.mother = mother;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (this.gender == Gender.MALE) {
            System.err.println("Male cannot change their last name.");
            System.exit(-1);
        }
        this.lastName = lastName;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Date getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(Date weddingDate) {
        this.weddingDate = weddingDate;
    }

    public void wed(Person otherPerson, Date weddingDate) {
        if (this.equals(otherPerson) == true) {
            System.err.println("You can't marry yourself.");
            System.exit(-1);
        }
        
        if (this.getSpouse() != null) {
            System.err.println("This person has already a spouse.");
            System.exit(0);
        }
        
        if (otherPerson.getSpouse() != null) {
            System.err.println("The other person has already a spouse.");
            System.exit(1);
        }
        if (weddingDate.compareTo(this.birthDate) < 0) {
            System.err.println("The wedding date must be after this person birthdate.");
            System.exit(2);
        }
        if (weddingDate.compareTo(otherPerson.birthDate) < 0) {
            System.err.println("The wedding date must be after this person birthdate.");
            System.exit(2);
        }
        this.setSpouse(otherPerson);
        this.weddingDate = weddingDate;

        otherPerson.setSpouse(this);
        otherPerson.weddingDate = weddingDate;
    }

    public void divorce(Person otherPerson) {
        this.setSpouse(null);
        this.weddingDate = null;
        otherPerson.setSpouse(null);
        otherPerson.weddingDate = null;
    }

    public boolean isSibling(Person sibling) {
        if (this.mother != null && this.mother.equals(sibling.mother)) {
            return true;
        } else if (this.father != null && this.father.equals(sibling.father)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Person <" + getFirstName() + " " + getLastName() + ">";
    }

    public boolean isMarried() {
        return this.getWeddingDate() != null && this.getSpouse() != null;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Jean", "Dupont", new Date(01, 02, 2022), null, null, Gender.MALE);
        Person p2 = new Person("Jeanne", "Martin", new Date(02, 02, 2022), null, null, Gender.FEMALE);
        System.out.println(p1); System.out.println(p2);
        System.out.println(p1.isSibling(p2));
        p1.setLastName("Dumoulin"); p2.setLastName("Noiret");
        System.out.println(p1); System.out.println(p2);
    }  
}
