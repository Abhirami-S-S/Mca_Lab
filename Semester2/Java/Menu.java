import java.util.*;

interface Compute {
    double area();
    double perimeter();
}

class Rectangle implements Compute {
    double length, width;

    Rectangle(double l, double w) {
        length = l;
        width = w;
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }

    void display() {
        System.out.println("Area of Rectangle     : " + area());
        System.out.println("Perimeter of Rectangle: " + perimeter());
    }
}

class Circle implements Compute {
    double radius;

    Circle(double r) {
        radius = r;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    void display() {
        System.out.println("Area of Circle     : " + area());
        System.out.println("Perimeter of Circle: " + perimeter());
    }
}

public class Menu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int ch;

        while (true) {
            System.out.println("\nCompute Area and Perimeter");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter the radius: ");
                    double r = sc.nextDouble();
                    Circle c = new Circle(r);
                    c.display();
                    break;

                case 2:
                    System.out.print("Enter the length: ");
                    double l = sc.nextDouble();
                    System.out.print("Enter the width: ");
                    double w = sc.nextDouble();
                    Rectangle rect = new Rectangle(l, w);
                    rect.display();
                    break;

                case 3:
                    System.out.println("Program exited.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}