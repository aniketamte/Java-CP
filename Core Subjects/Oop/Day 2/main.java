public class main {
      public static void main(String[] args) {
            human aniket = new human(25, "Aniket", 50000, false);

            human amte = new human(25, "Amte", 56000, false);

            System.out.println("Name: " + aniket.name);
            System.out.println("Age: " + aniket.age);
            System.out.println("Salary: " + aniket.salary);
            System.out.println("Married: " + aniket.isMarried);
            
            System.out.println("Population: " + aniket.population);
            System.out.println("Population: " + amte.population);
      }
}