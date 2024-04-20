package steps.asserts;

import models.response_positive.Book;
import models.response_positive.ResponsePositiveSaveAuthor;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AssertGetBooksXml {

    public static void checkGetBooksXml(List<Book> books, ResponsePositiveSaveAuthor authorSave, List<String> titles, String birthDate) {
        assertThat(books, is(not(empty())));

        assertThat(authorSave.getAuthorId(), equalTo(books.get(0).getAuthor().getId()));

        for (int i = 0; i < books.size(); i++) {
            assertThat(titles.get(i), equalTo(books.get(i).getBookTitle()));
        }

        assertThat(birthDate, equalTo(books.get(0).getAuthor().getBirthDate()));
    }

    public static void checkGetEmptyListOfBooksXml(List<Book> books) {
        assertThat(books, is(empty()));
    }
}
