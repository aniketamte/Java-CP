class Leetcode345 {
    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                || ch == 'O' || ch == 'U';
    }

    public static String reverseVowels(String s) {
        char arr[] = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (!isVowel(arr[i])) {
                i++;
            } else if (!isVowel(arr[j])) {
                j--;
            } else {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
    public static void main(String[] args) {
      String s = "IceCreAm";
      System.out.println(reverseVowels(s));
    }
}