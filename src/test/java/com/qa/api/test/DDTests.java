package com.qa.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.api.endpoints.UserEndPoints;
import com.qa.api.payloads.User;
import com.qa.api.utilities.DataProviders;

import io.restassured.response.Response;

public class DDTests {
	
	User userPayload;

	//Create user using Data from Excel
	@Test(priority=1,dataProvider="Data",dataProviderClass = DataProviders.class,enabled=true)
	public void testPostUser(String userId,String userName,String fname,String lname,String useremail,String pwd,String ph)
	{
		userPayload = new User();

		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response = UserEndPoints.createUser(userPayload);

		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	//Delete Data using Username
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass = DataProviders.class,enabled=true)
	public void testDeleteUserByName(String userName)
	{
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
}
