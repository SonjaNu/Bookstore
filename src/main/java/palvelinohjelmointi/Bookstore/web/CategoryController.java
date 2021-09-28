package palvelinohjelmointi.Bookstore.web;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import palvelinohjelmointi.Bookstore.domain.Category;

import palvelinohjelmointi.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	
	public String categoryList(Model model) {

	model.addAttribute("categories", categoryRepository.findAll()); 

return "categoryList";

}
	
	 @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	    public String save(@ModelAttribute Category category){
	        categoryRepository.save(category);
	        return "redirect:/categorylist";  //uudelleen ohjataan toiseen endpointtiin
	    } 
	
	 @RequestMapping(value = "/addcategory")
	    public String addCategory(Model model){
	    	model.addAttribute("category", new Category());
	        return "addCategory";
	    }   
}
