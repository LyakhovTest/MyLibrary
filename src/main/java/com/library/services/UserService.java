package com.library.services;

import com.library.ObjectNotFoundException;
import com.library.entity.User;
import com.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;


    public List<User> listAll(){
        return (List<User>) userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User get(Integer id) throws ObjectNotFoundException {
        Optional<User> result = userRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
       throw new ObjectNotFoundException("Could not find any users with ID "+id);
    }

    public void delete(Integer id) throws ObjectNotFoundException {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }else{
            throw new ObjectNotFoundException("Could not find any users with ID "+id);
        }
    }
}
