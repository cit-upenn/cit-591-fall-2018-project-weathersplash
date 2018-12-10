package com.ja.getdevicelocation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WeatherDisplay extends AppCompatActivity {
    private TextView real_weather, real_pressure, location,real_temperature,real_humid,real_tempMax,real_tempMin, real_Weather2,real_Weather3,real_Weather4,real_Weather5,real_Weather6;


    private String lat,lon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_display);
        Intent intent=getIntent();
        String city=intent.getStringExtra("city");
        String pressure=intent.getStringExtra("pressure");
        String mainWeather=intent.getStringExtra("mainWeather");


        ImageView view=findViewById(R.id.WeatherImage);

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



        Date now=new Date();

        Calendar calendar=new GregorianCalendar();
        calendar.add(calendar.DATE,1);
        Date tomorrow1=calendar.getTime();
        String nowAsString=new SimpleDateFormat("yyyy-MM-dd" ).format(now);
        TextView day=findViewById(R.id.Day);
        day.setText(nowAsString);


        String temperature=intent.getStringExtra("temperature");
        String tempMax=intent.getStringExtra("tempMax");
        String tempMin=intent.getStringExtra("tempMin");
        String humid=intent.getStringExtra("humid");
        location=findViewById(R.id.location);
        real_weather=findViewById(R.id.weather);
        real_pressure=findViewById(R.id.pressure);
        real_temperature=findViewById(R.id.temperature);
        real_tempMax=findViewById(R.id.tempMax);
        real_tempMin=findViewById(R.id.tempMin);
        real_humid=findViewById(R.id.humid);

        //real_Weather6 =findViewById(R.id.sixthInfo);
        location.setText(city);
        real_weather.setText(mainWeather);
        real_pressure.setText(pressure);
        real_temperature.setText(temperature);
        real_humid.setText(humid);
        real_tempMax.setText(tempMax);
        real_tempMin.setText(tempMin);


        //real_Weather6.setText(mainWeather6Info);

this.lat=intent.getStringExtra("lat");
this.lon=intent.getStringExtra("lon");

        location.setOnTouchListener(new OnSwipeTouchListener(WeatherDisplay.this) {
            public void onSwipeTop() {
                Toast.makeText(WeatherDisplay.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                ForecastAPI forecastAPI=new ForecastAPI();
                String url=forecastAPI.createURL(Double.parseDouble(lat),Double.parseDouble(lon));
                Toast.makeText(WeatherDisplay.this,"right",Toast.LENGTH_SHORT).show();
                ForecastTask forecastTask=new ForecastTask(WeatherDisplay.this,Day2.class);
                forecastTask.execute(url,"0");
            }
            public void onSwipeLeft() {
                Toast.makeText(WeatherDisplay.this, "left", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {
                Toast.makeText(WeatherDisplay.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });


    }
}