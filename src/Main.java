import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {


/// Задача 12 Получить сотрудников из определенного отдела с зп выше указанной
    public static void main(String[] args){
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
        System.out.println(res12);
////        Задача 11  — Сложная агрегация с Optional и reduce
////        Дан список чисел. Нужно найти произведение всех чисел больше 2. Если таких нет — вернуть 1.
            List<Integer> numbers11 = List.of(1, 2, 3, 4, 5);
            int res11 = numbers11.stream()
                    .filter(i-> i>2)
                    .reduce(1, (a, b)->a*b);
            //System.out.println(res11);
///        Задача 10  — Сортировка по нескольким полям и лимит
///        Есть список `Product` с `name` и `price`.
///        Отсортировать по убыванию цены, если цена совпадает — по алфавиту названия. Взять топ-3 самых дорогих.
            record Product(String name, double price) {}

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
            //System.out.println(res10);
///        Задача 9 — Сложное плоское преобразование с фильтрацией
///        Есть список `Person` с полем `List<String> phoneNumbers`.
///        Нужно получить список уникальных телефонных номеров, которые начинаются с «+7».
        record Person(String name, List<String> phoneNumbers) {}

        List<Person> people = List.of(
                new Person("Alice", List.of("+7123456789", "+123456789")),
                new Person("Bob", List.of("+7987654321", "+7123456789")),
                new Person("Charlie", List.of("+123123123"))
        );
        List<String> res9 = people.stream()
                .flatMap(p->p.phoneNumbers.stream())
                .filter(n->n.startsWith("+7"))
                .distinct()
                .collect(Collectors.toList());
        //System.out.println(res9);
///        Задача 8  — Группировка с подсчетом и фильтрацией
///        Есть список заказов `Order` с полями `customerId` (int) и `amount` (double).
///        Нужно сгруппировать суммы заказов по клиентам, но учитывать только заказы с суммой больше 100. Вернуть Map\<customerId, totalAmount>.
        record Order(int customerId, double amount) {}
        List<Order> orders8 = List.of(
                new Order(1, 120),
                new Order(2, 50),
                new Order(1, 80),
                new Order(3, 200),
                new Order(2, 150)
        );
        Map<Integer, Double> res8 = orders8.stream()
                .filter(i->i.amount>100)
                .collect(Collectors.groupingBy(Order::customerId, Collectors.summingDouble(Order::amount)));
        //System.out.println(res8);
///        Задача 7  — Пропустить и взять
///        Пропустить первые 3 строки и взять следующие 5.
        List<String> strings7 = List.of("a", "b", "c", "d", "e", "f", "g", "6", "a");
        List<String> res7 = strings7.stream().skip(3).limit(5).collect(Collectors.toList());
        //System.out.println(res7);
///        Задача 6  — Преобразование в Map
///        Из списка пользователей создать Map\<id, имя>.
        record User(int id, String name) {}
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
                .collect(Collectors.groupingBy(s->s.length(), Collectors.toList()));
        //System.out.println(res5);
///        Задача 4  — Уникальные элементы
///        Вывести уникальные числа из списка с повторами.
        List<Integer> numbers4 = List.of(1, 2, 2, 3, 4, 4, 5);
        List<Integer> n = numbers4.stream().distinct().collect(Collectors.toList());
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
          List<Integer> twoRes = numbers2.stream().map(i->i*i).collect(Collectors.toList());
          //System.out.println(twoRes);
////        Задача 1 — Фильтрация списка
////       Дан список строк. Вывести все строки длиной больше 5 символов.
        List<String> strings1 = List.of("apple", "banana", "pear", "pineapple", "kiwi");
        List<String> oneRes = strings1.stream()
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());
        //System.out.println(oneRes);
    }

}