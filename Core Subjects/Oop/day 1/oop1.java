
public class oop1 {
      public static void main(String[] args) {
            Student[] students = new Student[5];
            Student aniket;
            aniket = new Student();

            // Student aniket = new Student(10, "Albert", 85.4f);
            System.out.println(aniket.marks);
            System.out.println(aniket.name);
            System.out.println(aniket.rno);

            aniket.name = "Aniket Amte";
            aniket.marks = 89.67f;
            aniket.rno = 101;

            System.out.println(aniket.marks);
            System.out.println(aniket.name);
            System.out.println(aniket.rno);

            // Student amte = new Student(17, "Amte", 90.67);

            aniket.greeting();
            aniket.changeName("Newton");
            aniket.greeting();

            Student random = new Student(aniket); //Constructor Overloading
            System.out.println(random.name);
            Student Arpit = new Student(20, "Arpit", 90.67f);
            System.out.println(Arpit.name);

            //Calling a constructor from another constructor
            
            //internally it looks like :=> new Student(20, "Arpit", 90.67f);
            Student random2 = new Student();
            System.out.println(random2.name);

            Student one = new Student();
            Student two = one;
            one.name = "Something went wrong!";
            System.out.println(two.name);
      }
}

// create a class for every single student
class Student {
      int rno;
      String name;
      float marks;

      void greeting() {
            System.out.println("Hello, my name is " + name + " and my roll no is " + rno);
      }

      void changeName(String newName) {
            name = newName;
      }

      Student(Student other) {
            this.rno = other.rno;
            this.name = other.name;
            this.marks = other.marks;
      }

      Student() {
            // this.rno = 90;
            // this.name = "Proton Electron";
            // this.marks = 90.0f;

            //This is how you you call constructor from another constructor

            this(50, "Default Person", 90.0f);
      }

      //Student Arpit = new Student(20, "Arpit", 90.67f);
      //Here, this will be replace with Arpit
      Student(int rno, String name, float marks) {
            this.rno = rno;
            this.name = name;
            this.marks = marks;
      }
}
