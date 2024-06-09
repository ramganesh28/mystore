package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.HashMap;


import api.payload.user;
import io.restassured.response.Response;

public class userEndPoints {
	
public static Response createuser(user payload){
		
		
		
		Response response = given()
		.contentType("application/json")
		.body(payload)
		.when()
		.post(Routes.post_url);
		
		return response;
	}
public static Response getuser(String id){
	Response resposne = given().pathParam("id", id)
			.when()
			.get(Routes.get_url);
	return resposne;
   }
public static Response updateuser(String id, user payload){
	
	Response response = given()
	.contentType("application/json")
	.pathParam("id", id)
	.body(payload)
	.when()
	.post(Routes.put_url);
	
	return response;
}
public static Response partialupdate(String id, user payload){
	
	Response response = given()
	.contentType("application/json")
	.pathParam("id", id)
	.body(payload)
	.when()
	.post(Routes.patch_url);
	
	return response;
}
public static Response delete(String id){
	Response resposne = given().pathParam("id", id)
			.when()
			.delete(Routes.delete_url);
	return resposne;
   }
}
