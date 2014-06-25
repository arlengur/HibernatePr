import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.arlen.Entity.Book;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Write the Book object into the database
        Book book = new Book();
        book.setTitle("Bhagabat-gita");
        book.setCreateDate(new Date());

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(book);

//        Book bookFromT = (Book)session.get(Book.class, 3);
        List<Book> bookListFromT = session.createCriteria(Book.class).list();
        for (Book book_ : bookListFromT) {
            System.out.println(book);
        }

        session.getTransaction().commit();
        session.close();

        sessionFactory.close();
    }
}
