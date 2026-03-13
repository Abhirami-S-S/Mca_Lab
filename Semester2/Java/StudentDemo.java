import java.util.Scanner;
class Student{
    int rollno;
    String name;
    int mark;
    static int count=0;
    public Student(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Roll No  :");
        rollno=sc.nextInt();
        System.out.print("Enter the Name :");
        String m=sc.nextLine();
        name=sc.nextLine();
        System.out.print("Enter the Mark :");
        mark=sc.nextInt();
        count++;
    }
    public Student(int rollno,String name,int mark){
        this.rollno=rollno;
        this.name=name;
        this.mark=mark;
    }
    public Student(Student other){
        this.rollno=other.rollno;
        this.name=other.name;
        this.mark=other.mark;
    }
    void show(){
        System.out.println("Roll No : "+rollno);
        System.out.println("Name    : "+name);
        System.out.println("Mark    : "+mark);
    }
    static void showCount(){
        System.out.println("Count   : "+count);
    }
    void compare(Student other){
        if(this.mark>other.mark){
            System.out.println(this.name + " get greater mark than "+other.name+".");
        }else if(this.mark<other.mark){
            System.out.println(other.name + " get greater mark than "+this.name+".");
        }else{
            System.out.println("Both have same mark.");
        }
        showCount();
    }
}
class StudentDemo{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of Students :");
        int n=sc.nextInt();
        Student s[]=new Student[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter details of Student"+(i+1)+" :");
            s[i]=new Student();
        }
        sort(s,n);
        s[0].compare(s[1]);
    }
    static void sort(Student[] s, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s[i].mark > s[j].mark) {
                    Student temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }
        System.out.println("Rank list:");
        for(int i=0;i<n;i++){
            System.out.println("Rank "+ (i+1)+" : ");
            s[i].show();
        }
    }
}
