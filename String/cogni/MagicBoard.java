import java.util.Arrays;

public class MagicBoard{
      static void displayAsciiMapping(int[] numbers){
            for(int n : numbers){
                  char ch = (char) n;
                  System.out.println(ch + " - " + n);
            }
      }
      public static void main(String[] args) {
            int numbers[] = {65, 67, 68, 69};
            displayAsciiMapping(numbers);
      }
}