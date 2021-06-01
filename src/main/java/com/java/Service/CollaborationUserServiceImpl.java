package com.java.Service;

import com.java.Model.CollaborationUser;
import com.java.Repo.CollaborationDetailsRepository;
import com.java.Repo.CollaborationUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CollaborationUserServiceImpl implements CollaborationUserService{
    
    @Autowired
    CollaborationUserRepository cuRepository;
    
    @Autowired
    CollaborationDetailsRepository cdRepository;
    
    @Override
    public String checkUserEmail(String mail,String teamname){
        String cd=cuRepository.getUserCollMail(mail, teamname);
        return cd;
    }
    
    @Override
    public String checkUserTeam(String mail,String teamname){
        String cd=cuRepository.checkUserTeam(mail, teamname);
        return cd;
    }
    
    @Override
    public void saveColUser(CollaborationUser coluser){
        cuRepository.save(coluser);
    }
    
    @Override
    public List<CollaborationUser> showCollUser(){
        System.out.println((List<CollaborationUser>)cuRepository.findAll());
        return (List<CollaborationUser>)cuRepository.findAll();
    }
           
}
