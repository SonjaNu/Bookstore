package palvelinohjelmointi.Bookstore.web;

/*We will now start to create our training project. This excercise continues through the whole course 
and it will be returned to Github.  
  
a.)  Create a project called Bookstore by using Spring Initializr page (include web, devtools)  
b.)  Add a new controller called BookController which handle get request to the path /index  
c.)  Add a new model class called Book which contains attributes: title, author, year, isbn, price  
d.)  Add your project to your GitHub account (See the instructions from the moodle) */

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import palvelinohjelmointi.Bookstore.domain.Book;


@Controller
public class BookController {
	
	//endpoint    http://localhost:8080/index
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	
	public String getStudentList(Model model) { 
		
		List<Book> books = new ArrayList<Book>(); 
		books.add(new Book("Mihin tytöt kadonneet", "Leena Lehtolainen", 2001, "123kk89", 15.90));
		books.add(new Book("Kyllikki Saari", "Teemu Keskisarja", 2021, "987hh67", 20.90));
		

		model.addAttribute("books", books); 
		
		return "bookListTemplate";
	
	
	}
}
