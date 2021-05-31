package com.java.Service;

import com.java.Model.CollaborationDetails;
import java.util.Date;
import java.util.List;

public interface CollaborationDetailsService {
 
    List<CollaborationDetails> showCollaborationDetails();
    
    void insertQuery(String colAdmin, int a,String colDescription,String colName, String b,Date creationDate,int value);
    
    String getTeamCapacity(String teamname);
    
}