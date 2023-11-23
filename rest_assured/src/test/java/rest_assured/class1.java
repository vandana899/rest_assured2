package rest_assured;

import java.net.ResponseCache;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

public class class1 {
public String url= "https://reqres.in/api/users";

@Test (enabled = false)
public void tc1() {
	Response rep = RestAssured.get(url);
	int actual=rep.statusCode();
	Assert.assertEquals(actual, 200);
}
@Test(enabled = false)
public void tc2() {
	
	given().get(url).then().statusCode(200).log().all();// getting list of users
	given().get(url).then().statusCode(200).body("data.id[0]", equalTo(7));https://reqres.in/api/users
	given().get(url).then().statusCode(200).body("data.id[0]", equalTo(7)).body("data.first_name", hasItem("Rachel"));
	//given().get(url).then().statusCode(200).body("data.id", hasItems(7));
	//public String url1= "https://reqres.in/api/users?page=2";
	
}

@Test(enabled = false)
public void tc3() {
	JSONObject js =new JSONObject();
	js.put("name", "vandana");// creating the user
	js.put("job", "tester");
	//System.out.println(js.toJSONString());
	given().body(js.toJSONString()).when().post(url).then().statusCode(201).log().all();
}

@Test(enabled = false)
public void tc4() {
	when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();//deleting the user
}
//single user not found 

@Test(enabled = false)
public void tc5() {
//getting single user not found
	given().get("https://reqres.in/api/users/23").then().statusCode(404).log().all();
}

//getting the single resource

@Test(enabled = false)
public void tc6() {
	given().get("https://reqres.in/api/unknown/2").then().statusCode(200).body("data.name", equalTo("fuchsia rose"));
}


// for updating the user
@Test(enabled = false)
public void tc7() {
	JSONObject js =new JSONObject();
	js.put("name", "vandana");// creating the user
	js.put("job", "tester");
	//System.out.println(js);
	given().body(js.toJSONString()).put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
}







//for registration successful
@Test(enabled = true)
public void tc9(){
	JSONObject js =new JSONObject();
	js.put("email", "vandana44@gmail.com");
	js.put("password", "tester");
	//System.out.println(js);
	given().body(js.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(200).log().all();
}





//for login successful
@Test(enabled = true)
public void tc8(){
	JSONObject js =new JSONObject();
	js.put("email", "vandana44@gmail.com");
	js.put("password", "tester");
	//System.out.println(js);
	given().body(js.toJSONString()).when().post("https://reqres.in/api/login").then().statusCode(200).log().all();
}

















}

