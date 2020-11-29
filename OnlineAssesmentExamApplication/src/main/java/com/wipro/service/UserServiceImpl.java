package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.model.TestDetails;
import com.wipro.model.User;
import com.wipro.repository.TestDetailsRepository;
import com.wipro.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	 UserRepository userRepository;
	
	@Autowired
	TestDetailsRepository testDetailsRepo;
	
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {
    	user.setUserType("candidate");
    	return userRepository.save(user);
    }

	@Override
	public int evaluateResult( String subject,String q1, String q2, String q3, String q4, String q5) {
		int marks = 0;
		if(subject.equals("Spring-L1")) {
			if(q1 != null && q1.equals("J2EE App Development Framework"))
				marks+=10;
			if(q2 != null &&q2.equals("Inversion Of Control"))
				marks+=10;
			if(q3 != null && q3.equals("Aspect Oriented Programming"))
				marks+=10;
			if(q4 != null && q4.equals("Application Context"))
				marks+=10;
			if(q5 != null && q5.equals("Dispatcher Servlet"))
				marks+=10;
		}else if(subject.equals("Hibernate-L1")) {

			if(q1 != null && q1.equals("Object Relational Mapping"))
				marks+=10;
			if(q2 != null &&q2.equals("uni-directional & bi-directional"))
				marks+=10;
			if(q3 != null && q3.equals("configuration file"))
				marks+=10;
			if(q4 != null && q4.equals("Hibernate Query Language"))
				marks+=10;
			if(q5 != null && q5.equals("isolation levels"))
				marks+=10;
		}
		
		return marks;
	}

	@Override
	public List<User> getAllUserList() {
		return userRepository.findAllByOrderByNameAsc();	
	}

	@Override
	public List<TestDetails> getAllTestDetailsList() {
		return testDetailsRepo.findAllByOrderByIdAsc();
	}

	@Override
	public TestDetails saveTestDetails(TestDetails test) {
		test.setTotalMarks(50);
		return testDetailsRepo.save(test);
	}
}
