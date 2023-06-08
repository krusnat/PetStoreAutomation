package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndPoints.java
//Created for perform Create, Retrieve, Update, Delete (CRUD) requests to the user API

public class UserEndPoints2 {
	
	//method created for getting URL'sfrom properties file
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes"); //Load properties file
		return routes;
	}
	
	
	public static Response createUser(User payload)
	{
		String post_user=getURL().getString("post_user");
		
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(post_user);
		
		return response;
	
	}
	
	public static Response readUser(String userName)
	{
		String get_user=getURL().getString("get_user");
		
		Response response=given()
				.contentType(ContentType.JSON)
					.pathParam("username", userName)
		.when()
			.get(get_user);
		
		return response;
	
	}

	public static Response updateUser(String userName, User payload)
	{
		String update_user=getURL().getString("update_user");
		
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
		.when()
			.put(update_user);
		
		return response;
	
	}
	
	public static Response deleteUser(String userName)
	{
		String delete_user=getURL().getString("delete_user");
		
		Response response=given()
					.pathParam("username", userName)
		.when()
			.delete(delete_user);
		
		return response;
	
	
	}
}
