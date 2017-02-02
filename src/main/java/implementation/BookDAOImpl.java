package implementation;

import dao.BookDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pojo.Book;

import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private SessionFactory sessionFactory;

    @Autowired(required = true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @SuppressWarnings("unchecked")
    public List<Book> getAll() {
        Session session = this.sessionFactory.openSession();
        List<Book> books = session.createQuery("select b FROM Book b").list();
        session.close();
        return books;
    }

    public Book findByTitle(String title) {
        return null;
    }

    public Book findByAuthor(String authorName) {
        return null;
    }

    public void add(Book book) {
        Session session = this.sessionFactory.openSession();
        session.save(book);
        session.close();
    }

    public Book get(int id) {
        Session session = sessionFactory.openSession();
        Object book = session.get(Book.class, id);
        session.close();
        return (Book) book;
    }

    public void update(Book book, int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Book proxyBook = session.get(Book.class, id);
        proxyBook.setBookTitle(book.getBookTitle());
        proxyBook.setBookAuthor(book.getBookAuthor());
        proxyBook.setBookPrice(book.getBookPrice());
        session.update(proxyBook);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Book persistInstance = session.load(Book.class, id);
        session.delete(persistInstance);
        session.getTransaction().commit();
        session.close();
    }
}

