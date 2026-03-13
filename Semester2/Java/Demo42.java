import java.util.*;

class Animal {
    private String species;
    protected int age;
    protected float weight;
    String color;

    // Default constructor
    Animal() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Species   : ");
        species = sc.nextLine();

        System.out.print("Enter the Age       : ");
        age = sc.nextInt();

        System.out.print("Enter the Weight    : ");
        weight = sc.nextFloat();

        System.out.print("Enter the Color     : ");
        sc.nextLine();
        color = sc.nextLine();
    }

    // Parameterized constructor
    Animal(int a, String s, float weight, String color) {
        species = s;
        age = a;
        this.weight = weight;
        this.color = color;
    }

    // Copy constructor
    Animal(Animal other) {
        this.species = other.species;
        this.age = other.age;
        this.weight = other.weight;
        this.color = other.color;
    }

    void display() {
        System.out.println("Species : " + species);
        System.out.println("Age     : " + age);
        System.out.println("Weight  : " + weight);
        System.out.println("Color   : " + color);
    }
}

class Dog extends Animal {

    String breed;
    String name;
    String owner;

    Dog() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Breed  : ");
        breed = sc.nextLine();

        System.out.print("Enter the Name   : ");
        name = sc.nextLine();

        System.out.print("Enter the Owner  : ");
        owner = sc.nextLine();
    }

    Dog(int a, String s, float weight, String color) {
        super(a, s, weight, color);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Breed  : ");
        breed = sc.nextLine();

        System.out.print("Enter the Name   : ");
        name = sc.nextLine();

        System.out.print("Enter the Owner  : ");
        owner = sc.nextLine();
    }

    void display() {
        System.out.println("\nDetails of DOG:");
        super.display();
        System.out.println("Breed   : " + breed);
        System.out.println("Owner   : " + owner);
        System.out.println("Name    : " + name);
    }
}

class Cat extends Animal {

    String name;
    String eyeColor;
    float tailLength;

    Cat() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Name        : ");
        name = sc.nextLine();

        System.out.print("Enter the Eye Color   : ");
        eyeColor = sc.nextLine();

        System.out.print("Enter the Tail Length : ");
        tailLength = sc.nextFloat();
    }

    Cat(int a, String s, float weight, String color) {
        super(a, s, weight, color);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Name        : ");
        name = sc.nextLine();

        System.out.print("Enter the Eye Color   : ");
        eyeColor = sc.nextLine();

        System.out.print("Enter the Tail Length : ");
        tailLength = sc.nextFloat();
    }

    void display() {
        System.out.println("\nDetails of CAT:");
        super.display();
        System.out.println("Name        : " + name);
        System.out.println("Eye Color   : " + eyeColor);
        System.out.println("Tail Length : " + tailLength);
    }
}

public class Demo42 {

    public static void main(String[] arg) {

        String species;
        int age;
        float weight;
        String color;

        Scanner sc = new Scanner(System.in);

        // Dynamic Method Dispatch
        Animal ob;

        System.out.println("\nEnter the Details of DOG:");
        ob = new Dog();
        ob.display();

        System.out.println("\nEnter the Details of CAT:");
        ob = new Cat();
        ob.display();

        // Parameterized constructor example
        System.out.println("\nEnter Animal details for parameterized constructor");

        System.out.print("Enter the Species   : ");
        species = sc.nextLine();

        System.out.print("Enter the Age       : ");
        age = sc.nextInt();

        System.out.print("Enter the Weight    : ");
        weight = sc.nextFloat();

        System.out.print("Enter the Color     : ");
        sc.nextLine();
        color = sc.nextLine();

        Dog ob1 = new Dog(age, species, weight, color);
        ob1.display();
    }
}