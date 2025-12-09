public class encapsulation {
      public static void main(String[] args) {
            student s = new student();
            s.setName("Aniket Amte");
            s.setAge(-1);
            
            System.out.println("Name: " + s.getName());
            System.out.println("Age: " + s.getAge());
      }
}
class student{
      private String name;
      private int age;

      public void setName(String n){
            name = n;
      }

      public String getName(){
            return name;
      }

      public void setAge(int a){
            if(a > 0){
                  age = a;
            } else{
                  System.out.println("Age must be positive.");
            }
      }

      public int getAge(){
            return age;
      }
}
