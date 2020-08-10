package com.example.demo.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ContactDetail;
import com.example.demo.model.User;
import com.example.demo.model.UserDetail;
import com.example.demo.repo.ContactUsRepository;
import com.example.demo.repo.ResourceNotFoundException;
import com.example.demo.repo.UserDetailRepository;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.utility.UserUtility;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDetailRepository userDetailRepository;
	
	@Autowired
	ContactUsRepository contactusRepository;
	
	@RequestMapping(value="/login", method=RequestMethod.GET,produces = "text/html")
	public String loginUser(@RequestParam (name="uname") String userName,
            @RequestParam(name="pwd") String password)
	{
		System.out.println("Username:"+ userName + " Password:"+ password);
		
		return new UserUtility().loginUtility(userName, password,userRepository);
	}
	
	
	@RequestMapping(value="/profile", method=RequestMethod.GET,produces = "text/html")
	public String profile(@RequestParam ("userid") int userId)
	{
		JSONArray userprofileArray = new JSONArray();
		JSONObject userprofileObject = null;
		
		UserDetail profile = userDetailRepository.findUserId(userId);
		
		if(profile != null)
		{
			userprofileObject = new JSONObject();
			userprofileObject.put("status", "ok");
			userprofileObject.put("firstname", profile.getFirstName());
			userprofileObject.put("lastname", profile.getLastName());
			userprofileObject.put("mobile", profile.getMobile());
			userprofileObject.put("email", profile.getEmail());
			userprofileArray.put(userprofileObject);
		}
		else
		{
			userprofileObject = new JSONObject();
			userprofileObject.put("status", "notok");
			userprofileArray.put(userprofileObject);
		}
		return userprofileArray.toString();			
	}
	
	
	@RequestMapping(value="/create", method=RequestMethod.GET,produces = "text/html")
	public String createUser(
			@RequestParam (name="firstname") String firstName,
            @RequestParam(name="lastname") String lastName,
			@RequestParam(name="username") String userName,
			@RequestParam(name="pwd") String password,
			@RequestParam(name="email") String eMail,
			@RequestParam(name="mobile") String mobile)
	{
		System.out.println(
				"Firstname:"+ firstName +
				"Lastname:"+ lastName +
				"Username:"+ userName + 
				"Password:"+ password +
				"Email:"+ eMail +
				"mobileno:"+ mobile
				);

		JSONArray userJsonArray = new JSONArray();
		JSONObject userJsonObject = new JSONObject();
		
		User user = userRepository.findByUserName(userName);
		if(user!= null) {
			userJsonObject.put("status", "notok");
			userJsonObject.put("msg","Please input a Value");
		}
		else
		{
			User usernew = new User();
			usernew.setRoleID(2);
			usernew.setUserName(userName);
			usernew.setPassward(password);
			
			User savedUser = userRepository.save(usernew);
			
			if(savedUser != null) {
				UserDetail userDetail = new UserDetail();
				userDetail.setUserId(savedUser.getUserID());
				userDetail.setFirstName(firstName);
				userDetail.setLastName(lastName);
				userDetail.setEmail(eMail);
				userDetail.setMobile(mobile);
				
				userDetailRepository.save(userDetail);
				
				userJsonObject.put("status", "ok");		
				userJsonObject.put("msg", "User created successfully! Try logging in.");
			}	
			else
			{
				userJsonObject.put("status", "notok");
				userJsonObject.put("msg","User already exists! Choose different username.");
			}
		}
		
		userJsonArray.put(userJsonObject);
		
		return userJsonArray.toString();
	}
	
	
	
	
	@RequestMapping(value="/contact", method=RequestMethod.GET,produces = "text/html")
	public ContactDetail contactus(
			@RequestParam (name="fullname") String fullName,
            @RequestParam(name="email") String eMail,
			@RequestParam(name="mobile") String mobile,
			@RequestParam(name="district") String district,
			@RequestParam(name="subject") String subject,
			@RequestParam(name="description") String description)
	{
		System.out.println(
				"Fullname:"+ fullName +
				"Email:"+ eMail +
				"mobileno:"+ mobile + 
				"District:"+ district +
				"Subject:"+ subject +
				"Description:"+ description
				);
		
		ContactDetail contactdetail = new ContactDetail();
		contactdetail.setFullName(fullName);
		contactdetail.setEmail(eMail);
		contactdetail.setMobile(mobile);
		contactdetail.setDistrict(district);
		contactdetail.setSubject(subject);
		contactdetail.setDescription(description);
		
		return contactusRepository.save(contactdetail);
	}	
}

