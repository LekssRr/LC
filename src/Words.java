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
//}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static class Main {

//    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
//        return departments.stream()
//                .filter(department -> department.code.contains("111-"))
//                .flatMap(department -> department.employees.stream())
//                .filter(employee -> employee.salary >= threshold)
//                .count();
//
//    }
//    public static void main(String[] args) {
//
//        List<Department> departments = List.of(
//                new Department("dep-1", "111-1", List.of(
//                        new Employee("William", 15000L),
//                        new Employee("Sophia", 22000L),
//                        new Employee("John", 20000L)
//                )),
//                new Department("dep-2", "222-1", List.of(
//                        new Employee("Victor", 25000L)
//                ))
//        );
//        long res = departments.stream()
//                .filter(department -> department.code.contains("111-"))
//                .flatMap(department -> department.employees.stream())
//                .filter(employee -> employee.salary >= 20000L)
//                .count();
//        System.out.println(res);

////        Задача 11  — Сложная агрегация с Optional и reduce
////        Дан список чисел. Нужно найти произведение всех чисел больше 2. Если таких нет — вернуть 1.
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
//        int res = numbers.stream()
//                .filter(i-> i>2)
//                .reduce(1, (a, b)->a*b);
//        System.out.println(res);
//        Задача 10  — Сортировка по нескольким полям и лимит
//        Есть список `Product` с `name` и `price`.
//        Отсортировать по убыванию цены, если цена совпадает — по алфавиту названия. Взять топ-3 самых дорогих.
//        record Product(String name, double price) {}
//
//        List<Product> products = List.of(
//                new Product("Pen", 1.50),
//                new Product("Notebook", 5.75),
//                new Product("Book", 12.99),
//                new Product("Pencil", 1.50),
//                new Product("Eraser", 0.99)
//        );
//        List<Product> res = products.stream()
////                .sorted((p1, p2)-> {
////                if(p1.price == p2.price){
////                    return p1.name.compareTo(p2.name);
////                }else{
////                    return Double.compare(p2.price, p1.price);
////                }
////                })
//                .sorted(Comparator.comparingDouble(Product::price).reversed().thenComparing(Product::name))
//                .limit(3)
//                .collect(Collectors.toList());
//        System.out.println(res);
//        Задача 9 — Сложное плоское преобразование с фильтрацией
//        Есть список `Person` с полем `List<String> phoneNumbers`.
//        Нужно получить список уникальных телефонных номеров, которые начинаются с «+7».
//        record Person(String name, List<String> phoneNumbers) {}
//
//        List<Person> people = List.of(
//                new Person("Alice", List.of("+7123456789", "+123456789")),
//                new Person("Bob", List.of("+7987654321", "+7123456789")),
//                new Person("Charlie", List.of("+123123123"))
//        );
//        List<String> res = people.stream()
//                .flatMap(p->p.phoneNumbers.stream())
//                .filter(n->n.startsWith("+7"))
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(res);
//        Задача 8  — Группировка с подсчетом и фильтрацией
//        Есть список заказов `Order` с полями `customerId` (int) и `amount` (double).
//        Нужно сгруппировать суммы заказов по клиентам, но учитывать только заказы с суммой больше 100. Вернуть Map\<customerId, totalAmount>.
//        record Order(int customerId, double amount) {}
//
//        List<Order> orders = List.of(
//                new Order(1, 120),
//                new Order(2, 50),
//                new Order(1, 80),
//                new Order(3, 200),
//                new Order(2, 150)
//        );
//        Map<Integer, Double> res = orders.stream()
//                .filter(i->i.amount>100)
//                .collect(Collectors.groupingBy(Order::customerId, Collectors.summingDouble(Order::amount)));
//        System.out.println(res);
//        Задача 7  — Пропустить и взять
//        Пропустить первые 3 строки и взять следующие 5.
//        List<String> strings = List.of("a", "b", "c", "d", "e", "f", "g", "6", "a");
//        List<String> res = strings.stream().skip(3).limit(5).collect(Collectors.toList());
//        System.out.println(res);
//        Задача 6  — Преобразование в Map
//        Из списка пользователей создать Map\<id, имя>.
//        record User(int id, String name) {}
//        List<User> users = List.of(
//                new User(1, "Alice"),
//                new User(2, "Bob"),
//                new User(3, "Charlie")
//        );
//        Map<Integer, String> res = users.stream()
//                .collect(Collectors.toMap(User::id, User::name));
//        System.out.println(res);
//        Задача 5  — Группировка по длине
//        Сгруппировать слова по длине.
//        List<String> words = List.of("apple", "banana", "pear", "fig", "plum");
//        Map<Integer, List<String>> res = words.stream()
//                .collect(Collectors.groupingBy(s->s.length(), Collectors.toList()));
//        System.out.println(res);
//        Задача 4  — Уникальные элементы
//        Вывести уникальные числа из списка с повторами.
//        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 5);
//        List<Integer> n = numbers.stream().distinct().collect(Collectors.toList());
//        System.out.println(n);
//        Задача 3 — Поиск первого подходящего элемента
//        Найти первую строку, начинающуюся с буквы «A».
//        List<String> strings = List.of("Apple", "banana", "Avocado", "cherry");
//        String res = strings.stream()
//                //.filter(s -> s.toLowerCase().charAt(0)=='a')
//                .filter(s -> s.startsWith("A"))
//                .findFirst().get();
//        System.out.println(res);
//        Задача 2 — Преобразование элементов
//        Дан список чисел. Возвести каждое число в квадрат и вывести результат.
//          List<Integer> numbers = List.of(1, 2, 3, 4, 5);
//          List<Integer> res = numbers.stream().map(i->i*i).collect(Collectors.toList());
//          System.out.println(res);
//        Задача 1 — Фильтрация списка
//        Дан список строк. Вывести все строки длиной больше 5 символов.
//        List<String> strings = List.of("apple", "banana", "pear", "pineapple", "kiwi");
//        List<String> res = strings.stream()
//                .filter(s -> s.length() > 5)
//                .collect(Collectors.toList());
//        System.out.println(res);

        //как посчитать колличество студентов сдававших физику
