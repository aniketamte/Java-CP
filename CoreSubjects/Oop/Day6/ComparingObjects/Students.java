package ComparingObjects;

public class Students implements Comparable<Students> {

    int rollno;
    float marks;

    public Students(int rollno, float marks) {
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public int compareTo(Students o) {
        if (this.marks > o.marks) {
            return 1; 
        }else if (this.marks < o.marks) {
            return -1; 
        }else {
            return 0;
        }
    }
}
