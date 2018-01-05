package com.codingdojo.test.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import org.springframework.stereotype.Service;
import com.codingdojo.test.models.Book;
import com.codingdojo.test.repositories.BookRepository;
@Service
public class BookService {
	 Date d = new Date();
	
	DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	private BookRepository bookRepository;
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	private ArrayList<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309,d,d),
            new Book("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180,d,d),
            new Book("Moby Dick", "The saga of Captain Ahab", "english", 544,d,d),
            new Book("Don Quixote", "Life of a retired country gentleman", "english", 150,d,d),
            new Book("The Odyssey", "Ancient Greek epic poem", "english", 475,  d,d)
            ));
    
    // returns all the books
    public ArrayList<Book> allBooks() {
        return (ArrayList<Book>) bookRepository.findAll();
    }
    
    public void addBook(Book book) {
    	bookRepository.save(book);
    }
    public Book findBookById(Long index) {
       // if (index < books.size()){
         //   return books.get(index);
       // }else{
       //     return null;
       // }
    	return bookRepository.findOne(index);
    }
    public void destroyBook(Long id) {
    	bookRepository.delete(id);
    }
   
    
    
        public void updateBook(Book book) {
           bookRepository.save(book);
        }
        
       


}
