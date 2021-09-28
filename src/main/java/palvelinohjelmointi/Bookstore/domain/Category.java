package palvelinohjelmointi.Bookstore.domain;

import javax.persistence.Entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import palvelinohjelmointi.Bookstore.domain.Book;



@Entity
public class Category {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
		private Long categoryId;
		private String name;
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
		private List<Book> books;
		
		
public Category() {}


public Category(String name) {
	super();
	this.name = name;
}


public Long getCategoryId() {
	return categoryId;
}


public void setCategoryId(Long categoryId) {
	this.categoryId = categoryId;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}

public List<Book> getBooks() {
	return books;
}

public void setStudents(List<Book> books) {
	this.books = books;
}


@Override
public String toString() {
	return "Category [categoryId=" + categoryId + ", name=" + name + "]";
}
}
