import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        Дан массив целых чисел. Нужно посчитать, сколько в нём уникальных (неповторяющихся) чисел.
        int[] nums = {1, 2, 2, 3, 4, 5};
        System.out.println("Unique count: " + countUnique(nums));

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Введите целое число: ");
//        String input = scanner.nextLine();
//
//        int sum = sumDigits(input);
//        System.out.println("Сумма цифр: " + sum);
//        int[] array = {2, -1, 5, 2, 6, -1, 99, 5, 8, 8, 8};
//        int[] sortedArray = sortByFrequency(array);
//
//        System.out.println(Arrays.toString(sortedArray)); // Вывод: [8, 2, 5, 6, -1, 99]
        //        Необходимо придумать алгоритм, который сможет найти 2 числа в переданном массиве, которые дают в сумме targetSum.
        int[] array = {1, 2, 4, 7, 6};
        int targetSum = 6;
        findTwoNumbers2(array, targetSum);
    }

    private static void findTwoNumbers2(int[] array, int targetSum) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            int c = targetSum - array[i];
            res.add(array[i]);
            if (res.contains(c)) {
                System.out.print(c + " " + array[i]);
                return;
            }
        }
    }

    /**
     * Отсортировать массив целых чисел по убыванию частоты элементов.
     * При одинаковой частоте сортирует по возрастанию значения.
     */
    private static int[] sortByFrequency(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, (c1, c2) -> {
            int comp = c2.getValue().compareTo(c1.getValue());
            if (comp != 0) {
                return comp;
            } else {
                return c1.getKey().compareTo(c2.getKey());
            }
        });
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < entryList.size(); i++) {
            set.add(entryList.get(i).getKey());
        }
        return set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // Метод принимает число в виде строки
    private static int sumDigits(String numStr) {
        int res = 0;
        for (int i = 0; i < numStr.length(); i++) {
            if (Character.isDigit(numStr.charAt(i))) {
                res += Integer.parseInt(String.valueOf(numStr.charAt(i)));
                //res+= numStr.charAt(i)-'0';
            }
        }
        return res;
    }

    private static int countUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int current = map.getOrDefault(nums[i], 0);
            map.put(nums[i], current + 1);
        }
        return (int) map.entrySet().stream()
                .filter(e-> e.getValue() ==1)
                .count();
