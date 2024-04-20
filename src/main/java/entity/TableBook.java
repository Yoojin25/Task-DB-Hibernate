package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "book")
@Data
public class TableBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "author_id")
    private long authorId;

    @Column(name = "updated")
    private Date updated;
}
