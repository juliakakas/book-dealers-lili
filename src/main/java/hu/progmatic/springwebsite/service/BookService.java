package hu.progmatic.springwebsite.service;

import hu.progmatic.springwebsite.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    private final Random randomGenerator;

    @Autowired
    public BookService(Random randomGenerator) {
        this.randomGenerator = randomGenerator;
        // Példaadatokkal feltötjük - a jövőben ez nem így fog kinézni:)
        books.add(new Book("The Lord of The Rings", "J. R. R. Tolkien"));
        books.add(new Book("The Two Towers", "J. R. R. Tolkien"));
        books.add(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("Pride and Prejudice", "Jane Austen"));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book getRandomBook(){
        return  books.get(randomGenerator.nextInt(this.books.size()));
    }


}