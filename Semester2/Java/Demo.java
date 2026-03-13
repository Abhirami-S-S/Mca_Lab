// Functional Interface
@FunctionalInterface
interface Dim {
    double area(double x);
}

public class Demo {
    public static void main(String[] args) {

        // Lambda to find area of a Square
        Dim square = (a) -> a * a;

        // Lambda to find surface area of a Cube
        Dim cube = (a) -> 6 * a * a;

        // Lambda to find area of a Circle
        Dim circle = (r) -> 3.14 * r * r;

        // Lambda to find surface area of a Sphere
        Dim sphere = (r) -> 4 * 3.14 * r * r;

        // Display results
        System.out.println("Area of Square (side = 5)      : " + square.area(5));
        System.out.println("Surface Area of Cube (side=5) : " + cube.area(5));
        System.out.println("Area of Circle (radius = 4)   : " + circle.area(4));
        System.out.println("Surface Area of Sphere (r=4)  : " + sphere.area(4));
    }
}
