package com.java.Service;

import com.java.Model.CollaborationDetails;
import com.java.Repo.CollaborationDetailsRepository;
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
    
    @Override
    public List<CollaborationDetails> showCollaborationDetails() {
        return (List<CollaborationDetails>) cdRepository.findAll();
    }
        
    @Override
    public void insertQuery(String colAdmin, int a,String colDescription,String colName, String b,Date creationDate,int value){
        
    }
    
    @Override
    public String getTeamCapacity(String teamname){
        String cd=cdRepository.getTeamCapacity(teamname);
        return cd;
    }
    
}
