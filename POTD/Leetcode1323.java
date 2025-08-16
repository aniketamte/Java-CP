public class Leetcode1323 {
    public static int maximum69Number(int num) {
        int placeValue = 0;
        int placeValueSix = -1;
        int temp = num;

        while (temp > 0) {
            int remain = temp % 10;
            if (remain == 6) {
                placeValueSix = placeValue;
            }
            temp = temp / 10;
            placeValue++;
        }
        if (placeValueSix == -1) {
            return num;
        }
        return num + 3 * (int) Math.pow(10, placeValueSix);
    }

    public static void main(String[] args) {
        int num = 9669;
        System.out.println(maximum69Number(num));
    }
}
