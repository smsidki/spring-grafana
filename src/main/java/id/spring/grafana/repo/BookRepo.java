package id.spring.grafana.repo;

import id.spring.grafana.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
    
    Page<Book> findByAuthor(String author, Pageable page);
    
}
