package test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.CityAPI;
import main.ForecastAPI;
import main.ForecastCityAPI;
import main.WeatherAPI;
public class test {
	
	CityAPI city;
	ForecastAPI forecastWeather;
	ForecastCityAPI forecastCity;
	WeatherAPI weather;
	
	@BeforeEach
	public void setUp() {
		city=new CityAPI();
		forecastWeather=new ForecastAPI();
		forecastCity=new ForecastCityAPI();
		weather=new WeatherAPI();
	}
	
	//Test Purpose: tests calling cityAPI
	@Test
	public void cityURLTest() {
		String a=city.createURL("Chicago");
		
		assertEquals(true, a.contains("Chicago"));	
	}	
	//Test Purpose: tests calling forecastAPI
	@Test
	public void forecastURLTest() {
		String a=forecastWeather.createURL(70.0, 90.0);
		
		assertEquals(true, a.contains("70.0"));	
	}	
	//Test Purpose: tests calling forecastCityAPI
		@Test
		public void forecastCityURLTest() {
			String a=forecastCity.createURL("London");
			
			assertEquals(true, a.contains("London"));	
		}	
		
		//Test Purpose: tests calling weatherAPI
				@Test
				public void weatherURLTest() {
					String a=weather.createURL(80.0,60.0);
					
					assertEquals(true, a.contains("80.0"));	
				}	
				
//	//Test Purpose: tests String remains unchanged if String does not have digits
//	@Test
//	public void replaceAllDigitsTest2() {
//		myCustomString.setMyString("DogDog");
//		myCustomString.replaceAllDigits('X');
//		assertEquals("DogDog", myCustomString.getMyString());	
//	}	
//	
//	//Test Purpose: tests basic functionality
//	@Test
//	public void removeAllNonCharactersTest1() {
//		myCustomString.setMyString("dog456dog");
//		myCustomString.removeAllNonCharacters();
//		assertEquals("dogdog", myCustomString.getMyString());		
//	}
//		
//	@Test
//	public void removeTrailingNonCharactersTest1() {
//		
//		myCustomString.setMyString("Dog456Dog!");
//		myCustomString.removeTrailingNonCharacters();
//		assertEquals("Dog456Dog", myCustomString.getMyString());
//	}
//	
}