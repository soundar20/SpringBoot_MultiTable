package com.java.Controller;

import com.java.Model.CollaborationDetails;
import com.java.Model.CollaborationUser;
import com.java.Model.User;
import com.java.Service.CollaborationDetailsService;
import com.java.Service.CollaborationUserService;
import com.java.Service.UserService;
import com.java.dto.CollaborationDetailsDTO;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {
    
    @Autowired
    UserService uService;
    
    @Autowired
    CollaborationDetailsService cdService;
    
    @Autowired
    CollaborationUserService cuService;
    
    @RequestMapping("/")
    public ModelAndView index(){
       return new ModelAndView("index");
    }
     
    @RequestMapping("/saveUser")
    public ModelAndView saveUser(User user){
        ModelAndView mv=new ModelAndView();
        try{
            uService.saveUserDetails(user);           
            mv.addObject("successMsg","Your Details are saved successfully..!");
            mv.setViewName("index");
            return mv;  
        }
        catch(Exception e){
            mv.addObject("ErrorMsg","The phoneNumber or EmailID is already in use");
            return new ModelAndView ("index");
        }
    }
    
     @RequestMapping("showuserdetails")
    public ModelAndView showUser(@RequestParam String userPhoneno,@RequestParam String userPass,HttpServletRequest request,HttpServletResponse response) throws IOException{
        ModelAndView mv=new ModelAndView();
        try{
        User users=uService.findByUserPhoneNo(userPhoneno,userPass);
        String phone=users.getUserPhoneno();
        String email=users.getUserEmail();
        String pass=users.getUserPass();
            if((userPhoneno.equals(phone) || userPhoneno.equals(email)) && userPass.equals(pass)){
                 HttpSession session=request.getSession();
                 session.setAttribute("userphone",userPhoneno);
                 System.out.println("Session ID: " + session.getId());
                 mv.addObject("list",users);
                 mv.setViewName("showUserDetails");   
            }
            return mv;
        }
        catch(NullPointerException e){
            mv.addObject("alreadythere","Your email or password is incorrect or User not found");
            return new ModelAndView ("index");
    }
}
     @RequestMapping("collaborationDetails")
    public ModelAndView collaborationDetails(){
          ModelAndView mv=new ModelAndView();
          List<CollaborationDetails> colDetails=cdService.showCollaborationDetails();
          mv.addObject("mv",colDetails);
          mv.setViewName("CollaborationDetails");
          return mv;
    }
    
    @RequestMapping("createTeam")
    public ModelAndView createTeam(){
        return new ModelAndView ("collaborationTeamForm");
    }
    
    @RequestMapping("SaveTeamCreation")
    public ModelAndView SaveTeamCreation(CollaborationDetails colDetails){
        ModelAndView mv=new ModelAndView();
            String colAdmin=colDetails.getColAdmin();
            String colName=colDetails.getColName();
            Date creationDate=colDetails.getCreationDate();
            String colDescription=colDetails.getColDescription();
            CollaborationDetailsDTO users=cdService.getDetailsForCollaboration(colAdmin);
            System.out.println(users);
            int a=users.getUserId();
            String b=users.getUserName();
            int value=1;
            cdService.insertQuery(colAdmin,a,colDescription,colName,b,creationDate,value);
            mv.addObject("mv","you created a team successfully");
            mv.setViewName("CollaborationTeamForm");
            return mv;
    }
    
    @RequestMapping("collaborationnewuser")
    public ModelAndView collaborationnewuser(){
        return new ModelAndView("collaborationnewuser");
    }
    
    @RequestMapping("saveColUser")
    public ModelAndView saveColUser(CollaborationUser coluser)
    {
        ModelAndView mv=new ModelAndView();
        String teamname=coluser.getCollTeamName();
        String mail=coluser.getUserCollMail();
        String teamCapacity=cdService.getTeamCapacity(teamname);
        System.out.print(teamCapacity);
        String userEmail=cuService.checkUserEmail(mail,teamname);
        String userTeam=cuService.checkUserTeam(mail,teamname);
        String colAdmin=cdService.colAdminOwner(mail,teamname);
        String colName=cdService.colAdminTeamName(mail,teamname);
         int b1=Integer.parseInt(teamCapacity);   
        if(mail.equals(colAdmin) && teamname.equals(colName)){
            mv.addObject("owner","Sorry you are the owner");
            mv.setViewName("collaborationnewuser");
            return mv;
        }
        else{
        if(coluser.getUserCollMail().equals(userEmail) && coluser.getCollTeamName().equals(userTeam)){
            mv.addObject("alreadymember","Sorry the user is already in the colloborationTeam");
            mv.setViewName("collaborationnewuser");
            return mv;
        }
        else{
            if(b1<5){ 
            cuService.saveColUser(coluser);
            mv.addObject("successMsg","Congrats you are added in the collaboration team..!");
            cdService.increaseTeamCapacity(teamname);
            mv.setViewName("collaborationnewuser");
            return mv;
            } 
            else {
            mv.addObject("sorry","the team is full please try another team");
            mv.setViewName("collaborationnewuser");
            return mv;
            }
            }
        } 
}
    
    
    
    
    
    
}