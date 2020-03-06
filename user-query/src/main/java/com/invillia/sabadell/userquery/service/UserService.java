package com.invillia.sabadell.userquery.service;

import com.invillia.sabadell.userquery.exception.UserNotFoundException;
import com.invillia.sabadell.userquery.model.User;
import com.invillia.sabadell.userquery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User get(Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> getAll() {
        return repository.findAll();
    }
}
