
public class Pattern {

    public static void main(String[] args) {
        pattern1(4);
        System.out.println("---------------Pattern End-------------");
        pattern2(4);
        System.out.println("---------------Pattern End-------------");
        pattern3(4);
        System.out.println("---------------Pattern End-------------");
        pattern4(4);
        System.out.println("---------------Pattern End-------------");
        pattern5(4);
        System.out.println("---------------Pattern End-------------");
        pattern6(5);
        System.out.println("---------------Pattern End-------------");
    }

    static void pattern1(int n) {
        for (int row = 1; row <= n; row++) { //row
            for (int col = 1; col <= row; col++) {
                System.out.print("x ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print("x ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print("x ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColInRow = row > n ? 2 * n - row: row;
            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("x ");
            }
            System.out.println();
        }
    }

    static void pattern6(int n){
      
    }
    
}
