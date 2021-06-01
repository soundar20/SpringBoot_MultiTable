package com.java.Service;

import com.java.Model.User;
import com.java.dto.SingleUserDto;
import java.util.List;
public interface UserService {

    void saveUserDetails(User user);
    
    User findByUserPhoneNo(String userPhoneno,String userPass);
    
    List<SingleUserDto> getCombinedUser(int id);
    
    
}
