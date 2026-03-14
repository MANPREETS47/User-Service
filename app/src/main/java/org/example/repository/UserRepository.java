package org.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.example.entities.UserInfo;


@Repository
public interface UserRepository extends CrudRepository<UserInfo, String>{

    UserInfo findByUserId(String userId);
    
}
