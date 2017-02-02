package service;

import dao.BookDAO;
import implementation.BookDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;


    @Transactional
    public void addBook(Book book) {
        this.bookDAO.add(book);
    }

    @Transactional
    public void updateBook(Book book, int id) {
        this.bookDAO.update(book, id);
    }

    @Transactional
    public void delete(int id) {
        this.bookDAO.delete(id);
    }

    @Transactional
    public Book getById(int id) {
        return this.bookDAO.get(id);
    }

    @Transactional
    public List<Book> getBooks() {
        return this.bookDAO.getAll();
    }

    public void setBookDAO(BookDAOImpl bookDAO) {
        this.bookDAO = bookDAO;
    }
}
