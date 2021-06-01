package com.java.Service;

import com.java.Model.CollaborationDetails;
import com.java.Repo.CollaborationDetailsRepository;
import com.java.Repo.UserRepository;
import com.java.dto.CollaborationDetailsDTO;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class CollaborationDetailsServiceImpl implements CollaborationDetailsService{
 
    @Autowired
    CollaborationDetailsRepository cdRepository;
    
    @Autowired
    UserRepository uRepository;
    
    @Override
    public List<CollaborationDetails> showCollaborationDetails() {
        System.out.println((List<CollaborationDetails>) cdRepository.findAll());
        return (List<CollaborationDetails>) cdRepository.findAll();
    }
    
    @Override
    public CollaborationDetailsDTO getDetailsForCollaboration(String colAdmin){
        CollaborationDetailsDTO user=cdRepository.getDetailsForCollaboration(colAdmin);
        System.out.println(user);
        return user;
    }
        
    @Override
    public void insertQuery(String colAdmin, int a,String colDescription,String colName, String b,Date creationDate,int value){
        cdRepository.insertQuery(colAdmin, a, colDescription, colName, b, creationDate, value);
    }
    
    @Override
    public String getTeamCapacity(String teamname){
        String cd=cdRepository.getTeamCapacity(teamname);
        return cd;
    }
    
    @Override
    public String colAdminOwner(String mail, String teamname){
        String cd=cdRepository.colAdminOwner(mail, teamname);
        return cd;
    }
    
    @Override
    public String colAdminTeamName(String mail, String teamname){
        String cd=cdRepository.colAdminTeamName(mail, teamname);
        return cd;
    }
    
    @Override
    public void increaseTeamCapacity(String teamname){
        cdRepository.increaseTeamCapacity(teamname);
    }
    
}
