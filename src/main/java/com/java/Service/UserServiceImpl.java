package com.java.Service;

import com.java.Model.User;
import com.java.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    
    @Autowired
    UserRepository uRepository;
    
    @Override
    public void saveUserDetails(User user) {
        uRepository.save(user);
    }
    
    @Override
    public User findByUserPhoneNo(String userPhoneno,String userPass){
        User user=uRepository.findByUserPhoneNo(userPhoneno, userPass);
        return user;
    } 
    
    @Override
    public User getDetailsForCollaboration(String colAdmin){
        User user=uRepository.getDetailsForCollaboration(colAdmin);
        System.out.println(user);
        return user;
    }
}
