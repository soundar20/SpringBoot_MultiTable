package com.java.Service;

import com.java.Model.CollaborationDetails;
import com.java.dto.CollaborationDetailsDTO;
import java.util.Date;
import java.util.List;

public interface CollaborationDetailsService {
 
    List<CollaborationDetails> showCollaborationDetails();
    
    void insertQuery(String colAdmin, int a,String colDescription,String colName, String b,Date creationDate,int value);
    
    String getTeamCapacity(String teamname);
    
    CollaborationDetailsDTO getDetailsForCollaboration(String colAdmin);
    
    String colAdminOwner(String mail, String teamname);
    
    String colAdminTeamName(String mail, String teamname);
    
    void increaseTeamCapacity(String teamname);
    
}