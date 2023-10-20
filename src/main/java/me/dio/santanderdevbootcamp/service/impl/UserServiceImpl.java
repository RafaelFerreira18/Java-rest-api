package me.dio.santanderdevbootcamp.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.santanderdevbootcamp.Model.User;
import me.dio.santanderdevbootcamp.repository.UserRepository;
import me.dio.santanderdevbootcamp.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This account number already exists");
        }
        return this.userRepository.save(userToCreate);
    }
    
}