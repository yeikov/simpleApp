package com.jmfrei.simpleApp;

import org.springframework.data.repository.CrudRepository;

import com.jmfrei.simpleApp.User;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<User, Long> {

}
