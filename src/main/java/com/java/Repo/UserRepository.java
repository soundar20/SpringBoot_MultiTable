package com.java.Repo;

import com.java.Model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
    
    @Query(value="SELECT * FROM user WHERE (user_email=?1 or user_phoneno=?1) AND user_pass=?2",nativeQuery = true)
    public User findByUserPhoneNo(String userPhoneno,String userPass);
    
    @Modifying
    @Transactional
    @Query("update User set userPass=?1 where userEmail=?1")
    public User getDetailsForCollaboration(String coladmin);
}
