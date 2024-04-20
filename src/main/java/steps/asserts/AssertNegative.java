package steps.asserts;

import models.response_negative.ResponseNegative;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AssertNegative {

    public static void checkNegativeTest(ResponseNegative response, String errorCode, String errorMessage) {
        assertThat(errorCode, equalTo(response.getErrorCode()));
        assertThat(errorMessage, equalTo(response.getErrorMessage()));
    }
}
