package service;

import pojo.Book;
import java.util.List;

public interface BookService {

    void addBook(Book book);
    void updateBook(Book book, int id);
    void delete(int id);
    Book getById(int id);
    List<Book> getBooks();
}