//        int r = 0;
//        for (int res : map.values()) {
//            if (res == 1) {
//                r++;
//            }
//        }
//        return r;
    }

    public static String maskPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() <= 4) {
            // Если номер слишком короткий, возвращаем как есть или выбрасываем исключение
            return phoneNumber;
        }

        // Первые 2 символа
        String firstTwo = phoneNumber.substring(0, 2);
        // Последние 2 символа
        String lastTwo = phoneNumber.substring(phoneNumber.length() - 2);
        // Скрытая часть (звёздочки или другой символ)
        String hiddenPart = phoneNumber.substring(2, phoneNumber.length() - 2)
                .replaceAll(".", "*"); // заменяем каждый символ на *

        return firstTwo + hiddenPart + lastTwo;
    }

    public static int[] getIntersection(int[] one, int[] two) {
        Set<Integer> setOne = new HashSet<>();
        Set<Integer> commonElements = new HashSet<>();

        // Добавляем все элементы первого массива в setOne
        for (int num : one) {
            setOne.add(num);
        }

        // Проверяем, какие элементы из two есть в setOne
        for (int num : two) {
            if (setOne.contains(num)) {
                commonElements.add(num); // Добавляем в пересечение
            }
        }

        // Преобразуем Set<Integer> в int[]
        return commonElements.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean hasPairWithSum(int[] arr, int targetSum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {  // j = i + 1, чтобы не проверять пару с самим собой
                if (arr[i] + arr[j] == targetSum) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main1(String[] args) {


///    Задача:
///    Превратить List<List<String>> приходящий на вход в строку,
///    где каждый элемент коллекции разделен запятой и пробелом.
        List<List<String>> listOfLists = List.of(
                List.of("S4", "S5", "S6"),
                List.of("S4", "S5", "S6"),
                List.of("S7", "S8", "S9")
        );
        final var result = listOfListToString(listOfLists);
        //System.out.println(result);
/// Задача 12 Получить сотрудников из определенного отдела с зп выше указанной
        List<Department> departments = List.of(
                new Department("dep-1", "111-1", List.of(
                        new Employee("William", 15000L),
                        new Employee("Sophia", 22000L),
                        new Employee("John", 20000L)
                )),
                new Department("dep-2", "222-1", List.of(
                        new Employee("Victor", 25000L)
                ))
        );
        long res12 = departments.stream()
                .filter(department -> department.getCode().contains("111-"))
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= 20000L)
                .count();
        //System.out.println(res12);
////        Задача 11  — Сложная агрегация с Optional и reduce
////        Дан список чисел. Нужно найти произведение всех чисел больше 2. Если таких нет — вернуть 1.
        List<Integer> numbers11 = List.of(1, 2, 3, 4, 5);
        int res11 = numbers11.stream()
                .filter(i -> i > 2)
                .reduce(1, (a, b) -> a * b);
        //System.out.println(res11);
///        Задача 10  — Сортировка по нескольким полям и лимит
///        Есть список `Product` с `name` и `price`.
///        Отсортировать по убыванию цены, если цена совпадает — по алфавиту названия. Взять топ-3 самых дорогих.
        record Product(String name, double price) {
        }

        List<Product> products = List.of(
                new Product("Pen", 1.50),
                new Product("Notebook", 5.75),
                new Product("Book", 12.99),
                new Product("Pencil", 1.50),
                new Product("Eraser", 0.99)
        );
        List<Product> res10 = products.stream()
                //                .sorted((p1, p2)-> {
                //                if(p1.price == p2.price){
                //                    return p1.name.compareTo(p2.name);
                //                }else{
                //                    return Double.compare(p2.price, p1.price);
                //                }
                //               })
                .sorted(Comparator.comparingDouble(Product::price).reversed().thenComparing(Product::name))
                .limit(3)
                .collect(Collectors.toList());
        //System.out.println(res10);2
///        Задача 9 — Сложное плоское преобразование с фильтрацией
///        Есть список `Person` с полем `List<String> phoneNumbers`.
///        Нужно получить список уникальных телефонных номеров, которые начинаются с «+7».
        record Person(String name, List<String> phoneNumbers) {
        }

        List<Person> people = List.of(
                new Person("Alice", List.of("+7123456789", "+123456789")),
                new Person("Bob", List.of("+7987654321", "+7123456789")),
                new Person("Charlie", List.of("+123123123"))
        );
        System.out.println(people.stream()
                .collect(Collectors.groupingBy(Person::name, Collectors.toList())));

///        Задача 8  — Группировка с подсчетом и фильтрацией
///        Есть список заказов `Order` с полями `customerId` (int) и `amount` (double).
///        Нужно сгруппировать суммы заказов по клиентам, но учитывать только заказы с суммой больше 100. Вернуть Map\<customerId, totalAmount>.
        record Order(int customerId, double amount) {
        }
        List<Order> orders8 = List.of(
                new Order(1, 120),
                new Order(2, 50),
                new Order(1, 80),
                new Order(3, 200),
                new Order(2, 150)
        );
        Map<Integer, Double> res8 = orders8.stream()
                .filter(i -> i.amount > 100)
                .collect(Collectors.groupingBy(Order::customerId, Collectors.summingDouble(Order::amount)));
        //System.out.println(res8);
///        Задача 7  — Пропустить и взять
///        Пропустить первые 3 строки и взять следующие 5.
        List<String> strings7 = List.of("a", "b", "c", "d", "e", "f", "g", "6", "a");
        List<String> res7 = strings7.stream()
                .skip(3)
                .limit(5)
                .collect(Collectors.toList());
        //System.out.println(res7);
///        Задача 6  — Преобразование в Map
///        Из списка пользователей создать Map\<id, имя>.
        record User(int id, String name) {
        }
        List<User> users6 = List.of(
                new User(1, "Alice"),
                new User(2, "Bob"),
                new User(3, "Charlie")
        );
        Map<Integer, String> res6 = users6.stream()
                .collect(Collectors.toMap(User::id, User::name));
        //System.out.println(res6);
///        Задача 5  — Группировка по длине
///        Сгруппировать слова по длине.
        List<String> words5 = List.of("apple", "banana", "pear", "fig", "plum");
        Map<Integer, List<String>> res5 = words5.stream()
                .collect(Collectors.groupingBy(s -> s.length(), Collectors.toList()));
        //System.out.println(res5);
///        Задача 4  — Уникальные элементы
///        Вывести уникальные числа из списка с повторами.
        List<Integer> numbers4 = List.of(1, 2, 2, 3, 4, 4, 5);
        List<Integer> n = numbers4.stream()
                .distinct()
                .collect(Collectors.toList());
        //System.out.println(n);
///        Задача 3 — Поиск первого подходящего элемента
///        Найти первую строку, начинающуюся с буквы «A».
        List<String> strings3 = List.of("Apple", "banana", "Avocado", "cherry");
        String threeRes = strings3.stream()
                //.filter(s -> s.toLowerCase().charAt(0)=='a')
                .filter(s -> s.startsWith("A"))
                .findFirst().get();
        //System.out.println(threeRes);
////        Задача 2 — Преобразование элементов
////        Дан список чисел. Возвести каждое число в квадрат и вывести результат.
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5);
        List<Integer> twoRes = numbers2.stream()
                .map(i -> i * i)
                .collect(Collectors.toList());
        //System.out.println(twoRes);
////        Задача 1 — Фильтрация списка
////       Дан список строк. Вывести все строки длиной больше 5 символов.
        List<String> strings1 = List.of("apple", "banana", "pear", "pineapple", "kiwi");
        List<String> oneRes = strings1.stream()
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());
        //System.out.println(oneRes);
    }

    private static String listOfListToString(final List<List<String>> listOfLists) {
        return listOfLists.stream()
                .flatMap(l -> l.stream())
                .collect(Collectors.joining(", ", "{", "}"));
    }

    /// Найти 2 максимальное значение в массиве
    private static int getTwoMaxIntSort(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }

    private static int getTwoMaxInt(int[] arr) {
        int max = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max1 = max;
                max = arr[i];
            } else if (arr[i] > max1 && arr[i] != max) {
                max1 = arr[i];
            }
        }
        return max1;
    }

    /// /Сгрупировать слова по их дилинне
    private static void groupBy(List<String> list) {
        Map<Integer, List<String>> resMap = list.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    /**
     * //     * Дан массив строк: String[] array = {"Aston", "Deeeeeeev"};
     * //     * <p>
     * //     * Написать метод, который принимает массив строк на вход и выводит в консоль те же строки, но избавленные от повторяющихся букв.
     * //     * <p>
     * //     * Пример вывода: Aston Dev
     * //
     */
    private static void printStringsWithoutDuplicateLetters(String[] array) {
        Arrays.stream(array)
                .map(Main::arrayToString)
                .collect(Collectors.toList())
                .forEach(s -> System.out.print(s + " "));
    }

    private static String arrayToString(String string) {
        return Arrays.stream(string.split(""))
                .distinct()
                .collect(Collectors.joining());
    }

    /// Реализовать метод возвращающий те элементы из списка List<Integer>,
    /// которые больше среднего значения этого списка.
    private static List<Integer> filterOutSmallerElements(List<Integer> list) {
        // Описать код решения
        double v = list.stream().mapToInt(i -> i).average().orElseThrow();
        return list.stream().filter(y -> y > v).collect(Collectors.toList());
    }

    /// Реализовать код метода с помощью StreamAPI.
    /// Метод должен вернуть сумму всех элементов в списке.
    private static int sum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
        //list.stream().reduce(0, (i, i1)->i+i1);
        //list.stream().mapToInt(i -> i).sum();
    }

    /// Проверить валиден ли ip
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

    /// Реализовать код метода с помощью StreamAPI. Метод должен вернуть количество элементов в списке,
    /// делящихся на 3 без остатка.
    private static long onlyDividedByThree(List<Integer> list) {
        return list.stream()
                .filter(i -> i % 3 == 0)
                .count();
    }

    /// Посчитать количество гласных букв в строке (без учета регистра).
    /// Пример ввода: "Hello World"
    /// Ожидаемый вывод: 3
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

    public static String findFerstOutToCharacter(List<String> listS) {
        return listS.stream().filter(s -> s.toLowerCase().charAt(0) == 'j').findFirst().orElse(null);
    }

    /// реверт строки
    public static String reverseWords(String s) {
        return Arrays.stream(s.split(" "))
                .map(s1 -> new StringBuilder(s1).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    ///    Поиск второго наибольшего числа в списке
    ///    Задача: Найти второе по величине число в списке.
    ///    Пример ввода: [5, 2, 8, 1, 9, 3]
    ///    Ожидаемый вывод: 8
    public static int findSecondLargest(List<Integer> numbers) {
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
}
