package com.library.services;

import com.library.ObjectNotFoundException;
import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book get(Integer id) throws ObjectNotFoundException {
        Optional<Book> result = bookRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new ObjectNotFoundException("Could not find book with ID "+id);
    }

    public Book getByTitle(String title) throws ObjectNotFoundException {
        Optional<Book> result = bookRepository.findBookByTitleEquals(title);
        if(result.isPresent()){
            return result.get();
        }
        throw new ObjectNotFoundException("Could not find any users with ID "+ title);
    }

    public List<Book> getByTitlePart(String title) throws ObjectNotFoundException {
        List<Book> result = bookRepository.findBooksByTitleContains(title);
        if(result!=null){
            return result;
        }
        throw new ObjectNotFoundException("Could not find any Book with this title:  "+ title);
    }

    public List<Book> getByDescriptionPart(String description) throws ObjectNotFoundException {
        List<Book> result = bookRepository.findBooksByDescriptionContains(description);
        if(result!=null){
            return result;
        }
        throw new ObjectNotFoundException("Could not find any Book with this description:  "+ description);
    }

    public List<Book> getByPublishDateBefore(Integer maxYear) throws ObjectNotFoundException {
        List<Book> result = bookRepository.findBooksByPublishDateBefore(maxYear);
        if(result!=null){
            return result;
        }
        throw new ObjectNotFoundException("Could not find any Book with publish date before:  "+ maxYear);
    }

    public List<Book> getByPublishDateAfter(int minYear) throws ObjectNotFoundException {
        List<Book> result = bookRepository.findBooksByPublishDateAfter(minYear);
        if(result!=null){
            return result;
        }
        throw new ObjectNotFoundException("Could not find any Book with publish date after:  "+ minYear);
    }

    public List<Book> getBooksByYearPeriod(int minYear, int maxYear) throws ObjectNotFoundException {
        List<Book> result = bookRepository.findBooksByPublishDateBetween(minYear, maxYear);
        if(result!=null){
            return result;
        }
        throw new ObjectNotFoundException("Could not find any Book in period from "+ minYear+" to "+ maxYear);
    }

    public void save(Book book) {
        bookRepository.save(book);
    }


    public List<Book> listAll(){
        return (List<Book>) bookRepository.findAll();
    }

    public void delete(Integer id) throws ObjectNotFoundException {
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        }else{
            throw new ObjectNotFoundException("Could not find book with ID "+id);
        }
    }
}
