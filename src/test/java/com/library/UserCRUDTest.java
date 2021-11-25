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

@Rollback(value = true)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserCRUDTest {
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
    public void testAddNew(){
        User user = new User();
        user.setEmail("TestAlex.jogas@gmail.com");
        user.setFirstName("Alex");
        user.setLastName("Jogas");
        user.setPatronymic("alex123");

        userService.save(user);
        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    public void testGet() throws ObjectNotFoundException {
        Integer userId = 1;
        User user = userService.get(userId);
        Assertions.assertThat(user).isNotNull();
        System.out.println(user);
    }

    @Test
    public void testListAll(){
        Iterable<User> users = userService.listAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for(User user: users){
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate() throws ObjectNotFoundException {
        Integer userId = 1;
        Integer bookId = 1;
        User user = userService.get(userId);
        System.out.println(user);
        user.setFirstName("TestUpdateName");
        user.setLastName("TestUpdateName");
        user.setPatronymic("TestUpdatePatronymic");
        Book book = bookService.get(bookId);
        user.getBooks().remove(book);
        userService.save(user);


        User updateUser = userService.get(userId);
        System.out.println(updateUser);
        Assertions.assertThat(updateUser.getPatronymic()).isEqualTo("TestUpdatePatronymic");
    }

    @Test
    public void testDeleteUser() throws ObjectNotFoundException {
        Integer userId = 1;
        userService.delete(userId);
        try {
            User user = userService.get(userId);
            System.out.println(user.getFirstName()+" survived!");
        } catch (ObjectNotFoundException e) {
            System.out.println("The user has been successfully deleted!");
        }
    }
}
