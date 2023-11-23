package rest_assured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class class2 {
	public String url=  "https://api.trello.com";
	//public String keys ="d48e2454df1464817d76399ef898c28c";
	//public String tokens ="bd0e9c156c00d694c5a295c6ffb243f90a27283714cf49e5e824e8ed8f75fda9";
	public String id;
 	@Test (enabled = true)
	public void tc1() {                //for creating and deleting 
		JSONObject js =new JSONObject();
		
	
		
		
		
		//str=js.toJSONString();
		RestAssured.baseURI=url;
		Response response=given().queryParam("name", "shizuka2")
				.queryParam("key", "d48e2454df1464817d76399ef898c28c")
			.queryParam("token", "bd0e9c156c00d694c5a295c6ffb243f90a27283714cf49e5e824e8ed8f75fda9")
		.when().accept(ContentType.JSON).contentType(ContentType.JSON).post("/1/boards/").then().extract().response();
		
		
		String jresponse= response.asString();
		JsonPath jp= new JsonPath(jresponse);
		
	  id= jp.get("id");
		System.out.println(id);
		given().queryParam("name", "shizuka2")
		.queryParam("key", "d48e2454df1464817d76399ef898c28c")
		.queryParam("token", "bd0e9c156c00d694c5a295c6ffb243f90a27283714cf49e5e824e8ed8f75fda9")
		.when().accept(ContentType.JSON).contentType(ContentType.JSON).delete("/1/boards/"+id).then().log().all();
}
}