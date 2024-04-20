package post_test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.request.RequestSaveAuthor;
import models.response_negative.ResponseNegative;
import models.response_positive.ResponsePositiveSaveAuthor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.asserts.AssertNegative;

import static steps.DataGeneration.*;
import static steps.ExpectedResponseNegative.*;
import static steps.RequestExecutor.*;
import static utils.DateFormatting.authorBirthDate;

@Epic("Тестирование POST-методов")
@Story("Сохранение книги, негативный сценарий")
public class SaveBookNegativeTest {

    @Test
    @DisplayName("Сохранение новой книги без указания bookTitle")
    @Description("Сервис не сохраняет новую книгу в таблицу book, статус-код 400")
    public void saveBookWithEmptyBookTitle() {
        String birthDate = authorBirthDate(2020, 02, 20);

        RequestSaveAuthor author = new RequestSaveAuthor(firstNameData(), familyNameData(), secondNameData(), birthDate);
        ResponsePositiveSaveAuthor authorSave = saveAuthor(author, 201);

        ResponseNegative response = saveBookNegative("", authorSave.getAuthorId(), 400);

        AssertNegative.checkNegativeTest(response, validationFailErrorCode, argNotPassedErrorMessage);
    }

    @Test
    @DisplayName("Сохранение новой книги автора, который не существует в таблице author")
    @Description("Сервис не сохраняет новую книгу в таблицу book, статус-код 409")
    public void saveBookNonExistAuthor() {
        ResponseNegative response = saveBookNegative(bookTitleData(), 1234567, 409);

        AssertNegative.checkNegativeTest(response, nonExistAuthorErrorCode, nonExistAuthorErrorMessage);
    }

    @Test
    @DisplayName("Сохранение новой книги c bookTitle превышающим максимальную длину")
    @Description("Сервис не сохраняет новую книгу в таблицу book, статус-код 400")
    public void bookTitleGreaterThanMaxLength() {
        String birthDate = authorBirthDate(2020, 02, 20);

        RequestSaveAuthor author = new RequestSaveAuthor(firstNameData(), familyNameData(), secondNameData(), birthDate);
        ResponsePositiveSaveAuthor authorSave = saveAuthor(author, 201);

        ResponseNegative response = saveBookNegative(bookTitleDataMaxLength(), authorSave.getAuthorId(), 400);

        AssertNegative.checkNegativeTest(response, validationFailErrorCode, invalidFieldSizeErrorMessage);
    }
}
