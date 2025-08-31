package ComparingObjects;

public class Main {

    public static void main(String[] args) {
        Students Aniket = new Students(17, 90.6f);
        Students Amte = new Students(10, 90.7f);

        if (Aniket.compareTo(Amte) > 0) {
            System.out.println("Aniket has more marks!");
        } else if (Aniket.compareTo(Amte) < 0) {
            System.out.println("Amte has more marks!");
        } else {
            System.out.println("Both have equal marks!");
        }
    }
}
