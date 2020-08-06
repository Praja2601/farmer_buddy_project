package com.example.demo.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.model.ContactDetail;
import com.example.demo.model.Crop;
import com.example.demo.model.User;
import com.example.demo.model.UserDetail;
import com.example.demo.repo.ContactUsRepository;
import com.example.demo.repo.ResourceNotFoundException;
import com.example.demo.repo.UserDetailRepository;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.utility.UserUtility;



@Component
@Path("/user")

public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDetailRepository userDetailRepository;
	
	@Autowired
	ContactUsRepository contactusRepository;
	
	@Path("/login")
	@Produces("applications/json")
	@GET
	public String loginUser(@QueryParam ("uname") String userName,
            @QueryParam("pwd") String password)
	{
		System.out.println("Username:"+ userName + " Password:"+ password);
		
		return new UserUtility().loginUtility(userName, password,userRepository);
	}
	
	@GET
	@Path("/profile")
	@Produces("text/html")
	public String profile(@QueryParam ("userid") int userId)
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
	
	@Path("/create")
	@GET
	@Produces("application/json")
	public String createUser(@QueryParam ("firstname") String firstName,
            @QueryParam("lastname") String lastName,
			@QueryParam("username") String userName,
			@QueryParam("pwd") String password,
			@QueryParam("email") String eMail,
			@QueryParam("mobile") String mobile)
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
	
	
	
	@Path("/contact")
	@GET
	@Produces("application/json")
	public ContactDetail contactus(@QueryParam ("fullname") String fullName,
            @QueryParam("email") String eMail,
			@QueryParam("mobile") String mobile,
			@QueryParam("district") String district,
			@QueryParam("subject") String subject,
			@QueryParam("description") String description)
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

	
	@GET
    @Produces("application/json")
    @Path("/getAllUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
	@GET
    @Produces("application/json")
	@Path("/fetch/{id}")
	public ResponseEntity<User> getUserById(@PathParam(value = "id") int userId) throws ResourceNotFoundException {
		  User user = userRepository.findById(userId)
		    .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
		  return ResponseEntity.ok().body(user);
		 }

	
}

