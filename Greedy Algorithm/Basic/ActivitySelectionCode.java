import  java.util.*;
public class ActivitySelectionCode {

    public static int activitySelection(int start[], int end[]) {
        int maxActivity = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        maxActivity = 1;
        ans.add(0);
        int lastEnd = end[0];

        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                maxActivity++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();

        return maxActivity;
    }

    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        //Sorting
        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        System.out.println(activitySelection(start, end));
    }
}
