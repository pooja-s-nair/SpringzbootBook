

package com.amdocs.employee.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.amdocs.employee.Entity.Book;

import com.amdocs.employee.Exceptions.bookNotFound;



@Repository
//we are not using this class instead interface
public class BookRepo {
List<Book>books = new ArrayList<>();
	
	public BookRepo(){
		books.add(new Book (1,"Java ","pattrick" ,true));
		books.add(new Book (2,"C ","Dennis" ,true));
		books.add(new Book (3,"python ","james" ,false));
	}
	public List<Book>findAll(){
		return books;
	}
	
	public Book findById(long id) {
	 Optional<Book> b = books.stream()
				.filter((b1)->b1.getId()==id)
				.findAny();
	return b.orElseThrow(()->new bookNotFound("Book Not Found"+id));
		
	}
	
	public Book addBook(Book book) {
		books.add(book);
		return book;
	}
	
	public Book updateBook(long id, Book book)
	{
		Book book1 = findById(id);
		book1.setAuthor(book.getAuthor());
		book1.setTitle(book.getTitle());
		book1.setPublished(book.isPublished());
		return book1;
	}
	
	public void deleteBook(long id) {
		Book book1 = findById(id);
		books.remove(book1);
	}
}

