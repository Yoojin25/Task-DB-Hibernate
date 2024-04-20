package steps.database_queries;

import entity.TableAuthor;
import org.hibernate.Session;

import java.util.List;

import static configuration.LibraryDatabaseConfiguration.getSession;

public class AuthorRepository {

    Session session;

    public AuthorRepository() {
        session = getSession();
    }

    public List<TableAuthor> findAuthorById(long id) {
        final String hql = """
                SELECT * FROM author
                WHERE id = :id
                """;

        return session.createNativeQuery(hql, TableAuthor.class)
                .setParameter("id", id)
                .getResultList();
    }
}
