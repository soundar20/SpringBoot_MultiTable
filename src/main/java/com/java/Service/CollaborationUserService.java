package com.java.Service;

import com.java.Model.CollaborationUser;
import java.util.List;

public interface CollaborationUserService {
    
    String checkUserEmail(String mail,String teamname);
    void saveColUser(CollaborationUser coluser);
    String checkUserTeam(String mail,String teamname);
    List<CollaborationUser> showCollUser();
}
