public class WrapperExample {
      public static void main(String[] args) {
            Integer a = 10;
            Integer b = 20;
            Integer num = 07;

            swap(a, b);
            System.out.println(a + " " + b);
            A aniket = new A("Aniket Amte");
            aniket.name = "Other name";

            //When a non primitive is final, it can't be reassigned
            // aniket = new A("New Object");
      }

      static void swap(Integer a, Integer b) {
            Integer temp = a;
            a = b;
            b = temp;
      }
}

class A {
      final int num = 10;
      String name;

      public A(String name){
            this.name = name;
      }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed!");
    }
}
