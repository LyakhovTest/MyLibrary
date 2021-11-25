package com.library.repository;

import com.library.entity.Book;
import com.library.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
