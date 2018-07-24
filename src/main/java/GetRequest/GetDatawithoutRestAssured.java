package GetRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GetDatawithoutRestAssured 
{
	
	
	
	
	
	@Test
	public void TestRespond()
	{
		get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae2").getStatusCode();
	//Response resp= get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	
		int code= get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae2").getStatusCode();
		//int coode= resp.getStatusCode();
	Assert.assertEquals(code, 200);
	}
	
	@Test
	public void Testbody()
	{
	//Response resp= get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	String code= get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae2").asString();
	//String coode= resp.asString();
	System.out.println("Data is"+ code);
	//long time= resp.getTime();
	long time= get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae2").getTime();
	System.out.println("Time required is"+ time);
	
	}

}
