package com.library;

import com.library.entity.Book;
import com.library.entity.User;
import com.library.repository.BookRepository;
import com.library.repository.UserRepository;
import com.library.services.BookService;
import com.library.services.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
//    @Autowired
//    private UserRepository repo;
//    @Autowired
//    private BookRepository bookRepository;

//    @Autowired
//    private BookService ser;
    @Autowired
    private UserService userService;

    @Test
    public void testAddNew(){
        User user = new User();
        user.setEmail("TestAlex.jogas@gmail.com");
        user.setFirstName("Alex");
        user.setLastName("Jogas");
        user.setPatronymic("alex123");

        //User savedUser = repo.save(user);
        userService.save(user);
//        Assertions.assertThat(savedUser).isNotNull();
//        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

   // @Test
//    public void testUpdate() throws UserNotFoundException {
//        Integer userId = 1;
//        Optional<User> optionalUser = repo.findById(userId);
//        User user = optionalUser.get();
//        user.setBooks(bookRepository.findAllByUser(user));
//
//        repo.save(user);
//
//        System.out.println(repo.findById(userId).get());
//    }



//    @Test
//    public void testAddNew() throws UserNotFoundException {
//        User user = new User();
//        user.setEmail("Alex.jogas@gmail.com");
//        user.setFirstName("Alex");
//        user.setLastName("Jogas");
//        user.setPatronymic("alex123");
//
//        user.addBook(ser.get(2));
//
//        User savedUser = repo.save(user);
//
//        Assertions.assertThat(savedUser).isNotNull();
//        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    public void testListAll(){
//        Iterable<User> users = repo.findAll();
//        Assertions.assertThat(users).hasSizeGreaterThan(0);
//
//        for(User user: users){
//            System.out.println(user);
//        }
//    }
//
//    @Test
//    public void testUpdate(){
//        Integer userId = 1;
//        Optional<User> optionalUser = repo.findById(userId);
//        User user = optionalUser.get();
//        user.setPatronymic("TestPatronymic");
//        repo.save(user);
//
//        User updateUser = repo.findById(userId).get();
//        Assertions.assertThat(updateUser.getPatronymic()).isEqualTo("TestPatronymic");
//    }
//
//    @Test
//    public void testGet(){
//        Integer userId = 2;
//        Optional<User> optionalUser = repo.findById(userId);
//        Assertions.assertThat(optionalUser).isPresent();
//        System.out.println(optionalUser.get());
//    }
//
//    @Test
//    public void testDelete(){
//        Integer userId = 2;
//        repo.deleteById(userId);
//
//        Optional<User> optionalUsers = repo.findById(userId);
//        Assertions.assertThat(optionalUsers).isNotPresent();
//    }
}
