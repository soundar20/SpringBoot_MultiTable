package com.java.Repo;

import com.java.Model.User;
import com.java.dto.SingleUserDto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
    
    @Query(value="SELECT * FROM user WHERE (user_email=?1 or user_phoneno=?1) AND user_pass=?2",nativeQuery = true)
    public User findByUserPhoneNo(String userPhoneno,String userPass);
    
    @Query("SELECT new com.java.dto.SingleUserDto(u.userId, u.userName,u.userEmail,u.userPhoneno,cu.collTeamName,cd.colAdmin,cd.colAdminId)FROM User u INNER JOIN u.collUser cu ON u.userId=cu.collUserId INNER JOIN CollaborationDetails cd ON cd.colName=cu.collTeamName where u.userId=?1")
    public List<SingleUserDto> getCombinedUser(int id);
    
}
