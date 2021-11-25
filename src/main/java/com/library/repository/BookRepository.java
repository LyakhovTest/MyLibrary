package com.library.repository;

import com.library.entity.Book;
import com.library.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findAllByUser(User user);

    Optional<Book> findBookByDescriptionContains(String description);

    Optional<Book> findBookByTitleContains(String title);

}
