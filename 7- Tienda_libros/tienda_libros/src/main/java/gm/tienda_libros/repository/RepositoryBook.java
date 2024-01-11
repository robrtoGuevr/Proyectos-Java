package gm.tienda_libros.repository;

import gm.tienda_libros.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryBook extends JpaRepository<Book, Integer> {

}
