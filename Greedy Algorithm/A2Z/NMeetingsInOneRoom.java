import java.util.*;
public class NMeetingsInOneRoom {
      static class Meeting {
            int start;
            int end;
            int position;

            Meeting(int start, int end, int position) {
                  this.start = start;
                  this.end = end;
                  this.position = position;
            }
      }
      public static int maxMeetings(int start[], int end[], int n){
            Meeting[] meetings = new Meeting[n];
            for (int i = 0; i < n; i++) {
                  meetings[i] = new Meeting(start[i], end[i], i);
            }
            // Sort meetings based on end time
            Arrays.sort(meetings, (m1, m2) -> m1.end - m2.end);
            ArrayList<Integer> result = new ArrayList<>();
            int lastEndTime = -1;
            for (Meeting meeting : meetings) {
                  if (meeting.start > lastEndTime) {
                        result.add(meeting.position);
                        lastEndTime = meeting.end;
                  }
            }
            return result.size();
      }
      public static void main(String[] args) {
            int start[] = {1, 3, 0, 5, 8, 5};
            int end[] = {2, 4, 6, 7, 9, 9};
            int n = start.length;
            System.out.println("Maximum number of meetings: " + maxMeetings(start, end, n));
      }
}
