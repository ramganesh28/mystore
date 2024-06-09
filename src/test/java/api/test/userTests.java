package api.test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndPoints;
import api.payload.user;
import io.restassured.response.Response;

public class userTests {
	
	Faker faker;
	user userPayload;
	public Logger logger;
	
	@BeforeClass
	public void setupdata(){
		faker = new Faker();
		userPayload = new user();
		userPayload.setId(faker.name().username());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setPassword(faker.internet().password(5, 12));
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		//userPayload.setUserstatus(0);
		//logs
		logger = LogManager.getLogger(this.getClass());
		
		
		
	}
	
	
	@Test(priority = 1)
	public void testbyadduser(){
		logger.info("executing the test by testbyadduser");
		logger.info("add user request payload");
		logger.info("username" +userPayload.getUsername());
		
		
		Response response = userEndPoints.createuser(userPayload);
		response.then().log().all();
		logger.info("Response of the create user" +response);
		
	}
	@Test(priority = 2)
	public void testbygetuser(){
		Response response = userEndPoints.getuser(this.userPayload.getId());
		response.then().log().all();
		
	}
	@Test(priority = 3)
	public void testbyuserupdate(){
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setPassword(faker.internet().password(5, 12));
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		Response response = userEndPoints.updateuser(this.userPayload.getId(), userPayload);
		response.then().log().all();
		
	}
	@Test(priority = 4)
	public void testbypartialuserupdate(){
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		Response response = userEndPoints.partialupdate(this.userPayload.getId(), userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 302, "Expected status code to be 302");
		
	}
	@Test(priority = 5)
	public void testbydeleteuser(){
		Response response = userEndPoints.delete(this.userPayload.getId());
		response.then().log().all();
		
	}

}
