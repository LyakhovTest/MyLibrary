package com.library.repository;

import com.library.entity.Book;
import com.library.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    Optional<Book> findBookByTitleEquals(String title);

    List<Book> findBooksByTitleContains(String title);

    List<Book> findBooksByDescriptionContains(String description);

    List<Book> findBooksByPublishDateBefore(Integer maxYear);

    List<Book> findBooksByPublishDateAfter(Integer minYear);

    List<Book> findBooksByPublishDateBetween(Integer minYear,Integer maxYear);
}
