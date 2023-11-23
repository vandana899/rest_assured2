package rest_assured;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
public class google_api {
	public String url = "http://216.10.245.166/";	
	public String str;
	@Test(enabled=true)
	public void tc1_post() {
		JSONObject js=new JSONObject();
		JSONArray ja=new JSONArray();
		JSONObject jq=new JSONObject();
		JsonPath jr=new JsonPath(js.toJSONString());
		str=jr.get("place_id");
		
		jq.put("lat", 38.383494);
		jq.put("lng", 38.383494);
	    ja.add(jq);
		js.put("location",jq);
        js.put("accuracy",50);
        js.put("name","Frontline house");
        js.put("phone_number","(+91) 983 893 3937");
        js.put("address","29, side layout, cohen 09");
        js.put("types","shoe park");
        js.put("website","http://google.com");
        js.put("language","French-IN");
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).when().post("http://216.10.245.166/maps/api/place/add/json").then().statusCode(200).log().all();
	    given().queryParam("key", "qaclick123");
}
	@Test(enabled=true)
	public void tc2_delete() {
		JSONObject js = new JSONObject();
	    js.put("place_id",str);
	    given().queryParam("Key", "qaclick123").contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).when().delete("http://216.10.245.166/maps/api/place/delete/json/").then().statusCode(200).log().all();
	 
}
}

