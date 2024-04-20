package steps.database_queries;

import entity.TableBook;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static configuration.LibraryDatabaseConfiguration.getSession;

public class BookRepository {

    Session session;

    public BookRepository() {
        session = getSession();
    }

    public void deleteAll() {
        final String hql = """
                DELETE FROM book
                """;

        Transaction tr = session.beginTransaction();
        session.createNativeQuery(hql, TableBook.class)
                .executeUpdate();
        tr.commit();
    }

    public void insertBook(String bookTitle, long authorId) {
        final String hql = """
                INSERT INTO book
                (book_title, author_id)
                VALUES (:bookTitle, :authorId)
                """;

        Transaction tr = session.beginTransaction();
        session.createNativeQuery(hql, TableBook.class)
                .setParameter("bookTitle", bookTitle)
                .setParameter("authorId", authorId)
                .executeUpdate();
        tr.commit();
    }

    public List<TableBook> findAll() {
        final String hql = """
                SELECT * FROM book
                """;

        return session.createNativeQuery(hql, TableBook.class)
                .getResultList();
    }

    public List<TableBook> findByBookTitle(String bookTitle) {
        final String hql = """
                SELECT * FROM book
                WHERE book_title = :bookTitle
                """;

        return session.createNativeQuery(hql, TableBook.class)
                .setParameter("bookTitle", bookTitle)
                .getResultList();
    }

    public void deleteByBookTitle(String bookTitle) {
        final String hql = """
                DELETE FROM book
                WHERE book_title = :bookTitle
                """;

        Transaction tr = session.beginTransaction();
        session.createNativeQuery(hql, TableBook.class)
                .setParameter("bookTitle", bookTitle)
                .executeUpdate();
        tr.commit();
    }
}
