import java.awt.*;
import java.security.PublicKey;
import java.util.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


//Задача 14
///*Написать программу для подсчета количества конкретных слов в строке используя хэш мар*/
//
public class Words {
    public static void main(String[] args) {
        String str = "This task task will be solved by by by Java developer developer ";
        System.out.println(findWordsWithGrouping(str));
    }

    private static Map<String, Long> findWordsWithGrouping(String str){
        String[] strArr = str.split(" ");
        return Arrays.stream(strArr).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

}

//    List.of("dog", "cat", "hamster")
//            .stream()
//                .filter(s -> {
//        System.out.println("filter: " + s);
//        return s.length() <= 3;
//    })
//            .map(s -> {
//        System.out.println("map: " + s);
//        return s.toUpperCase();
//    })
//            .sorted()
//                .forEach(s -> {
//        System.out.println("forEach: " + s);
//    });
//
//    List<Student> students = new ArrayList<>(Arrays.asList(
//            new Student("Иванов", "Иван", "Иванович", "Математика", false),
//            new Student("Петров", "Петр", "Петрович", "Физика", false),
//            new Student("Сидоров", "Сидор", "Сидорович", "Физика", false))
//    );
//    }
//


//    private static void twoSum(int[] nums, int target) {
//        int num1 = 0;
//        int num2 = 0;
//        for (int i = 0; i < nums.length; i++) {
//            num1 = nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                num2 = nums[j];
//                if (num1 + num2 == target) {
//                    System.out.print(i);
//                    System.out.print(j);
//                    return;
//                }
//            }
//        }
//        System.out.print(false);
//    }
//    //

//
//



//
//    public static int findSecondLargest(List<Integer> numbers) {
/// /    numbers.sort(Integer::compare);
/// /    return numbers.get(numbers.size()-2);
//        Integer max = numbers.get(0);
//        Integer max1 = numbers.get(0);
//        for (int i = 0; i < numbers.size(); i++) {
//            if (numbers.get(i) > max) {
//                max1 = max;
//                max = numbers.get(i);
//            } else if (numbers.get(i) > max1 && numbers.get(i) != max) {
//                max1 = numbers.get(i);
//            }
//        }
//        return max1;
//    }
//
//



//        Разворот слов в строке
//        Задача: Развернуть каждое слово в строке, сохраняя порядок слов.
//        Пример ввода: "Java is fun"
//        Ожидаемый вывод: "avaJ si nuf"
//        public static String reverseWords(String s) {

//    Поиск второго наибольшего числа в списке
//    Задача: Найти второе по величине число в списке.
//    Пример ввода: [5, 2, 8, 1, 9, 3]
//    Ожидаемый вывод: 8
//    public static int findSecondLargest(List<Integer> numbers) {
//}