//        List<Student> students = new ArrayList<>(Arrays.asList(
//                new Student("Иванов", "Иван", "Иванович", "Математика", false),
//                new Student("Петров", "Петр", "Иванович", "Физика", false),
//                new Student("Сидоров", "Сидор", "Сидорович", "Физика", false),
//                new Student("Сидоров", "Сидор", "Сидорович", "Физика", false),
//                new Student("Сидоров", "Сидор", "Сидорович", "Физика", false),
//                new Student("Князев", "Сидор", "Сидорович", "Физика", false),
//                new Student("Петров", "Сидор", "Сидорович", "Физика", false)));
//        System.out.println("Группировка по предмету");
//        System.out.println(
//                students.stream()
//                        .collect(Collectors.groupingBy(student -> student.name, Collectors.toList())));
//        System.out.println("Предмет и люди сдающие его");
//        System.out.println(
//                students.stream().collect(Collectors.groupingBy(s -> s.name, Collectors.counting()))
//        );
//        System.out.println("Группировка по is");
//        System.out.println(students.stream()
//                .filter(s -> !s.is)
//                .map(student -> {student.is=new Random().nextBoolean();
//                return student;})
//                .collect(Collectors
//                        .groupingBy(student -> student.is, Collectors.counting())));

    }




        //    Дана строка, состоящая из скобок ({[]}), необходимо проверить строку на валидность.
