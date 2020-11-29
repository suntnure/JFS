package com.wipro.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.model.Admin;
import com.wipro.model.Answers;
import com.wipro.model.AuthenticationBean;
import com.wipro.model.Greeting;
import com.wipro.model.Option;
import com.wipro.model.Question;
import com.wipro.model.QuestionTemp;
import com.wipro.model.Survey;
import com.wipro.model.TempAnswer;
import com.wipro.model.TempSurvey;
import com.wipro.model.Users;
import com.wipro.service.AdminService;
import com.wipro.service.CreateSurveyService;
import com.wipro.service.SaveSurveyService;
import com.wipro.util.JwtUtil;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private CreateSurveyService createSurveyService;
	
	@Autowired
	private SaveSurveyService saveSurveyService;

	@Autowired
	private JavaMailSender sender;
	 @Autowired
	    private JwtUtil jwtUtil;
	    @Autowired
	    private AuthenticationManager authenticationManager;

	
	@RequestMapping(value="/sendmail/{surveyId}/{surveyTitle}", produces="text/plain")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String sendMail(@PathVariable("surveyId") int surveyId,@PathVariable("surveyTitle") String surveyTitle) throws Exception {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(sendEmailIds());
		mail.setSubject("Register To Survey on below link");
		String text="http://localhost:4200/details/"+surveyId+"/"+surveyTitle;
		mail.setText(text);

		sender.send(mail);

		return "Email has sent successfully";

	}
	public String[] sendEmailIds() {
		String[] emailIds = new String[2];
		emailIds[0] = "nikkisunt@gmail.com";
		emailIds[1] = "anujasuntnur@gmail.com";
		
		return emailIds;
		}

	@PostMapping("/admin")
	@Transactional
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String adminLogin(@RequestBody Admin admin) {
		Admin existingAdmin = adminService.findByusername(admin.getUsername());
		 if(existingAdmin != null)
	        {
			 return "This Admin already exists!";
	           
	        }
		admin.setConfirmPassword(admin.getPassword());
		 adminService.saveAdmin(admin);
		return "Admin " + admin.getUsername() + " added successfully";
	}
	
	@PostMapping("/saveanswer")
	@Transactional
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String saveAns(@RequestBody TempAnswer answer) {
		Answers answers = null;
		Users users=new Users();
		ArrayList<String> anslist1,anslist2,anslist3,anslist4,anslist5 = new ArrayList<String>();
		String strAppend = "";
		int surveyId=Integer.valueOf((String) answer.getId());
		String existingUser = saveSurveyService.findByEmailIdIgnoreCase((String)answer.getEmail(),surveyId);
		 if(existingUser != null)
	        {
			 return "This email already exists!";
	           
	        }
		
		
		
		users.setEmail((String)answer.getEmail());
		users.setName((String)answer.getName());
		users.setSurveyId(surveyId);
		Date date = new Date();
		users.setTimestamp(date);
		
		Timestamp ts=new Timestamp(date.getTime());
		SimpleDateFormat formatter=new SimpleDateFormat("dd-M-yyyy");
		users.setSubmitteddate(formatter.format(ts));
		saveSurveyService.addUsers(users);
		
		
		
		if(!answer.getAns1().equals("")) {
			answers = new Answers();
			answers.setSurveyId(surveyId);
			answers.setTimestamp(date);
			answers.setAnswerId(1);
			answers.setQuestionId(1);
			if (answer.getAns1() instanceof String) {
				String newans1 = (String) answer.getAns1();
				answers.setAnswer(newans1);
			}else {
				anslist1 = ((ArrayList<String>) answer.getAns1());
				for(String str:anslist1) {
					strAppend+=str;
					strAppend = strAppend + ",";
				}
				answers.setAnswer(strAppend);
			}
			saveSurveyService.AddAnswer(answers);
		}
		strAppend = "";
		if(!answer.getAns2().equals("")) {
			answers = new Answers();
			answers.setSurveyId(surveyId);
			answers.setTimestamp(date);
			answers.setAnswerId(2);
			answers.setQuestionId(2);
		//	answers.setAnswer((String) answer.getAns2());
			if (answer.getAns2() instanceof String) {
				String newans2 = (String) answer.getAns2();
				answers.setAnswer(newans2);
			}else {
				anslist2 = ((ArrayList<String>) answer.getAns2());
				for(String str:anslist2) {
					strAppend+=str;
					strAppend = strAppend + ",";
					
				}
				answers.setAnswer(strAppend);
			}
			saveSurveyService.AddAnswer(answers);
		}
		strAppend = "";
		if(!answer.getAns3().equals("")) {
			answers = new Answers();
			answers.setSurveyId(surveyId);
			answers.setTimestamp(date);
			answers.setAnswerId(3);
			answers.setQuestionId(3);
		//	answers.setAnswer((String) answer.getAns3());
			if (answer.getAns3() instanceof String) {
				String newans3 = (String) answer.getAns3();
				answers.setAnswer(newans3);
			}else {
				anslist3 = ((ArrayList<String>) answer.getAns3());
				for(String str:anslist3) {
					strAppend+=str;
					strAppend = strAppend + ",";
					
				}
				answers.setAnswer(strAppend);
			}
			saveSurveyService.AddAnswer(answers);
		}
		strAppend = "";
		if(!answer.getAns4().equals("")) {
			answers = new Answers();
			answers.setSurveyId(surveyId);
			answers.setTimestamp(date);
			answers.setAnswerId(4);
			answers.setQuestionId(4);
			//answers.setAnswer((String) answer.getAns4());
			if (answer.getAns4() instanceof String) {
				String newans4 = (String) answer.getAns4();
				answers.setAnswer(newans4);
			}else {
				anslist4 = ((ArrayList<String>) answer.getAns4());
				for(String str:anslist4) {
					strAppend+=str;
					strAppend = strAppend + ",";
					
				}
				answers.setAnswer(strAppend);
			}
			saveSurveyService.AddAnswer(answers);
		}
		strAppend = "";
		if(!answer.getAns5().equals("")) {
			answers = new Answers();
			answers.setSurveyId(surveyId);
			answers.setTimestamp(date);
			answers.setAnswerId(5);
			answers.setQuestionId(5);
			//answers.setAnswer((String) answer.getAns5());
			if (answer.getAns5() instanceof String) {
				String newans5 = (String) answer.getAns5();
				answers.setAnswer(newans5);
			}else {
				anslist5 = ((ArrayList<String>) answer.getAns5());
				for(String str:anslist5) {
					strAppend+=str;
					strAppend = strAppend + ",";
					
				}
				answers.setAnswer(strAppend);
			}
			saveSurveyService.AddAnswer(answers);
		}
		
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo((String) answer.getEmail());
		mail.setSubject("Registration Confirmation Mail");
		mail.setText("You have successfully submmitted the survey");
		sender.send(mail);
		
		return "Suvey submitted successfully for"+((String)answer.getName())+"And Mail sent successfully";
	}
	 

	@GetMapping("/survey")
	@Transactional
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public List<Survey> getSurvey() {
	
	//	createSurveyService.deleteOnTimeStampExpire();
		
		List<Survey> serveyList = createSurveyService.findAll();
		
		return serveyList;
	}
	
	@GetMapping("/surveyResult/{surveyId}")
	@Transactional
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public List<Survey> getSurveyResult(@PathVariable("surveyId") int surveyId) {
		List<Survey> servey = createSurveyService.findbysurveyId(surveyId);
		if(servey != null && !servey.isEmpty() && servey.size() > 0) {
			List<Users> usersBySurveyId = saveSurveyService.findAllBySurveyId(surveyId);
			servey.get(0).setResponseCount(usersBySurveyId.size());
		}
		
		return servey;
	}
	@GetMapping("/alldetails/{surveyId}")
	@Transactional
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public List<Users> getusers(@PathVariable("surveyId") int surveyId) {
		List<Users> users = saveSurveyService.findAllBySurveyId(surveyId);
		return users;
	}

	@GetMapping("/details/{surveyId}")
	@Transactional
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public List<Question> getSurveyDetails(@PathVariable("surveyId") int surveyId) {

		List<QuestionTemp> queList = createSurveyService.getquestions(surveyId);
		List<Question> questionsList = new ArrayList<>();
		for (QuestionTemp questn : queList) {
			Question question = new Question();
			question.setText(questn.getQuestion());
			question.setType(questn.getQuestionType());
			if (questn.getOption() != null && !questn.getOption().isEmpty())
				question.setOptionsArray(questn.getOption().split(","));
			else
				question.setOptionsArray(new String[] {});

			questionsList.add(question);
		}

		return questionsList;
	}
	
	@GetMapping("/showgraph/{surveyId}")
	@Transactional
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public HashMap<String,Integer> getSurveyAnswers(@PathVariable("surveyId") int surveyId) {

		List<Object[]> answers = saveSurveyService.getAnswersBySurveyId(surveyId);
		List<Object[]> newanswers=saveSurveyService.findAllBySurveyId1(surveyId);
		List<Answers> lstAnswers = new ArrayList<Answers>();
		List<String> lststrAnswers = new ArrayList<String>();
		HashMap<String,Integer> mapobj=new HashMap<String,Integer>();
		for (Object[] objects : newanswers) {
			Answers answer = (Answers) objects[0];
		//	answer.setAnswer(String.valueOf(objects[0]));
		 	//answer.setQuestionId(Integer.parseInt(String.valueOf(objects[1])));
			lststrAnswers.add(answer.getAnswer());
		}
		System.out.println(lststrAnswers);
		System.out.println(Collections.frequency(lststrAnswers, "fever,cold,"));
		mapobj.put("fever", Collections.frequency(lststrAnswers, "fever"));
		mapobj.put("cold", Collections.frequency(lststrAnswers, "cold"));
		mapobj.put("fever,cold", Collections.frequency(lststrAnswers, "fever,cold,"));
		mapobj.put("cold,breathing", Collections.frequency(lststrAnswers, "cold,difficulty breathing,"));
		return mapobj;
	}

	@PostMapping("/createSurvey")
	@Transactional
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String createSurvey(@RequestBody TempSurvey survey) {
		// add entry in survey table
		Survey survey2 = new Survey();
		survey2.setSurveyTitle(survey.getTitle());
		Survey existingSurvey = createSurveyService.findBysurveyTitleIgnoreCase(survey.getTitle());
		 if(existingSurvey != null)
	        {
			 return "The Survey "+survey.getTitle()+"  already exists!";
	           
	        }
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 0);  
		Date newDate = cal.getTime(); 
		Timestamp ts=new Timestamp(newDate.getTime());
		SimpleDateFormat formatter=new SimpleDateFormat("dd-M-yyyy");
		survey2.setSurveySubmitDate(formatter.format(ts));
	//	System.out.println(newDate);
		survey2.setTimestamp(newDate);
		
		Survey createSurvey = createSurveyService.createSurvey(survey2);

		// System.out.println(formatter.format(date));
		// add entry in question table
		List<Question> question = survey.getQuestion();
		int i = 1;
		for (Question que : question) {
			QuestionTemp questionTemp = new QuestionTemp();
			questionTemp.setSurveyId(createSurvey.getSurveyId());
			questionTemp.setQuestionType(que.getType());
			questionTemp.setQuestion(que.getText());
			questionTemp.setQuestionId(i);
			i++;
			String optionsAppend = "";
			if (que.getOptions() != null && que.getOptions().size() > 0) {
				for (Option opt : que.getOptions()) {
					if (!optionsAppend.isEmpty())
						optionsAppend = optionsAppend + ",";
					optionsAppend += opt.getOptionText();
				}
				questionTemp.setOptions(optionsAppend);
			} else {
				// in case of type = TEXT
				questionTemp.setOptions("");
			}
			QuestionTemp temp = createSurveyService.AddQuestions(questionTemp);
			System.out.println(temp);
		}

		return "Survey "+ survey.getTitle()+" Created Successfully" + " ";
	}

	@DeleteMapping("/deletesurvey/{surveyId}")
	@Transactional
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public void deleteStudent(@PathVariable int surveyId) {
		createSurveyService.deleteBysurveyId(surveyId);
	}
	
/*	@GetMapping(path = "/api/v1/basicauth")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public AuthenticationBean helloWorldBean() {
		return new AuthenticationBean("You are authenticated");
	}
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/api/v1/greeting")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public Greeting greeting(@RequestParam(value = "username", defaultValue = "World") String username) {
		return new Greeting(counter.incrementAndGet(), String.format(template, username));
	}
	
	@RequestMapping("/api/hi")
	public String hi() {
		return "Hello world! >>> Message from <a href='https://grokonez.com' target='_blank'>grokonez.com</a>";
	}
	 */

	    @GetMapping("/welcome")
	    @CrossOrigin(origins = "*", allowedHeaders = "*")
	    public String welcome() {
	        return "Welcome to javatechie !!";
	    }

	    @PostMapping("/authenticate")
	    @CrossOrigin(origins = "*", allowedHeaders = "*")
	    public String generateToken(@RequestBody Admin admin) throws Exception {
	  
	    	System.out.println(admin.getUsername());
	    	try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(admin.getUsername(), admin.getPassword()));
	        } catch (Exception ex) {
	          return "Invalid";
	        //	throw new Exception("inavalid username/password");
	        }
	        return jwtUtil.generateToken(admin.getUsername());
	    }
	
}
