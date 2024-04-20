package post_test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.request.RequestSaveAuthor;
import models.response_positive.ResponsePositiveSaveAuthor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.asserts.AssertSaveAuthor;

import static steps.DataGeneration.*;
import static steps.RequestExecutor.saveAuthor;
import static utils.DateFormatting.authorBirthDate;

@Epic("Тестирование POST-методов")
@Story("Сохранение автора, позитивный сценарий")
public class SaveAuthorTest {

    @Test
    @DisplayName("Сохранение нового автора")
    @Description("Сервис сохраняет нового автора в таблицу author, в ответе отображается id сохраненного автора, статус-код 201")
    public void saveAuthorTest() {
        String birthDate = authorBirthDate(2020, 02, 20);

        RequestSaveAuthor author = new RequestSaveAuthor(firstNameData(), familyNameData(), secondNameData(), birthDate);
        ResponsePositiveSaveAuthor authorSave = saveAuthor(author, 201);

        AssertSaveAuthor.checkSaveAuthor(authorSave);
    }
}
