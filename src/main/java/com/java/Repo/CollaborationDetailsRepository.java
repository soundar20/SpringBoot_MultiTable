package com.java.Repo;

import com.java.Model.CollaborationDetails;
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

    @Query(value="SELECT teamcapacity FROM collaboration_details where col_name=?1 ;",nativeQuery = true)
    public String getTeamCapacity(String teamname);




}
