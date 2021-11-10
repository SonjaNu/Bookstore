package palvelinohjelmointi.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

import palvelinohjelmointi.Bookstore.web.BookController;
import palvelinohjelmointi.Bookstore.web.CategoryController;

//@RunWith(SpringRunner.class) // JUnit4
@ExtendWith(SpringExtension.class)   // JUnit5 eli Jupiter
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;
	private CategoryController categoryController;
	
	@Test
	public void contextLoads() {
	    assertThat(bookController).isNotNull();
		assertThat(categoryController).isNotNull();
	}
	
}
