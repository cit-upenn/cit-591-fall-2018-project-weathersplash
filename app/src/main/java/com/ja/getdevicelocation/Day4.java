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

/**
 * author: Jiaying Guo
 * Get the forecast information from Day3 class and display them in Day4's view, swipeRight gesture triggers
 * a new activity in Day5 class, and send the forecast information of day 5 to its view.
 */
public class Day4 extends AppCompatActivity {
    private TextView real_weather, real_pressure, location,real_temperature,real_humid;
    private String url;

    /**
     * Override the default onCreate method, when this class's activity and view is created, it will
     * receive and display the forecast information passed from Day3 class, including temperature, pressure and etc. It
     * also includes a swipe gesture activity involving Day4 class.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day4);

        // Get the intent and passed-in forecast information and the forecast API call URL for later calls
        Intent intent=getIntent();
        String city=intent.getStringExtra("city");
        String pressure=intent.getStringExtra("pressure");
        String mainWeather=intent.getStringExtra("mainWeather");
        String humid=intent.getStringExtra("humid");
        String temperature=intent.getStringExtra("temp");
        url=intent.getStringExtra("forecastURL");


        // Find and set the text views with the passed-in information
        location=findViewById(R.id.location4);
        real_weather=findViewById(R.id.weather4);
        real_pressure=findViewById(R.id.pressure4);
        real_temperature=findViewById(R.id.temperature4);
        real_humid=findViewById(R.id.humid4);

        location.setText(city+ " Day4");
        real_weather.setText(mainWeather);
        real_pressure.setText(pressure);
        real_temperature.setText(temperature);
        real_humid.setText(humid);

        // Transform the weather description to icons
        ImageView view=findViewById(R.id.WeatherImage4);
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

        // Display the date, which is 3 days past current day
        Date now=new Date();
        Calendar calendar=new GregorianCalendar();
        calendar.add(calendar.DATE,3);
        Date tom2=calendar.getTime();
        String todayString=new SimpleDateFormat("yyyy-MM-dd").format(tom2);
        TextView third=findViewById(R.id.Day4);
        third.setText(todayString);

        /**
         *  Anonymous swipe listener method on location name, e.g. "Mountain View".
         *  When swipe right is performed on the location text area, a forecast task instance is created for forecast API calls
         *  and passing the information on day 5 to Day5 activity.
         */
        location.setOnTouchListener(new OnSwipeTouchListener(Day4.this) {

            /**
             *  swipeTop: display a pop-up message: "top"
             */
            public void onSwipeTop() {
                Toast.makeText(Day4.this, "top", Toast.LENGTH_SHORT).show();
            }

            /**
             *  swipeRight: display a pop-up message: "right" and trigger a Day 3 activity
             */
            public void onSwipeRight() {
                Toast.makeText(Day4.this, "right", Toast.LENGTH_SHORT).show();
                ForecastAPI forecastAPI=new ForecastAPI();
                ForecastTask forecastTask=new ForecastTask(Day4.this, Day5.class);
                forecastTask.execute(url,"3");

            }

            /**
             *  swipeLeft: display a pop-up message: "left"
             */
            public void onSwipeLeft() {
                Toast.makeText(Day4.this, "left", Toast.LENGTH_SHORT).show();
            }


            /**
             * swipeBottom: display a pop-up message:"bottom"
             */
            public void onSwipeBottom() {
                Toast.makeText(Day4.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });
    }
}

