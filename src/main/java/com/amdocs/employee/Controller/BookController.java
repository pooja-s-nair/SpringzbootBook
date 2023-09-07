
package com.amdocs.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.employee.Entity.Book;
import com.amdocs.employee.Service.BookService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

//import Entity.Book;
//import Service.BookService;

@RestController
@RequestMapping("/api/v1/books")//Common uri for all requests
public class BookController {
	@Autowired
	BookService service;
	//response entity contains response body+header+ status code
	@GetMapping
	public ResponseEntity<List<Book>>getAllBooks(Pageable pageable){//size =1 meaning only 1 data printed page =1 means 2nd page page=0 means 1st page
		return new ResponseEntity<List<Book>>(service.findAll(pageable),HttpStatus.OK);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book>findById(@PathVariable long id){
		return new ResponseEntity<Book>(service.findById(id),HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Book>addBook(@RequestBody Book book){
		//System.out.println(book);
		return new ResponseEntity<Book>(service.addBook(book),HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Book>updateBook(@PathVariable long id,@RequestBody Book b){
		//System.out.println(b);
		return new ResponseEntity<Book>(service.updateBook(id,b),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Book>deleteBook(@PathVariable long id){
		service.deleteBook(id);
		return new ResponseEntity(HttpStatus.OK);
	}

}

