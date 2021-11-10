package palvelinohjelmointi.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import palvelinohjelmointi.Bookstore.domain.Category;
import palvelinohjelmointi.Bookstore.domain.Book;
import palvelinohjelmointi.Bookstore.domain.BookRepository;


//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class BookstoreRepositoryTest {
	
    @Autowired
    private BookRepository repository;

    @Test  
    public void findByBookTitleShouldReturnBook() {
    	List<Book> books = repository.findByTitle("Rivo satakieli");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Leena Lehtolainen");
    }
    // (String title, String author, int year, String isbn, double price, Category category)
    Category category = new Category("Romantiikka");
    @Test 
    public void createNewBook() {
    	Book book = new Book("Toscanan auringon alla", "Joku tyyppi", 1990, "bb124351", 9.90, category);
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    } 
    @Test
    public void deleteBook() {
    	List<Book> books = repository.findByTitle("Toscanan auringon alla");
    	repository.deleteAll(books);
    	
    	assertThat(books).hasSize(0);
        
    }
}
