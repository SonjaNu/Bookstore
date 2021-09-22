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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import palvelinohjelmointi.Bookstore.domain.Book;
import palvelinohjelmointi.Bookstore.domain.BookRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository; //privaatti BookRepository nimeltään repository
	
	//endpoint    http://localhost:8080/
	
	@RequestMapping(value = "/booklist")
		
		public String bookList(Model model) {
	
		model.addAttribute("books", repository.findAll()); 
	
	return "bookListTemplate";
	
	}
}
	
	
		
		
	
	
	

