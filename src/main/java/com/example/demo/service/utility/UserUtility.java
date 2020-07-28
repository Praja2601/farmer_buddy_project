package com.example.demo.service.utility;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

public class UserUtility 
{
	public static void main(String args[]){
		//System.out.println(new UserUtility().loginUtility("Pra","pra123"));
		
	}
	//@Autowired
	//UserRepository userRepository;
	public String  loginUtility(String userName, String password, UserRepository userRepository)
	{
		User user = userRepository.findByUserName(userName);

		JSONArray userJsonArray = new JSONArray();
		JSONObject userJsonObject = new JSONObject();

		if ( null != user)
		{
			if(user.getPassward().equals(password))
			{
				userJsonObject.put("userid",user.getUserID());
				userJsonObject.put("username",user.getUserName());
				userJsonObject.put("status", "ok");
				userJsonArray.put(userJsonObject);

			}
			else
			{
				userJsonObject.put("status", "notok");
				userJsonArray.put(userJsonObject);
			}

		}
		else
		{
			userJsonObject.put("status", "notok");
			userJsonArray.put(userJsonObject);
		}

		return userJsonArray.toString();
	}
}
