package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SingleUserDto {
    
    int userId;
    String userName;
    String userEmail;
    String userPhoneno;
    String collTeamName;
    String colAdmin;
    int colAdminId;
    
    
   
}
