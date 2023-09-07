
package com.amdocs.employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.amdocs.employee.Entity.Book;
import com.amdocs.employee.Exceptions.bookNotFound;
import com.amdocs.employee.Repository.*;

@Service
public class BookService {
	@Autowired
    //BookRepo bookRepo;
	BookDBRepo bookRepo;  //bookdbrepo interface is injected by spring here  
	public List<Book>findAll(Pageable pageable){
		return bookRepo.findAll(pageable).toList();//ll commented things were there when we used collection repo 
                   //instead of database  
	}        
	
	public Book findById(long id) {
		Optional<Book> b = bookRepo.findById(id);
	return b.orElseThrow(()->new bookNotFound("Book Not Found"+id));
		//return bookRepo.findById(id);
	
	}
	public Book addBook(Book b) {
		return bookRepo.save(b);
		//return bookRepo.addBook(b);
	}
	
	public Book updateBook(long id, Book b) {
		Book book1 = findById(id);
		book1.setAuthor(b.getAuthor());
		book1.setTitle(b.getTitle());
		book1.setPublished(b.isPublished());
		bookRepo.save(b);
		return book1;
		//return bookRepo.updateBook(id, b);
	}
	public void deleteBook(long id) {
		Book b = findById(id);
		bookRepo.delete(b);
		//bookRepo.deleteById(id);
		//bookRepo.deleteBook(id);
	}

	

}