package stream.two;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTwo {
    //для каждой категории среднюю цену
    //Самый дорогой продукт в категории
    public Map<String, Map<String, Object>> analyze(List<Product> products){

        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.teeing(
                                Collectors.averagingDouble(Product::getSalary),
                                Collectors.maxBy(Comparator.comparingDouble(Product::getSalary)),
                                (c1, c2)-> {
                                    Map<String, Object> map = new HashMap<>();
                                    map.put("AVG", c1);
                                    map.put("max", c2);
                                    return map;
                                }
                                )
                        )
                );

    }
}
