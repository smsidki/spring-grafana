package id.spring.grafana.api;

import id.spring.grafana.entity.Book;
import id.spring.grafana.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookApi {
    
    private final BookRepo bookRepo;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }
    
    @GetMapping
    public List<Book> findBooks(@RequestParam String author, Pageable page) {
        return bookRepo.findByAuthor(author, page).getContent();
    }
    
    @GetMapping("/_slow")
    public List<Book> findBooksSlowMode(@RequestParam String author, Pageable page) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep((long) ((Math.random() + 1) * 1000));
        return bookRepo.findByAuthor(author, page).getContent();
    }
    
}
