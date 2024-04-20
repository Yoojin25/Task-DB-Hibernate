package post_test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.request.RequestSaveAuthor;
import models.response_positive.ResponsePositiveSaveAuthor;
import models.response_positive.ResponsePositiveSaveBook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.asserts.AssertSaveBook;

import static steps.DataGeneration.*;
import static steps.RequestExecutor.saveAuthor;
import static steps.RequestExecutor.saveBook;
import static utils.DateFormatting.authorBirthDate;

@Epic("Тестирование POST-методов")
@Story("Сохранение книги, позитивный сценарий")
public class SaveBookTest {

    @Test
    @DisplayName("Сохранение новой книги")
    @Description("Сервис сохраняет новую книгу в таблицу book, в ответе отображается id сохраненной книги, статус-код 201")
    public void saveBookTest() {
        String birthDate = authorBirthDate(2020, 02, 20);

        RequestSaveAuthor author = new RequestSaveAuthor(firstNameData(), familyNameData(), secondNameData(), birthDate);
        ResponsePositiveSaveAuthor authorSave = saveAuthor(author, 201);

        ResponsePositiveSaveBook book = saveBook(bookTitleData(), authorSave.getAuthorId(), 201);

        AssertSaveBook.checkSaveBook(book);
    }

    @Test
    @DisplayName("Сохранение новой книги без отчества (secondName) автора")
    @Description("Сервис сохраняет новую книгу в таблицу book, в ответе отображается id сохраненной книги, статус-код 201")
    public void saveBookWithoutAuthorSecondName() {
        String birthDate = authorBirthDate(2020, 02, 20);

        RequestSaveAuthor author = new RequestSaveAuthor(firstNameData(), familyNameData(), "", birthDate);
        ResponsePositiveSaveAuthor authorSave = saveAuthor(author, 201);

        ResponsePositiveSaveBook book = saveBook(bookTitleData(), authorSave.getAuthorId(), 201);

        AssertSaveBook.checkSaveBook(book);
    }
}
