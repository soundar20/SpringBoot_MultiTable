package com.java.Service;

import com.java.Model.User;
public interface UserService {

    void saveUserDetails(User user);
    User findByUserPhoneNo(String userPhoneno,String userPass);
    
    
    
    
}
