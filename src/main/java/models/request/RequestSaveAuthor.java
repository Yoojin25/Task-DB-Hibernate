package models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestSaveAuthor {
    private String firstName;
    private String familyName;
    private String secondName;
    private String birthDate;
}
