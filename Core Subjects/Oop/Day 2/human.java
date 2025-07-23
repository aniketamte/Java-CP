public class human{
      int age;
      String name;
      int salary;
      boolean isMarried;
      static long population;

      public human(int age, String name, int salary, boolean isMarried) {
          this.age = age;
          this.name = name;
          this.salary = salary;
          this.isMarried = isMarried;
          human.population += 1; // Increment population for each new human instance
      }
}