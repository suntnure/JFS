package com.wipro.service;

import java.util.List;

import com.wipro.model.TestDetails;
import com.wipro.model.User;

public interface UserService {
    public User findUserByEmail(String email) ;
    
    public User saveUser(User user);
    
    public int evaluateResult( String subject,String q1,String q2,String q3,String q4,String q5);
    
    public TestDetails saveTestDetails(TestDetails test);
   
    public List<User> getAllUserList();
    
    public List<TestDetails> getAllTestDetailsList();
}
