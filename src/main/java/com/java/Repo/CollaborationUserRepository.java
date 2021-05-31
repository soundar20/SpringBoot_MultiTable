package com.java.Repo;

import com.java.Model.CollaborationUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaborationUserRepository extends CrudRepository<CollaborationUser,Integer> {
    
}
