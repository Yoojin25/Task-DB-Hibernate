package steps.asserts;

import models.response_positive.ResponsePositiveSaveBook;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class AssertSaveBook {

    public static void checkSaveBook(ResponsePositiveSaveBook book) {
        assertThat(book.getBookId(), greaterThan(0L));
    }
}
