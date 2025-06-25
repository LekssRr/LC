import java.util.List;
import java.util.stream.Collectors;

public class Task5WithBooks {
    public static void main(String[] args) {
        Book book1 = new Book(1, "111");
        Book book2 = new Book(2, "222");
        Book book3 = new Book(3, "333");
        Book book4 = new Book(4, "444");

        Reader reader1 = new Reader(1, "reader1", List.of(book1, book4));
        Reader reader2 = new Reader(2, "reader2", List.of(book2, book3));
        Reader reader3 = new Reader(3, "reader3", List.of(book2, book4));
        Reader reader4 = new Reader(4, "reader4", List.of(book3, book4, book2));

        List<Reader> readers = List.of(reader1, reader2,reader3,reader4);
        System.out.println(findReadersByBookName(readers, "333"));

    }
    //вернуть читателей у которых книга с некоторым названием
    private static List<Reader> findReadersByBookName(List<Reader> readers,String bookName){
        return readers.stream()
                .filter(reader -> reader.getBooks().stream()
                        .anyMatch(book -> book.getName().equals(bookName)))
                .collect(Collectors.toList());
    }
}
