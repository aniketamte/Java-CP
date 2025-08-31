import java.util.Arrays;

public class CustomGenericArrayList<T> {
    private Object data[];
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomGenericArrayList() {
        data = new Object[DEFAULT_SIZE];
    }

    public void add(T num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object temp[] = new Object[data.length * 2];
        //Copy the current item in the new array
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public T remove() {
        T removed = (T)(data[--size]);
        return removed;
    }

    public T get(int index) {
        return (T)data[index];
    }

    public int size() {
        return size;
    }

    public void set(int index, T value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "customArrayList {" + "data =" + Arrays.toString(data) + ", size= " + size + "}";
    }

    public static void main(String[] args) {
        // ArrayList list = new ArrayList();
        CustomGenericArrayList list = new CustomGenericArrayList();
      //   list.add(3);
      //   list.add(13);
      //   list.add(32);
      //   list.add(33);
      //   list.add(43);

      //   for (int i = 0; i <= 15; i++) {
      //       list.add(2 * i);
      //   }

      //   System.out.println(list);

      //   ArrayList<Integer> list2 = new ArrayList<>();
      //   list2.add(5);

      //   ArrayList<String> list3 = new ArrayList<>();
      //   list3.add("ABC");

        CustomGenericArrayList<Integer> l4 = new CustomGenericArrayList<>();
        
        for(int i=0; i<14; i++){
            l4.add(2 * i);
        }

        System.out.println(l4);
    }
}
