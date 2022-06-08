package com.mycompany.service;

import com.mycompany.entity.User;
import com.mycompany.repo.UserRepo;
import com.mycompany.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }

    public void saveUser(User user){
        repo.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Could not find any id with" + id);

    }
    public void deleteUser(Integer id) throws UserNotFoundException {
        Long count = repo.countById(id);

        if(count==null|| count==0){
            throw new UserNotFoundException("Could not find any id with" + id);
        }
        repo.deleteById(id);
    }
}
