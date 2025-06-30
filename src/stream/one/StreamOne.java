package stream.one;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamOne {
    public Map<String, List<Emploee>> groupEmployee(List<Emploee> emploees){
       return emploees.stream()
                .filter(emploee -> emploee.getSalary() > 1000)
                .collect(Collectors.groupingBy(Emploee::getDepartomint, Collectors.toList()));
    }
}
