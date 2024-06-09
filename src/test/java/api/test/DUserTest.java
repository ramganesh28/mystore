package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userEndPoints;
import api.payload.user;
import api.utilities.DataProviders;
import io.restassured.response.Response;

@Test(priority = 1, dataProvider="userdata", dataProviderClass = DataProviders.class)
public class DUserTest {
	user userPayload;
	public void testbycreateuser(String id, String username, String firstname, String lastname, String email, String password, String phone, String userstatus) 
	{
		userPayload = new user();
		userPayload.setId(id);
		userPayload.setUsername(username);
		userPayload.setFirstname(firstname);
		userPayload.setLastname(lastname);
		userPayload.setPassword(password);
		userPayload.setEmail(email);
		userPayload.setPhone(phone);
		//userPayload.setPhone(userstatus);
		
		Response response = userEndPoints.createuser(userPayload);
		//response.then().log().all();
		Assert.assertEquals(response.statusCode(), 201);
	}
	
	@Test(priority = 2, dataProvider="usernames", dataProviderClass = DataProviders.class)
public void testbyreadusers(String id)
{
		Response response = userEndPoints.getuser(id);
		//response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
}
	@Test(priority = 3, dataProvider="usernames", dataProviderClass = DataProviders.class)
	public void testbydeleteusers(String id)
	{
			Response response = userEndPoints.delete(id);
			//response.then().log().all();
			Assert.assertEquals(response.statusCode(), 200);
	}
}
