package com.sdgt.zuul.repository;

import com.sdgt.zuul.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);
}
