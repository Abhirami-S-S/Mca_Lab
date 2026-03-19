/*Create a Class Rectangle(Lengtgh and  width).Defines interfaces Measurable with a method declaration to find the
 volume of object and Printable with a method declaration to display particulars of the object.Create a class
 Cuboid(height) that inherits from Rectangle and implement interface*/
interface Measurable{
    int volume();
}
interface Printable{
    void show();
}
class Rectangle{
    int length,width;
    Rectangle(int l,int w){
        length=l;
        width=w;
    }
}
class Cuboid extends Rectangle implements Measurable,Printable{
    int height;
    Cuboid(int l,int w,int h){
        super(l,w);
        height=h;
    }
    public int volume(){
        return (length*width*height);
    }
    public void show(){
        System.out.println("Volume : "+ volume());
    }
}
public class CuboidVolumeDemo {
    public static void main(String[] args){
        Cuboid c = new Cuboid(4,5,6);
        c.show();
    }
}
