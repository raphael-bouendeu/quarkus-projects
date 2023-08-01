package com.itbacfrica.microservice.repository;

import com.itbacfrica.microservice.model.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.PathParam;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

  public List<Book> getAllBooks() {
    return Arrays.asList(
        new Book(1, "Understanding Quarkus", "Antonio", 2020, "IT"),
        new Book(2, "Practicing Quarkus", "Antonio", 2020, "IT"));
  }

  public int countAllBooks() {
    return getAllBooks().size();
  }

  public Optional<Book> getbookById(@PathParam("id") int id) {
    return getAllBooks().stream().filter(book -> book.getId() == id).findFirst();
  }
}
