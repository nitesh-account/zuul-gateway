package com.sdgt.zuul.repository;

import com.sdgt.zuul.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {

	Role findByRole(String role);
}
