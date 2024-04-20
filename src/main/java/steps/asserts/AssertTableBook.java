package steps.asserts;

import entity.TableBook;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AssertTableBook {

    public static void checkListSize(List<TableBook> books, int size) {
        assertThat(books.size(), equalTo(size));
    }
}
