package com.library.services;

import com.library.UserNotFoundException;
import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repo;

    public List<Book> listAll(){
        return (List<Book>) repo.findAll();
    }

    public void save(Book book) {
        repo.save(book);
    }

    public Book get(Integer id) throws UserNotFoundException {
        Optional<Book> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Could not find any users with ID "+id);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }
}
