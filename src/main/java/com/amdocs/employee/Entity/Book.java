package com.amdocs.employee.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor

@Entity
@Table(name="Book_Details")   //name of table if not provided then table name is class name
public class Book {
	
	@Id   //primary key of table
	@GeneratedValue(strategy = GenerationType.IDENTITY)//AUTOINCREMENT PK
	long id;
	@Column(nullable = false,unique = true)  //to make title unique and null not acceptable
	@NotEmpty(message= "Title can't be empty")
	@Size(min =3, message ="Title length should atleast be 3")
	String title;
	String author;
	@Column(name = "publish")   //explicitly giving the name of the column
	boolean published;
	public Book(long id, String title, String author, boolean published) {
		
		this.id = id;
		this.title = title;
		this.author = author;
		this.published = published;
	}
	public long getId() {
		return id;
	}
	
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", published=" + published + "]";
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	public Book() {

	}
	

}
