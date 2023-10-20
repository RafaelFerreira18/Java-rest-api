package me.dio.santanderdevbootcamp.service;

import me.dio.santanderdevbootcamp.Model.User;

public interface UserService {
    User findById(long id);

    User create(User userToCreate);
    
}