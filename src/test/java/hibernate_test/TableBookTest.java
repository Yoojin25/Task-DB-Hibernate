package hibernate_test;

import entity.TableBook;
import org.junit.jupiter.api.Test;
import steps.asserts.AssertTableBook;
import steps.database_queries.BookRepository;

import java.util.Arrays;
import java.util.List;

public class TableBookTest {

    @Test
    public void tableBookTest() {
        BookRepository bookRepository = new BookRepository();

        long authorId = 1;
        String book1 = "Книга_1";
        String book2 = "Книга_2";

//      1 - предварительно очистить таблицу
        bookRepository.deleteAll();

//      2 - добавить 2 записи в таблицу
        List<String> titles = Arrays.asList(book1, book2);

        for (String bookTitle : titles) {
            bookRepository.insertBook(bookTitle, authorId);
        }

//      3 - получить созданные записи и вывести их в консоль. Проверить, что количество записей = 2
        List<TableBook> books = bookRepository.findAll();
        System.out.println(books);

        AssertTableBook.checkListSize(books, 2);

//      4 - получить созданную запись по названию книги и вывести ее в консоль. Проверить, что количество записей = 1
        List<TableBook> bookByTitle = bookRepository.findBookByTitle("Книга_1");
        System.out.println(bookByTitle);

        AssertTableBook.checkListSize(bookByTitle, 1);

//      5 - удалить одну созданную запись
        bookRepository.deleteBookByTitle("Книга_1");

//      6 - получить оставшуюся запись и вывести ее в консоль. Проверить, что количество записей = 1
        List<TableBook> lastBook = bookRepository.findAll();
        System.out.println(lastBook);

        AssertTableBook.checkListSize(lastBook, 1);
    }
}
