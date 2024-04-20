package steps;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class DataGeneration {

    public static String firstNameData() {
        return randomAlphabetic(15);
    }

    public static String familyNameData() {
        return randomAlphabetic(15);
    }

    public static String secondNameData() {
        return randomAlphabetic(15);
    }

    public static String bookTitleData() {
        return randomAlphabetic(15);
    }

    public static String bookTitleDataMaxLength() {
        return randomAlphabetic(51);
    }
}
