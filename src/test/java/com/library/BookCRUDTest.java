package com.library;

import com.library.entity.Book;
import com.library.entity.User;
import com.library.services.BookService;
import com.library.services.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookCRUDTest {
    @TestConfiguration
    static class ServiceImplTestContextConfiguration {
        @Bean
        public UserService userService() {
            return new UserService();
        }
        @Bean
        public BookService bookService() {
            return new BookService();
        }
    }

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;


    @Test
    public void testAddNewBook() throws ObjectNotFoundException {
        Book book = new Book();
        book.setTitle("Thi");
        book.setDescription("brus ekel");
        book.setPublishDate(2017);
        bookService.save(book);

        Book updateBook = bookService.getByTitle("Thi");
        Assertions.assertThat(updateBook).isNotNull();
        Assertions.assertThat(updateBook.getId()).isGreaterThan(0);
    }

    @Test
    public void testGetBook() throws ObjectNotFoundException {
        Integer userId = 1;
        Book book = bookService.get(userId);
        Assertions.assertThat(book).isNotNull();
        System.out.println(book);
    }

    @Test
    public void testListAllBook(){
        Iterable<Book> books = bookService.listAll();
        Assertions.assertThat(books).hasSizeGreaterThan(0);

        for(Book book: books){
            System.out.println(book);
        }
    }

    @Test
    @Rollback(value = true)
    public void testUpdateBook() throws ObjectNotFoundException {
        Integer bookId = 1;
        Book book = bookService.get(bookId);
        System.out.println(book);
        book.setDescription("TestUpdateDescription");
        book.setTitle("TestUpdateTitle");
        book.setPublishDate(2005);

        Integer userId = 7;
        User user = userService.get(userId);
        book.setUser(user);

        bookService.save(book);

        Book updateBook = bookService.get(bookId);
        System.out.println(updateBook);
        Assertions.assertThat(updateBook.getTitle()).isEqualTo("TestUpdateTitle");
    }

    @Test
    @Rollback(value = true)
    public void testDeleteBook() throws ObjectNotFoundException {
        Integer bookId = 1;
        bookService.delete(bookId);
        try {
            Book book = bookService.get(bookId);
            System.out.println(book.getTitle()+" is still in the library!");
        } catch (ObjectNotFoundException e) {
            System.out.println("Book successfully deleted!");
        }
    }
}
