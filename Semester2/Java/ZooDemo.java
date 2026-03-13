class Zoo {
    String name = "Zoo World";
    String[] region = new String[3];

    Enclosure e1;
    Enclosure e2;
    Enclosure e3;
    Zoo() {
        region[0] = "Area-1";
        region[1] = "Area-2";
        region[2] = "Area-3";

        e1 = new Enclosure("Grassland", "Outdoor",
                new String[]{"Horse"});
        e2 = new Enclosure("Fly Zone", "Outdoor",
                new String[]{"Peacock"});
        e3 = new Enclosure("Aquatic", "Indoor",
                new String[]{"GoldFish"});
    }

    void display() {
        System.out.println("Name : " + name);

        System.out.println(region[0]);
        e1.display();

        System.out.println(region[1]);
        e2.display();

        System.out.println(region[2]);
        e3.display();

        System.out.println("Contact:");
        Contact.display();
    }

    class Enclosure {
        String name;
        String type;
        String[] animals;

        Enclosure(String n, String t, String[] a) {
            name = n;
            type = t;
            animals = a;
        }

        void display() {
            System.out.println("Enclosure Name : " + name);
            System.out.println("Type           : " + type);
            System.out.print("Animals        : ");
            for (String a : animals) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    static class Contact {
        static String address = "Green Valley City";
        static String ph_no = "9876543210";

        static void display() {
            System.out.println("Address  : " + address);
            System.out.println("Phone No : " + ph_no);
        }
    }
}

public class ZooDemo {
    public static void main(String[] args) {
        Zoo z = new Zoo();
        z.display();
    }
}
