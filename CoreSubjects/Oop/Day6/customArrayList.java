
import java.util.ArrayList;
import java.util.Arrays;

public class customArrayList {
    private int data[];
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public customArrayList(){
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        int temp[] = new int[data.length * 2];
        //Copy the current item in the new array
        for(int i=0; i<data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public int remove(){
        int removed = data[--size];
        return removed;
    }

    public int get(int index){
        return data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index, int value){
        data[index] = value;
    }

    @Override
    public String toString(){
        return "customArrayList {" + "data =" + Arrays.toString(data) + ", size= " + size + "}";
    }

    public static void main(String[] args) {
        // ArrayList list = new ArrayList();
        customArrayList list = new customArrayList();
        list.add(3);
        list.add(13);
        list.add(32);
        list.add(33);
        list.add(43);

        for(int i=0; i<=15; i++){
            list.add(2 * i);
        }

        System.out.println(list);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(5);

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("ABC");
    }
}
