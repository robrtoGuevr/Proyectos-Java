package gm.tienda_libros.service;

import gm.tienda_libros.model.Book;
import gm.tienda_libros.repository.RepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceBook implements IServiceBook{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private RepositoryBook repositoryBook;
    @Override
    public List<Book> readBooks() {
        return repositoryBook.findAll();
    }

    @Override
    public Book searchBookById(Integer idBook) {
        Book book = repositoryBook.findById(idBook).orElse(null);
        return book;
    }

    @Override
    public void saveBook(Book book) {
        repositoryBook.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        repositoryBook.delete(book);
    }
}
