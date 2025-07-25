class Student {
      private int age; // 👈 private variable

      // public method to access private variable
      public void setAge(int a) {
            if (a >= 0) {
                  age = a;
            }
      }

      public int getAge() {
            return age;
      }
}

public class Main {
      public static void main(String[] args) {
            Student s = new Student();
            s.setAge(20);
            System.out.println("Age: " + s.getAge()); // ✅ Age: 20
            // s.age = 25; ❌ Error: age has private access
      }
}