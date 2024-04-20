package get_test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.request.RequestSaveAuthor;
import models.response_positive.Book;
import models.response_positive.ResponsePositiveSaveAuthor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.asserts.AssertGetBooks;

import java.util.Arrays;
import java.util.List;

import static steps.DataGeneration.*;
import static steps.RequestExecutor.*;
import static utils.DateFormatting.authorBirthDate;

@Epic("Тестирование GET-методов")
@Story("Получение книг по id автора, позитивный сценарий")
public class GetBooksTest {

    @Test
    @DisplayName("Получение всех книг автора")
    @Description("Сервис получает информацию обо всех книгах автора по указанному id, в ответе отображается список " +
            "книг, статус-код 200")
    public void getBooksTest() {
        String birthDate = authorBirthDate(2020, 02, 20);

        RequestSaveAuthor author = new RequestSaveAuthor(firstNameData(), familyNameData(), secondNameData(), birthDate);
        ResponsePositiveSaveAuthor authorSave = saveAuthor(author, 201);

        List<String> titles = Arrays.asList(bookTitleData(), bookTitleData());

        for (String bookTitle : titles) {
            saveBook(bookTitle, authorSave.getAuthorId(), 201);
        }

        List<Book> books = getBooks(String.valueOf(authorSave.getAuthorId()), 200);

        AssertGetBooks.checkGetBooks(books, authorSave, titles, birthDate);
    }

    @Test
    @DisplayName("Получение пустого списка книг")
    @Description("Сервис получает информацию о книгах автора по указанному id, в ответе отображается пустой список " +
            "книг, статус-код 200")
    public void getEmptyListOfBooks() {
        String birthDate = authorBirthDate(2020, 02, 20);

        RequestSaveAuthor author = new RequestSaveAuthor(firstNameData(), familyNameData(), secondNameData(), birthDate);
        ResponsePositiveSaveAuthor authorSave = saveAuthor(author, 201);

        List<Book> books = getBooks(String.valueOf(authorSave.getAuthorId()), 200);

        AssertGetBooks.checkGetEmptyListOfBooks(books);
    }
}
