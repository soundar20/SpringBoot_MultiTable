package com.java.Service;

import com.java.Model.User;
import com.java.Repo.UserRepository;
import com.java.dto.SingleUserDto;
import java.util.List;
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
    public List<SingleUserDto> getCombinedUser(int id){
        List<SingleUserDto> suDTO=uRepository.getCombinedUser(id);
        return suDTO;
    }
    
    
}
