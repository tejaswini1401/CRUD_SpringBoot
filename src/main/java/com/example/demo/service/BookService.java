package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bookRepository.BookRepository;
import com.example.demo.model.Book;

//import java.util.Optional;

@Service
public class BookService {

	 @Autowired
	    private BookRepository bookRepository;

	    // GET book by title
	    @GetMapping("/books")
	    public ResponseEntity<Book> getBookByTitle(@RequestParam String title) {
	        Book book = bookRepository.findByTitle(title);
	        
	        if (book != null) {
	            return ResponseEntity.ok(book);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }
}