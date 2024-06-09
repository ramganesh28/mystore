package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.ResourceBundle;

import org.apache.logging.log4j.Logger;

import api.payload.user;
import io.restassured.response.Response;

public class userEndPoints2 {
	
	public Logger logger;
	
	static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
public static Response createuser(user payload){
		
		String post_url = getURL().getString("post_url");
		
		Response response = given()
		.contentType("application/json")
		.body(payload)
		.when()
		.post(post_url);
		
		return response;
	}
public static Response getuser(String id){
	String get_url = getURL().getString("get_url");
	Response resposne = given().pathParam("id", id)
			.when()
			.get(get_url);
	return resposne;
   }
public static Response updateuser(String id, user payload){
	String put_url = getURL().getString("put_url");
	Response response = given()
	.contentType("application/json")
	.pathParam("id", id)
	.body(payload)
	.when()
	.post(put_url);
	
	return response;
}
public static Response partialupdate(String id, user payload){
	String patch_url = getURL().getString("patch_url");
	Response response = given()
	.contentType("application/json")
	.pathParam("id", id)
	.body(payload)
	.when()
	.post(patch_url);
	
	return response;
}
public static Response delete(String id){
	String delete_url = getURL().getString("delete_url");
	Response resposne = given().pathParam("id", id)
			.when()
			.delete(delete_url);
	return resposne;
   }
}
