package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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
	//Test Purpose:tests the response of the cityAPI
	@Test
	public void cityURLResonseTest() throws IOException {
	  String a=city.createURL("Chicago");
		URL url = null;
		try {
			url = new URL(a);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String b=city.makeAPICall(url);
		
		assertEquals(true, b.contains("temp"));	
	}	
	//Test Purpose:tests the parse of the cityAPI
		@Test
		public void cityURLParseTest() throws IOException {
		  String a=city.createURL("Chicago");
			URL url = null;
			try {
				url = new URL(a);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String b=city.makeAPICall(url);
			String c=city.getCityWeather(b).getCity();
			
			assertEquals("Chicago", c);	
		}
	//Test Purpose: tests calling forecastAPI
	@Test
	public void forecastURLTest() {
		String a=forecastWeather.createURL(70.0, 90.0);
		
		assertEquals(true, a.contains("70.0"));	
	}	
	
	//Test Purpose:tests the response of the forecastAPI
		@Test
		public void forecastURLResonseTest() throws IOException {
		  String a=forecastWeather.createURL(60.0,80.0);
			URL url = null;
			try {
				url = new URL(a);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String b=forecastWeather.makeAPICall(url);
			
			assertEquals(true, b.contains("temp"));	
		}	
		//Test Purpose:tests the parse of the cityAPI
			@Test
			public void forecastURLParseTest() throws IOException {
			  String a=forecastWeather.createURL(40.0,45.0);
				URL url = null;
				try {
					url = new URL(a);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String b=forecastWeather.makeAPICall(url);
				int c=forecastWeather.getGeoForecast(b).size();
				
				assertEquals(5, c);	
			}
	//Test Purpose: tests calling forecastCityAPI
		@Test
		public void forecastCityURLTest() {
			String a=forecastCity.createURL("London");
			
			assertEquals(true, a.contains("London"));	
		}	
		//Test Purpose:tests the response of the forecastCityAPI
		@Test
		public void forecastCityURLResonseTest() throws IOException {
		  String a=forecastCity.createURL("Beijing");
			URL url = null;
			try {
				url = new URL(a);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String b=forecastCity.makeAPICall(url);
			
			assertEquals(true, b.contains("humid"));	
		}	
		//Test Purpose:tests the parse of the cityAPI
			@Test
			public void forecastCityURLParseTest() throws IOException {
			  String a=forecastCity.createURL("New York");
				URL url = null;
				try {
					url = new URL(a);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String b=forecastCity.makeAPICall(url);
				String c=forecastCity.getCityForecast(b).get(1).getCity();
				
				assertEquals("New York", c);	
			}
		
		//Test Purpose: tests calling weatherAPI
				@Test
				public void weatherURLTest() {
					String a=weather.createURL(80.0,60.0);
					
					assertEquals(true, a.contains("80.0"));	
				}	
				//Test Purpose:tests the response of the weatherAPI
				@Test
				public void weatherURLResonseTest() throws IOException {
				  String a=weather.createURL(10.0,20.0);
					URL url = null;
					try {
						url = new URL(a);
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String b=weather.makeAPICall(url);
					
					assertEquals(true, b.contains("temp"));	
				}	
				//Test Purpose:tests the parse of the cityAPI
					@Test
					public void weatherURLParseTest() throws IOException {
					  String a=weather.createURL(39.13,117.2);
						URL url = null;
						try {
							url = new URL(a);
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String b=weather.makeAPICall(url);
						String c=weather.getWgeo(b).getCity();
						
						assertEquals("Tianjin Shi", c);	
					}		
				
}