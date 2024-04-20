package steps.asserts;

import entity.TableAuthor;
import entity.TableBook;
import models.response_positive.ResponsePositiveSaveAuthor;
import steps.database_queries.AuthorRepository;
import steps.database_queries.BookRepository;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AssertDatabase {
    static AuthorRepository authorRepository = new AuthorRepository();
    static BookRepository bookRepository = new BookRepository();

    public static void checkFindBooksByAuthorId(ResponsePositiveSaveAuthor authorSave, List<String> titles) {
        List<TableBook> books = bookRepository.findBookByAuthorId(authorSave.getAuthorId());

        assertThat(books.get(0).getAuthorId(), equalTo(authorSave.getAuthorId()));

        for (int i = 0; i < titles.size(); i++) {
            assertThat(books.get(i).getBookTitle(), equalTo(titles.get(i)));
        }
    }

    public static void checkFindBookByTitle(String bookTitle) {
        List<TableBook> books = bookRepository.findBookByTitle(bookTitle);

        assertThat(books.get(0).getBookTitle(), equalTo(bookTitle));
    }

    public static void checkFindAuthorById(ResponsePositiveSaveAuthor authorSave, String birthDate) {
        List<TableAuthor> author = authorRepository.findAuthorById(authorSave.getAuthorId());

        assertThat(author.get(0).getId(), equalTo(authorSave.getAuthorId()));

        assertThat(author.get(0).getBirthDate(), equalTo(birthDate));
    }
}
