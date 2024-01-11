package gm.tienda_libros.service;

import gm.tienda_libros.model.Book;

import java.util.List;

public interface IServiceBook {
    public List<Book> readBooks();

    public Book searchBookById(Integer idBook);

    public void saveBook(Book book);

    public void deleteBook(Book book);
}
