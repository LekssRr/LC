import java.util.Arrays;

/**
 * Написать метод, который принимает несортированный массив целых чисел и возвращает true,
 * <p>
 * если все элементы массива можно упорядочить так, чтобы они образовали арифметическую прогрессию.
 * <p>
 * Арифметическая прогрессия — последовательность, где разность между соседними элементами постоянна:
 * <p>
 * arr[i + 1] - arr[i] == arr[1] - arr[0]
 * <p>
 * Примеры:
 * <p>
 * Input: {5, 1, 3, 4, 2}, true
 * <p>
 * Input: {7, 3, 5, 1}, true
 * <p>
 * Input: {1, 2, 4, 6}, false
 */
public class ArithmeticProgression {

    public static boolean canFormArithmeticProgression(int[] array) {
        if( array==null || array.length==0 ){
            throw new  RuntimeException("Пустой");
        }
        Arrays.sort(array);
        int res = array[1] - array[0];
        for(int i = 1; i <array.length - 1; i++){
            if(res != array[i+1] - array[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFormArithmeticProgression(new int[]{1, 2, 4, 6}));
        System.out.println(canFormArithmeticProgression(new int[]{7, 3, 5, 1}));
        System.out.println(canFormArithmeticProgression(new int[]{5, 1, 3, 4, 2}));
        System.out.println(canFormArithmeticProgression(new int[]{2, 4, 6, 7}));
        System.out.println(canFormArithmeticProgression(new int[]{}));
        System.out.println(canFormArithmeticProgression(null));
    }
}

