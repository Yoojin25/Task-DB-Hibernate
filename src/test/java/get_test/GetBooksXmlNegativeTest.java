package get_test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.response_negative.ResponseNegative;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import steps.asserts.AssertNegative;

import static steps.ExpectedResponseNegative.*;
import static steps.RequestExecutor.*;

@Epic("Тестирование POST-методов")
@Story("Получение книг автора в XML формате, негативный сценарий")
public class GetBooksXmlNegativeTest {

    @ParameterizedTest(name = "id автора: {0}")
    @DisplayName("Получение всех книг автора (xml), которого не существует в таблице author")
    @Description("Сервис не получает информацию о книгах автора, статус-код 409")
    @ValueSource(longs = {1234567, -100})
    public void getBooksXmlNonExistAuthor(long id) {
        ResponseNegative response = getBooksXmlNegative(id, 409);

        AssertNegative.checkNegativeTest(response, nonExistAuthorErrorCode, nonExistAuthorErrorMessage);
    }
}
