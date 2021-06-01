package com.java.Repo;

import com.java.Model.CollaborationDetails;
import com.java.dto.CollaborationDetailsDTO;
import java.util.Date;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CollaborationDetailsRepository extends CrudRepository<CollaborationDetails,Integer>{
   
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO collaboration_details VALUES (null,?1,?2,?3,?4,?5,?6,?7)",nativeQuery = true)
    public void insertQuery(String coladmin, int a,String coldescription,String colname, String b,Date creationdate,int value);

    @Query(value="SELECT team_capacity FROM collaboration_details where col_name=?1 ;",nativeQuery = true)
    public String getTeamCapacity(String teamname);
    
    @Query("SELECT new com.java.dto.CollaborationDetailsDTO(u.userId,u.userName) from User as u where u.userEmail=?1")
    public CollaborationDetailsDTO getDetailsForCollaboration(String coladmin);
    
    @Query(value="SELECT col_admin FROM collaboration_details where col_admin=?1 and col_name=?2",nativeQuery = true)
    public String colAdminOwner(String mail, String teamname);
    
    @Query(value="SELECT col_name FROM collaboration_details where col_admin=?1 and col_name=?2",nativeQuery = true)
    public String colAdminTeamName(String mail, String teamname);
    
    @Modifying
    @Transactional
    @Query("update CollaborationDetails set teamCapacity=teamCapacity+1 where colName=?1")
    public void increaseTeamCapacity(String teamname);

}
