package com.itbacfrica.microservice;

import com.itbacfrica.microservice.model.Book;
import com.itbacfrica.microservice.repository.BookRepository;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

  @Inject BookRepository bookRepository;

  @Inject
  Logger logger;

  @GET
  public List<Book> getAllBooks() {
    logger.info("Return all the books");
    return bookRepository.getAllBooks();
  }

  @GET
  @Path("/count")
  @Produces(MediaType.TEXT_PLAIN)
  public int countAllBooks() {
    logger.info("Return  the number of books");
    return bookRepository.countAllBooks();
  }

  @GET
  @Path("{id}")
  public Optional<Book> getbookById(@PathParam("id") int id) {
    logger.info("Return a single book with the id "+ id);
    return bookRepository.getbookById(id);
  }
}
