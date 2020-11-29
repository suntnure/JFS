package com.wipro.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.model.TestDetails;
import com.wipro.model.User;
import com.wipro.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
     UserService userService;
	
	@RequestMapping(value= {"/OnlineAssessment/index","/OnlineAssessment"}, method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "index";
    }
    @RequestMapping(value="/login/do", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String email, @RequestParam String pass,
    		HttpServletRequest request){
    	
    	User user = userService.findUserByEmail(email);
    	if(user == null) {
    		model.put("title", "Invalid User Page");
            model.put("errorMsg", "Sorry you are not a registered User !!!");
            model.put("hrefName", "Home Page");
            return "do";
    	}
    	
        if (!user.getPassword().equals(pass)) {
        	model.put("title", "Password Error Page");
            model.put("errorMsg", "Sorry your Password is Wrong !!! Login again !!!");
            model.put("hrefName", "Login again");
            return "do";
        }else {
        	//check user type
        	if(user.getUserType().equals("Admin")) {
        		model.put("userType","Admin");
        		model.addAttribute("userType","Admin");
        		request.getSession().setAttribute("UserType", "Admin");
        		model.put("title", "Select Reports");
        	}else {
        		model.put("userType","User");
        		model.addAttribute("userType","User");
        		request.getSession().setAttribute("UserType", "User");
        		model.put("title", "Select Tests");
        	}
        }
        request.getSession().setAttribute("Email", email);
        model.put("name", email);
        return "welcome";
    }
    @RequestMapping(value="/OnlineAssessment/springAssessment", method = RequestMethod.GET)
    public String springAssessment(){
        return "/springAssessment";
    }
    
    @RequestMapping(value="/OnlineAssessment/hibernateAssessment", method = RequestMethod.GET)
    public String hibernateAssessment(){
        return "/hibernateAssessment";
    }
    
    @RequestMapping(value= {"/evaluate/spring/test","/evaluate/hibernate/test"}, method = RequestMethod.POST)
    public String springAssessmentSubmit(ModelMap model,HttpSession session, @RequestParam String Question1, @RequestParam String Question2,
    		@RequestParam String Question3,@RequestParam String Question4,@RequestParam String Question5,@RequestParam String subject){
       
    	int marks = userService.evaluateResult(subject,Question1,Question2,Question3,Question4,Question5);
    	TestDetails testDetails = new TestDetails();
    	if(marks >= 30) {
    		model.put("title", "success page");
    		model.put("errorMsg", "Congratulations !!! You have passed !!!");
    		model.put("hrefName", "EXIT");
    		testDetails.setResult("Passed");
    	}
    	else {
    		model.put("title", "failure page");
            model.put("errorMsg", "Sorry !!! Better Luck Next Time !!!");
            model.put("hrefName", "EXIT");
            testDetails.setResult("Failed");
    	}
    	//save date time , subject and result
    	
    	testDetails.setEmail((String) session.getAttribute("Email"));
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String date =  LocalDateTime.now().format(myFormatObj);
    	testDetails.setTestDate(date);
    	testDetails.setAssessment(subject);
    	testDetails.setTestMarks(marks);
    	userService.saveTestDetails(testDetails);
    	return "do";
    }
    
    @RequestMapping(value="/users/all", method = RequestMethod.GET)
    public String allUsers(ModelMap model,HttpSession session,HttpServletRequest request){
    	List<User> lstUsers = userService.getAllUserList();
    	request.setAttribute("data", lstUsers);
        return "/all";
    }
    
    @RequestMapping(value="/tests/all", method = RequestMethod.GET)
    public String allUsersTest(ModelMap model,HttpSession session,HttpServletRequest request){
    	List<TestDetails> lstUserTestDetails = userService.getAllTestDetailsList();
    	request.setAttribute("data", lstUserTestDetails);
        return "/testDetails";
    }
    
   /* @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }*/

    
    @RequestMapping(value = "/registration/do", method = RequestMethod.POST)
    public String createNewUser( User user, ModelMap model) {
    //	User userExists = userService.findUserByEmail(user.getEmail());
    	userService.saveUser(user);
    	model.put("errorMsg", "Registered Successfully!!! "+user.getName() +" "+user.getLastName());
    	model.put("title", "Registration Confirmation");
    	model.put("hrefName", "LOGIN");

    	return "do";
    }
}
