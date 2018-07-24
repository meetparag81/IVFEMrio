package GetRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData 
{
	@Test
	public void TestRespond()
	{
	Response resp=	RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	
	int coode= resp.getStatusCode();
	Assert.assertEquals(coode, 200);
	}
	
	@Test
	public void Testbody()
	{
	Response resp=	RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	
	String coode= resp.asString();
	System.out.println("Data is"+ coode);
	long time= resp.getTime();
	System.out.println("Time required is"+ time);
	
	}

}
