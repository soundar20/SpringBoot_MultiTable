package com.java.Repo;

import com.java.Model.CollaborationUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaborationUserRepository extends CrudRepository<CollaborationUser,Integer> {
    
    @Query(value="SELECT user_coll_mail FROM collaboration_user WHERE user_coll_mail=?1 AND coll_team_name=?2",nativeQuery = true)
    public String getUserCollMail(String usercollmail,String collteamname);
    
    @Query(value="SELECT coll_team_name FROM collaboration_user WHERE user_coll_mail=?1 AND coll_team_name=?2",nativeQuery = true)
    public String checkUserTeam(String usercollmail,String collteamname);
}
