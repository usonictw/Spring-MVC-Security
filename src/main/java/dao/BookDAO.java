package dao;

import pojo.Book;

public interface BookDAO extends DAO<Book> {

    Book findByTitle(String title);
    Book findByAuthor(String authorName);
}
