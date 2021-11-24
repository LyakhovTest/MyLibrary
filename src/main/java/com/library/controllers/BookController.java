package com.library.controllers;

import com.library.UserNotFoundException;
import com.library.entity.Book;
import com.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/books")
    public String showBookList(Model model){
        List<Book> listBook = service.listAll();
        model.addAttribute("listBooks", listBook);
        return "book/books";
    }

    @GetMapping("books/new")
    public String showNewForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("pageTitle", "Add New Book");
        return "book/book_form";
    }

    @PostMapping("/books/save")
    public String saveBook(Book book){
        service.save(book);

        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model){
        try {
            Book book = service.get(id);
            model.addAttribute("book", book);
            model.addAttribute("pageTitle", "Edit Book (ID: "+id+")");
            return "book/book_form";
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return "redirect:/books";
        }
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id")Integer id){
        service.delete(id);
        return "redirect:/books";
    }

}
