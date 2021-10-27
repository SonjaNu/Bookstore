package palvelinohjelmointi.Bookstore;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import palvelinohjelmointi.Bookstore.BookstoreApplication;
import palvelinohjelmointi.Bookstore.domain.Book;
import palvelinohjelmointi.Bookstore.domain.BookRepository;
import palvelinohjelmointi.Bookstore.domain.Category;
import palvelinohjelmointi.Bookstore.domain.CategoryRepository;
import palvelinohjelmointi.Bookstore.domain.User;
import palvelinohjelmointi.Bookstore.domain.UserRepository;


@SpringBootApplication

public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	/*b) Change a creation of book examples on CommandLineRunner. Save all books with category 
information to the database. 
c) Add Category into book listpage to show category name of the book*/
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository categoryRepository, UserRepository userRepository) { //luo testidataa
		return (args) -> {
			
			Category category1 = new Category("Dekkarit");
			categoryRepository.save(category1);
			Category category2 = new Category("Romantiikka");
			categoryRepository.save(category2);
			Category category3 = new Category("Elämäkerrat");
			categoryRepository.save(category3);
			Category category4 = new Category("Runot");
			categoryRepository.save(category4);
			
			log.info("save a couple of books");
			
			repository.save(new Book("Eikä yksikään pelastunut", "Agatha Christie", 1993, "bb876567", 9.50, category1));
			repository.save(new Book("Rivo satakieli", "Leena Lehtolainen", 2000, "bb789064", 15.90, category1));	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
			log.info("fetch all categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
			
			User user1 = new User("user", 
					"$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
					User user2 = new User("admin", 
					"$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
					userRepository.save(user1);
				    userRepository.save(user2);

		};
	}

	}


