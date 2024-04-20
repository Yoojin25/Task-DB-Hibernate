package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "author")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class TableAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @XmlElement(name = "id", required = true)
    private long id;

    @Column(name = "first_name")
    @XmlElement(name = "first_name", required = true)
    private String firstName;

    @Column(name = "family_name")
    @XmlElement(name = "family_name", required = true)
    private String familyName;

    @Column(name = "second_name")
    @XmlElement(name = "second_name")
    private String secondName;

    @Column(name = "birth_date")
    @XmlElement(name = "birth_date")
    private String birthDate;
}
