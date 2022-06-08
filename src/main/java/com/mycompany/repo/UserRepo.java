package com.mycompany.repo;

import com.mycompany.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer>{
    public Long countById(Integer id);

}
