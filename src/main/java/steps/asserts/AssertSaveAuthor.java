package steps.asserts;

import models.response_positive.ResponsePositiveSaveAuthor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class AssertSaveAuthor {

    public static void checkSaveAuthor(ResponsePositiveSaveAuthor author) {
        assertThat(author.getAuthorId(), greaterThan(0L));
    }
}
