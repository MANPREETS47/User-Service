package org.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.example.entities.UserInfo;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<UserInfo, Long>{

    Optional<UserInfo> findByUserId(String userId);
    
}
