public abstract class Parent {
    int age;

    final int VALUE;
    public Parent(int age) {
        this.age = age;
        VALUE = 6574;
    }

    static void hello(){
      System.out.println("Hello Everyone!");
    }

    void normal(){
      System.out.println("This is normal method");
    }

    abstract void career();
    abstract void partner();
}
