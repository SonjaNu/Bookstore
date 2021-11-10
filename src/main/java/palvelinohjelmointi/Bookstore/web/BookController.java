package palvelinohjelmointi.Bookstore.web;

import java.util.List;
import java.util.Optional;

/*We will now start to create our training project. This excercise continues through the whole course 
and it will be returned to Github.  
  
a.)  Create a project called Bookstore by using Spring Initializr page (include web, devtools)  
b.)  Add a new controller called BookController which handle get request to the path /index  
c.)  Add a new model class called Book which contains attributes: title, author, year, isbn, price  
d.)  Add your project to your GitHub account (See the instructions from the moodle) */

//endpoint    http://localhost:8080/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import palvelinohjelmointi.Bookstore.domain.Book;
import palvelinohjelmointi.Bookstore.domain.BookRepository;
import palvelinohjelmointi.Bookstore.domain.CategoryRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository; //privaatti BookRepository nimeltään repository
	
	@Autowired
	private CategoryRepository categoryRepository; 

	//Näytä kaikki kirjat
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
		public String bookList(Model model) {
		model.addAttribute("books", repository.findAll()); 
		return "bookListTemplate";
	
	}
	//RESTful service --> hakee kaikki kirjat, muuttaa javasta JSON:iksi
	@RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    }  
	
	//RESTful service --> hakee yhden kirjan id:n mukaan, muuttaa javasta JSON:iksi
	 @RequestMapping(value="/books/{id}", method = RequestMethod.GET) 
	    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
	    	return repository.findById(bookId);
	    }    
	
	
	
	
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(@ModelAttribute Book book){
	        repository.save(book);
	        return "redirect:/booklist";  //uudelleen ohjataan toiseen endpointtiin
	    } 
	
	 @RequestMapping(value = "/add")
	    public String addBook(Model model){
	    	model.addAttribute("book", new Book());
	    	model.addAttribute("category", categoryRepository.findAll());
	        return "addBook";
	    }   
	 
	
	 
	 @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	 public String editBook(@PathVariable("id") long bookId, Model model) {
	     model.addAttribute("book", repository.findById(bookId).get());
	     return "editbook";
	 }	
	 
	 //jos kirjan id on 0 tai null, se tekee sql insertin, muuten se tekee sql updaten
	 //
	 
	 @PreAuthorize(value = "hasAuthority('ADMIN')") //kuka saa suorittaa kirjan poiston eli roolin on oltava Admin
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	    	repository.deleteById(bookId);
	        return "redirect:../booklist";
	    }    
	 
	 @RequestMapping(value="/login")
		public String login() {
			return "login";
		}   
	 
	 
	 
	 
	 
}
