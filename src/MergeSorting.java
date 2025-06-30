import java.util.Arrays;

public class MergeSorting {
    public static void main(String[] args) {
        int[] array = {5, 2, 4, 6, 1, 3, 2, 6};
        int[] array1 = {5, 2, 3, 1};
        sort(array1, 1, array1.length);
        System.out.println(Arrays.toString(array1));
    }

    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            sort(array, start, middle);
            sort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    public static void merge(int[] array, int start, int middle, int end) {
        int[] buf = new int[end - start +1];

        int started = start-1;
        int middled = middle;
        int i = 0;
        while (started<middle && middled<end){
            if(array[started]<=array[middled]){
                buf[i++] = array[started++];
            }else {
                buf[i++] = array[middled++];
            }
        }
        while (started<middle){
                buf[i++] = array[started++];
        }
        while (middled<end){
            buf[i++] = array[middled++];
        }
        i = 0;
        for (int r = start; r<end; r++){
            array[r]=buf[i++];
        }
    }
}
