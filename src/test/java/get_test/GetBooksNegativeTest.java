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
import static steps.RequestExecutor.getBooksNegative;

@Epic("Тестирование GET-методов")
@Story("Получение книг автора, негативный сценарий")
public class GetBooksNegativeTest {

    @ParameterizedTest(name = "некорректный параметр #{index}: {0}")
    @DisplayName("Получение всех книг автора при указании некорректных данных в id")
    @Description("Сервис не получает информацию о книгах автора, статус-код 400")
    @ValueSource(strings = {"id", "*~)=", " "})
    public void getBooksWithIncorrectId(String id) {
        ResponseNegative response = getBooksNegative(id, 400);

        AssertNegative.checkNegativeTest(response, invalidArgErrorCode, invalidArgErrorMessage);
    }

    @ParameterizedTest(name = "id автора: {0}")
    @DisplayName("Получение всех книг автора, которого не существует в таблице author")
    @Description("Сервис не получает информацию о книгах автора, статус-код 409")
    @ValueSource(strings = {"1234567", "-100"})
    public void getBooksNonExistAuthor(String id) {
        ResponseNegative response = getBooksNegative(id, 409);

        AssertNegative.checkNegativeTest(response, nonExistAuthorErrorCode, nonExistAuthorErrorMessage);
    }
}