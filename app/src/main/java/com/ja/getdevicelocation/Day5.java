package com.ja.getdevicelocation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * author: Jiaying Guo
 * Get the forecast information from Day4 class and display them in Day5's view
 */
public class Day5 extends AppCompatActivity {
    private TextView real_weather, real_pressure, location,real_temperature,real_humid;

    /**
     * Override the default onCreate method, when this class's activity and view is created, it will
     * receive and display the forecast information passed from Day4 class, including temperature, pressure and etc.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day5);

        // Get the intent and passed-in forecast information and the forecast API call URL for later calls
        Intent intent=getIntent();
        String city=intent.getStringExtra("city");
        String pressure=intent.getStringExtra("pressure");
        String mainWeather=intent.getStringExtra("mainWeather");
        String humid=intent.getStringExtra("humid");
        String temperature=intent.getStringExtra("temp");

        // Find and set the text views with the passed-in information
        location=findViewById(R.id.location5);
        real_weather=findViewById(R.id.weather5);
        real_pressure=findViewById(R.id.pressure5);
        real_temperature=findViewById(R.id.temperature5);
        real_humid=findViewById(R.id.humid5);

        location.setText(city+ " Day5");
        real_weather.setText(mainWeather);
        real_pressure.setText(pressure);
        real_temperature.setText(temperature);
        real_humid.setText(humid);


        // Transform the weather description to icons
        ImageView view=findViewById(R.id.WeatherImage5);
        if(mainWeather.toLowerCase().contains("rain")) {
            Picasso.with(this).load(R.drawable.rainy).resize(300,300).into(view);
        }else if (mainWeather.toLowerCase().contains("snow")) {
            Picasso.with(this).load(R.drawable.snow).resize(300,300).into(view);
        }else if (mainWeather.toLowerCase().contains("cloud")) {
            Picasso.with(this).load(R.drawable.cloudy).resize(300,300).into(view);
        }else if (mainWeather.toLowerCase().contains("clear") || mainWeather.toLowerCase().contains("sun")) {
            Picasso.with(this).load(R.drawable.sunny).resize(300,300).into(view);
        } else if (mainWeather.toLowerCase().contains("fog") || mainWeather.toLowerCase().contains("haze")) {
            Picasso.with(this).load(R.drawable.fog).resize(300,300).into(view);
        }else{
            Picasso.with(this).load(R.drawable.sunny).resize(300,300).into(view);
        }

        // Display the date, which is 4 days past current day
        Date now=new Date();
        Calendar calendar=new GregorianCalendar();
        calendar.add(calendar.DATE,4);
        Date tom2=calendar.getTime();
        String todayString=new SimpleDateFormat("yyyy-MM-dd").format(tom2);
        TextView third=findViewById(R.id.Day5);
        third.setText(todayString);
    }
}

