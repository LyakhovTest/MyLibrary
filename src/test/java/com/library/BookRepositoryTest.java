package com.library;

import com.library.entity.Book;
import com.library.entity.User;
import com.library.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class BookRepositoryTest {
    @Autowired
    private BookRepository repo;

    @Test
    public void testAddNew(){
        Book book = new Book();
        book.setTitle("Философия Java");
        book.setDescription("asuvgajshdb");
        book.setPublishDate(2007);

        //book.holder

        Book savedBook = repo.save(book);

        Assertions.assertThat(savedBook).isNotNull();
        Assertions.assertThat(savedBook.getId()).isGreaterThan(0);
    }
}
