package com.library.services;

import com.library.entity.User;
import com.library.repository.UserRepository;
import com.library.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterf{
    @Autowired
    private UserRepository repo;

    //public List<User> listAll(){
//        return (List<User>) repo.findAll();
//    }

    public void save(User user) {
        repo.save(user);
    }

//    public User get(Integer id) throws UserNotFoundException {
//        Optional<User> result = repo.findById(id);
//        if(result.isPresent()){
//            return result.get();
//        }
//       throw new UserNotFoundException("Could not find any users with ID "+id);
//    }
//
//    public void delete(Integer id){
//        repo.deleteById(id);
//    }
}
