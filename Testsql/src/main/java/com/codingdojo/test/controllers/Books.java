package com.codingdojo.test.controllers;


import java.util.ArrayList;


import javax.validation.Valid;

import com.codingdojo.test.models.Book;
import com.codingdojo.test.service.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Books {
	private final BookService bookService;
    public Books(BookService bookService){
        this.bookService = bookService;
    }
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
    	return "newBook";
    }
    @RequestMapping("/books")
    public String books(Model model) {
        ArrayList<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "books";
    }
    
    @PostMapping("/books/new")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
    	if(result.hasErrors()) {
    		return "newBook";
    	}else {
    		bookService.addBook(book);
    		return "redirect:/books";
    	}
    }
    @RequestMapping("/books/edit/edit/{id}")
    public String editBook(@PathVariable("id") Long id,Model model) {
    	Book book = bookService.findBookById(id);
    	if(book != null) {
    		model.addAttribute("book", book);
    		return "editBook";
    	}else {
    		return "redirect:/books";
    	}
    }
    @RequestMapping("/books/{index}")
    public String findBookByIndex(Model model, @PathVariable("index") Long index) {
        Book book = bookService.findBookById(index);
        model.addAttribute("book", book);
        return "showBook";
    }
    @RequestMapping(value="/books/delete/{id}")
    public String destroyBook(@PathVariable("id") Long id) {
        bookService.destroyBook(id);
        return "redirect:/books";
    }
    
    @PostMapping("/books/edit/{id}")
    public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "editBook.jsp";
        }else{
            bookService.updateBook(book);
            return "redirect:/books";
        }
   
    }

}
