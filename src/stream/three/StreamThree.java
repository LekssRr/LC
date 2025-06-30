package stream.three;

import java.util.*;
import java.util.stream.Collectors;

public class StreamThree {


    //Сумму транзакций для каждой валюты
    //топ 3 самых крупных транзакций для каждой валюты
    //общее колличество транзакций для каждой валюты

    public Map<String, Map<String, Object>> transactionProcesing(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCurency,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> {
                                            double sum = list.stream()
                                                    .mapToDouble(Transaction::getAmount)
                                                    .sum();
                                            List<Transaction> list1 = list.stream()
                                                    .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                                                    .limit(3)
                                                    .toList();
                                            return new HashMap<>() {
                                                {
                                                    put("Sum", sum);
                                                    put("top 3", list1);
                                                    put("всего", list.size());
                                                }
                                            };
                                        }

                                )
                        )
                );
    }

}
