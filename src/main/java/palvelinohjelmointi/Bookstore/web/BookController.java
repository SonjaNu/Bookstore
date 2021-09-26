package palvelinohjelmointi.Bookstore.web;

/*We will now start to create our training project. This excercise continues through the whole course 
and it will be returned to Github.  
  
a.)  Create a project called Bookstore by using Spring Initializr page (include web, devtools)  
b.)  Add a new controller called BookController which handle get request to the path /index  
c.)  Add a new model class called Book which contains attributes: title, author, year, isbn, price  
d.)  Add your project to your GitHub account (See the instructions from the moodle) */


import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import palvelinohjelmointi.Bookstore.domain.Book;
import palvelinohjelmointi.Bookstore.domain.BookRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository; //privaatti BookRepository nimeltään repository
	
	//endpoint    http://localhost:8080/
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
		
		public String bookList(Model model) {
	
		model.addAttribute("books", repository.findAll()); 
	
	return "bookListTemplate";
	
	}
	
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(@ModelAttribute Book book){
	        repository.save(book);
	        return "redirect:/booklist";  //uudelleen ohjataan toiseen endpointtiin
	    } 
	
	 @RequestMapping(value = "/add")
	    public String addBook(Model model){
	    	model.addAttribute("book", new Book());
	        return "addBook";
	    }   
	 
	
	 
	 @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	 public String editBook(@PathVariable("id") long bookId, Model model) {
	     model.addAttribute("book", repository.findById(bookId).get());
	     return "editbook";
	 }	
	 
	 //jos kirjan id on 0 tai null, se tekee sql insertin, muuten se tekee sql updaten
	 //
	 
	 
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
	    	repository.deleteById(bookId);
	        return "redirect:../booklist";
	    }    
	 
	 
	 
	 
	 
	 
	 //Ei toimi...
//	 @PostMapping(value = "/edit/{id}")
//	    public String editBook(@PathVariable("id") Long bookId, @Validated Book book, BindingResult result,  Model model){
//		 
//		 if (result.hasErrors()) {
//         book.setId(bookId);
//	         return "editBook";
//	     }
//		 
//		 repository.save(book);
//		 return "redirect:/booklist";
//	    
//	    } 
//	 
	 
	

	 
	 
	
	 
	 
//	 @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//	    public String editBook(@PathVariable("id") Long bookId, Model model){
//		 //	repository.deleteById(bookId);   //Ei onnistu, että ensin poistaisi ja loisi samantien uuden
//	    	//model.addAttribute("book", new Book());
//	        return "editBook";
//	    } 
	 
	 
}
