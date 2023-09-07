package com.amdocs.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amdocs.employee.Entity.Book;

public interface BookDBRepo extends JpaRepository<Book, Long>{ //name of entity class(book),object class

}
