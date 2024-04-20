package models.response_positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "authors_books")
public class ResponsePositiveGetBooksXml {

    @XmlElementWrapper(name = "books")
    @XmlElement(name = "book", required = true)
    private List<Book> books;
}
