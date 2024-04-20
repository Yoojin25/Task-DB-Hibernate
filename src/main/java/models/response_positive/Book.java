package models.response_positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entity.TableAuthor;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "book")
public class Book {

    @XmlElement(name = "id", required = true)
    private long id;

    @XmlElement(name = "book_title", required = true)
    private String bookTitle;

    @XmlElement(name = "updated", required = true)
    private Date updated;

    @XmlElement(name = "author", required = true)
    private TableAuthor author;
}
