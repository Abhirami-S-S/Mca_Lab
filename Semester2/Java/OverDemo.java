class Geometry{
    void area(int a){
        System.out.println("Area of Square :"+(a*a));
    }
    void area(int a,int b){
        System.out.println("Area of Rectangle :"+(a*b));
    }
    double area(double a){
        return (3.14*a*a);
    }
}
public class OverDemo {
    public  static void main(String[] args){
        Geometry g1=new Geometry();
        g1.area(5);
        g1.area(5,6);
        System.out.println("Area of Circle :"+g1.area(5.4));
    }
}
