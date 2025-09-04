public class subclass extends A {

      public subclass(int num, String name) {
            super(num, name);
      }
      public static void main(String[] args) {
            subclass obj = new subclass(45, "Kunal");
            int n = obj.num;
      }
}