//    Валидной строка является та, в которой встречается открывающая и соответствующая ей закрывающая скобка.
        public static boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if (!isMatchingPair(top, c)) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        private static boolean isMatchingPair(char opening, char closing) {
            return (opening == '(' && closing == ')') ||
                    (opening == '{' && closing == '}') ||
                    (opening == '[' && closing == ']');
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
//    private static String listOfListToString(final List<List<String>> listOfLists) {
//        String res = listOfLists.stream()
//                .flatMap(l-> l.stream())
//                .collect(Collectors.joining(", ", "{", ""}));
//    }
//    private static int getTwoMaxIntSort(int[] arr){
//        Arrays.sort(arr);
//       return arr[arr.length-2];
//    }
//    private static int getTwoMaxInt(int[] arr){
//        int max = Integer.MIN_VALUE;
//        int max1 = Integer.MIN_VALUE;
//        for(int i = 0; i <arr.length; i++){
//            if(arr[i]>max){
//                max1=max;
//                max = arr[i];
//            } else if (arr[i]>max1 && arr[i] != max) {
//                max1 = arr[i];
//            }
//        }
//        return max1;
//    }
//    //Сгрупировать слова по их дилинне
//    private static void groupBy(List<String> list){
//    Map<Integer, List<String>> resMap = list.stream()
//            .collect(Collectors.groupingBy(String::length));
//    }
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
//    private static Integer RomeToArab(String s) {
//        Map<String, Integer> roMop = new HashMap<>();
//        roMop.put("I", 1);
//        roMop.put("II", 2);
//        roMop.put("III", 3);
//        roMop.put("IV", 4);
//        roMop.put("V", 5);
//        roMop.put("VI", 6);
//        roMop.put("VII", 7);
//        roMop.put("VIII", 8);
//        roMop.put("IX", 9);
//        roMop.put("X", 10);
//        roMop.put("L", 50);
//        roMop.put("C", 100);
//        roMop.put("M", 1000);
//        roMop.put("D", 500);
//        int res = 0;
//        for (int i = s.length(); i>=0;i--){
//            res = res + roMop.get(String.valueOf(s.charAt(i)));
//        }
//        return res;
//    }
//
//    /**
//     * Дан массив строк: String[] array = {"Aston", "Deeeeeeev"};
//     * <p>
//     * Написать метод, который принимает массив строк на вход и выводит в консоль те же строки, но избавленные от повторяющихся букв.
//     * <p>
//     * Пример вывода: Aston Dev
//     */
//
//    private static void printStringsWithoutDuplicateLetters(String[] array) {
//        Arrays.stream(array)
//                .map(Main1::arrayToString)
//                .collect(Collectors.toList())
//                .stream().reduce()
//                .forEach(s -> System.out.print(s + " "));
//    }
//
//    private static String arrayToString(String string) {
//        return Arrays.stream(string.split(""))
//                .distinct()
//                .collect(Collectors.joining());
//    }
//
//    //Реализовать метод возвращающий те элементы из списка List<Integer>,
//    // которые больше среднего значения этого списка.
//    private static List<Integer> filterOutSmallerElements(List<Integer> list) {
//        // Описать код решения
//        double v = list.stream().mapToInt(i -> i).average().orElseThrow();
//        return list.stream().filter(y -> y > v).collect(Collectors.toList());
//    }
//
//    //Реализовать код метода с помощью StreamAPI. Метод должен вернуть количество элементов в списке,
//    // делящихся на 3 без остатка.
//    private static long onlyDividedByThree(List<Integer> list) {
//        return list.stream()
//                .filter(i -> i % 3 == 0)
//                .count();
//    }
//
//    //Реализовать код метода с помощью StreamAPI.
//    // Метод должен вернуть сумму всех элементов в списке.
//
//    private static int sum(List<Integer> list) {
//        return list.stream().reduce(0, Integer::sum);
//        //list.stream().reduce(0, (i, i1)->i+i1);
//        //list.stream().mapToInt(i -> i).sum();
//    }
//
//
//    public static String findFerstOutToCharacter(List<String> listS) {
//        return listS.stream().filter(s -> s.toLowerCase().charAt(0) == 'j').findFirst().orElse(null);
//    }
//
//    public static int countVowels(String s) {
//        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
//        int res = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (set.contains(s.charAt(i))) {
//                res++;
//            }
//        }
//        return res;
//    }
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
//    public static String reverseWords(String s) {
//
//        return Arrays.stream(s.split(" "))
//                .map(s1 -> new StringBuilder(s1).reverse().toString())
//                .collect(Collectors.joining(" "));
//    }
//
//    public static boolean isValidIPv4(String ip) {
//        String[] split = ip.split("\\.");
//        if (split.length != 4) {
//            return false;
//        }
//        try {
//            for (String s : split) {
//                int i1 = Integer.parseInt(s);
//                if (i1 > 255 || i1 < 0) {
//                    return false;
//                }
//            }
//        } catch (NumberFormatException n) {
//            return false;
//        }
//        return true;
//    }
//}

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