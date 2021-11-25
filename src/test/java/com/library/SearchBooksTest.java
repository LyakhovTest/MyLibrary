package com.library;

import com.library.entity.Book;
import com.library.services.BookService;
import com.library.services.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SearchBooksTest {
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
    public void testSearchBooksByTitlePart() throws ObjectNotFoundException {
        List<Book> books = bookService.getByTitlePart("Th");
        Assertions.assertThat(books.size()).isGreaterThan(0);
        System.out.println(books);
    }

    @Test
    public void testSearchBooksByDescriptionPart() throws ObjectNotFoundException {
        List<Book> books = bookService.getByDescriptionPart("eke");
        Assertions.assertThat(books.size()).isGreaterThan(0);
        System.out.println(books);
    }

    @Test
    public void testSearchBooksBeforeSomeYear() throws ObjectNotFoundException {
        List<Book> books = bookService.getByPublishDateBefore(2010);
        Assertions.assertThat(books.size()).isGreaterThan(0);
        System.out.println(books);
    }

    @Test
    public void testSearchBooksAfterSomeYear() throws ObjectNotFoundException {
        List<Book> books = bookService.getByPublishDateAfter(2015);
        Assertions.assertThat(books.size()).isGreaterThan(0);
        System.out.println(books);
    }

    @Test
    public void testSearchBooksYearsPeriod() throws ObjectNotFoundException {
        List<Book> books = bookService.getBooksByYearPeriod(2010, 2018);
        Assertions.assertThat(books.size()).isGreaterThan(0);
        System.out.println(books);
    }
}
