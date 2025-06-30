import java.util.Arrays;

public class InvertArray {
    /**
     * Дан массив с целыми числами.
     * <p>
     * Нужно реализовать метод, который инвертирует массив —
     * <p>
     * элементы должны идти в обратном порядке.
     * <p>
     * Пример:
     * <p>
     * Вход: {1, 2, 3, 4, 5}
     * <p>
     * Выход: {5, 4, 3, 2, 1}
     */
    public static int[] invertArray(int[] array) {
// Реализовать инвертирование массива
        if(array==null || array.length==0){
            return null;
        }
//        int[] res = new int[array.length];
//        int s = 0;
//        for(int i = array.length-1;i >= 0; i--){
//            res[s] = array[i];
//            s++;
//        }
        int current = 0;
        for (int i = 0; i < array.length / 2; i++){
            current = array[i];
            array[i] =  array[array.length-i -1];
            array[array.length-i -1] = current;
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(invertArray(new int[]{1, 2, 3, 4, 5})));
    }
}
