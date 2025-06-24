import java.security.PublicKey;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main1 {

    public void main(String[] args) {

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
    //    Задача:
//    Превратить List<List<String>> приходящий на вход в строку,
//    где каждый элемент коллекции разделен запятой и пробелом.
//    Дано:
//    public static void main(String[] args) {
//        List<List<String>> listOfLists = List.of(
//                List.of("S4", "S5", "S6"),
//                List.of("S4", "S5", "S6"),
//                List.of("S7", "S8", "S9")
//        );
//        new Random().nextBoolean()
//        final var result = listOfListToString(listOfLists);
//        System.out.println(result);
//    }
    private static String listOfListToString(final List<List<String>> listOfLists) {
        String res = listOfLists.stream()
                .flatMap(l-> l.stream())
                .collect(Collectors.joining(", ", "{", ""}));
    }
    private static int getTwoMaxIntSort(int[] arr){
        Arrays.sort(arr);
       return arr[arr.length-2];
    }
    private static int getTwoMaxInt(int[] arr){
        int max = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        for(int i = 0; i <arr.length; i++){
            if(arr[i]>max){
                max1=max;
                max = arr[i];
            } else if (arr[i]>max1 && arr[i] != max) {
                max1 = arr[i];
            }
        }
        return max1;
    }
    //Сгрупировать слова по их дилинне
    private static void groupBy(List<String> list){
    Map<Integer, List<String>> resMap = list.stream()
            .collect(Collectors.groupingBy(String::length));
    }
    private static void twoSum(int[] nums, int target) {
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                num2 = nums[j];
                if (num1 + num2 == target) {
                    System.out.print(i);
                    System.out.print(j);
                    return;
                }
            }
        }
        System.out.print(false);
    }
    //
    private static Integer RomeToArab(String s) {
        Map<String, Integer> roMop = new HashMap<>();
        roMop.put("I", 1);
        roMop.put("II", 2);
        roMop.put("III", 3);
        roMop.put("IV", 4);
        roMop.put("V", 5);
        roMop.put("VI", 6);
        roMop.put("VII", 7);
        roMop.put("VIII", 8);
        roMop.put("IX", 9);
        roMop.put("X", 10);
        roMop.put("L", 50);
        roMop.put("C", 100);
        roMop.put("M", 1000);
        roMop.put("D", 500);
        int res = 0;
        for (int i = s.length(); i>=0;i--){
            res = res + roMop.get(String.valueOf(s.charAt(i)));
        }
        return res;
    }

    /**
     * Дан массив строк: String[] array = {"Aston", "Deeeeeeev"};
     * <p>
     * Написать метод, который принимает массив строк на вход и выводит в консоль те же строки, но избавленные от повторяющихся букв.
     * <p>
     * Пример вывода: Aston Dev
     */

    private static void printStringsWithoutDuplicateLetters(String[] array) {
        Arrays.stream(array)
                .map(Main1::arrayToString)
                .collect(Collectors.toList())
                .stream().reduce()
                .forEach(s -> System.out.print(s + " "));
    }

    private static String arrayToString(String string) {
        return Arrays.stream(string.split(""))
                .distinct()
                .collect(Collectors.joining());
    }

    //Реализовать метод возвращающий те элементы из списка List<Integer>,
    // которые больше среднего значения этого списка.
    private static List<Integer> filterOutSmallerElements(List<Integer> list) {
        // Описать код решения
        double v = list.stream().mapToInt(i -> i).average().orElseThrow();
        return list.stream().filter(y -> y > v).collect(Collectors.toList());
    }

    //Реализовать код метода с помощью StreamAPI. Метод должен вернуть количество элементов в списке,
    // делящихся на 3 без остатка.
    private static long onlyDividedByThree(List<Integer> list) {
        return list.stream()
                .filter(i -> i % 3 == 0)
                .count();
    }

    //Реализовать код метода с помощью StreamAPI.
    // Метод должен вернуть сумму всех элементов в списке.

    private static int sum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
        //list.stream().reduce(0, (i, i1)->i+i1);
        //list.stream().mapToInt(i -> i).sum();
    }


    public static String findFerstOutToCharacter(List<String> listS) {
        return listS.stream().filter(s -> s.toLowerCase().charAt(0) == 'j').findFirst().orElse(null);
    }

    public static int countVowels(String s) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                res++;
            }
        }
        return res;
    }

    public static int findSecondLargest(List<Integer> numbers) {
//    numbers.sort(Integer::compare);
//    return numbers.get(numbers.size()-2);
        Integer max = numbers.get(0);
        Integer max1 = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max1 = max;
                max = numbers.get(i);
            } else if (numbers.get(i) > max1 && numbers.get(i) != max) {
                max1 = numbers.get(i);
            }
        }
        return max1;
    }

    public static String reverseWords(String s) {

        return Arrays.stream(s.split(" "))
                .map(s1 -> new StringBuilder(s1).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    public static boolean isValidIPv4(String ip) {
        String[] split = ip.split("\\.");
        if (split.length != 4) {
            return false;
        }
        try {
            for (String s : split) {
                int i1 = Integer.parseInt(s);
                if (i1 > 255 || i1 < 0) {
                    return false;
                }
            }
        } catch (NumberFormatException n) {
            return false;
        }
        return true;
    }
}

//        Проверка валидности IP-адреса (IPv4)
//        Задача: Проверить, является ли строка валидным IPv4-адресом.
//        Пример ввода: "192.168.1.1"
//        Ожидаемый вывод: true
//        public static boolean isValidIPv4(String ip) {


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


//Посчитать количество гласных букв в строке (без учета регистра).
//Пример ввода: "Hello World"
//Ожидаемый вывод: 3
//public static int countVowels(String s) {
//
//}
//
//aeiouAEIOU