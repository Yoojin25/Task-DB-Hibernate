package steps;

public class ExpectedResponseNegative {
    public static String nonExistAuthorErrorCode = "1004";
    public static String nonExistAuthorErrorMessage = "Указанный автор не существует в таблице";

    public static String validationFailErrorCode = "1001";
    public static String argNotPassedErrorMessage = "Не передан обязательный параметр: bookTitle";
    public static String invalidFieldSizeErrorMessage = "Некорректный размер поля firstName";

    public static String invalidArgErrorCode = "1001";
    public static String invalidArgErrorMessage = "Некорректный обязательный параметр";
}
