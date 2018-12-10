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

public class SearchInfo extends AppCompatActivity {
    private TextView real_weather, real_pressure, location,real_temperature,real_humid,real_tempMax,real_tempMin, real_Weather2,real_Weather3,real_Weather4,real_Weather5,real_Weather6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_info);
        Intent intent = getIntent();
        String city=intent.getStringExtra("search_city");
        String pressure=intent.getStringExtra("search_pressure");
        String mainWeather=intent.getStringExtra("search_mainWeather");

        String mainWeather2=intent.getStringExtra("search_mainWeather2Image");
        String mainWeather2Info=intent.getStringExtra("search_mainWeather2");
        String mainWeather3=intent.getStringExtra("search_mainWeather3Image");
        String mainWeather3Info=intent.getStringExtra("search_mainWeather3");
        String mainWeather4=intent.getStringExtra("search_mainWeather4Image");
        String mainWeather4Info=intent.getStringExtra("search_mainWeather4");
        String mainWeather5=intent.getStringExtra("search_mainWeather5Image");
        String mainWeather5Info=intent.getStringExtra("search_mainWeather5");
       // String mainWeather6=intent.getStringExtra("search_mainWeather6Image");
        //String mainWeather6Info=intent.getStringExtra("search_mainWeather6");

        String temperature=intent.getStringExtra("search_temperature");
        String tempMax=intent.getStringExtra("search_tempMax");
        String tempMin=intent.getStringExtra("search_tempMin");
        String humid=intent.getStringExtra("search_humid");
        location=findViewById(R.id.search_location);
        real_weather=findViewById(R.id.search_weather);
        real_pressure=findViewById(R.id.search_pressure);
        real_temperature=findViewById(R.id.search_temp);
        real_tempMax=findViewById(R.id.search_tempMax);
        real_tempMin=findViewById(R.id.search_tempMin);
        real_humid=findViewById(R.id.search_humid);
        real_Weather2 =findViewById(R.id.search_tomInfo);
        real_Weather3 =findViewById(R.id.search_thirdInfo);
        real_Weather4 =findViewById(R.id.search_fourthInfo);
        real_Weather5 =findViewById(R.id.search_fifthInfo);
        //real_Weather6 =findViewById(R.id.search_sixthInfo);
        location.setText(city);
        real_weather.setText(mainWeather);
        real_pressure.setText(pressure);
        real_temperature.setText(temperature);
        real_humid.setText(humid);
        real_tempMax.setText(tempMax);
        real_tempMin.setText(tempMin);

        real_Weather2.setText(mainWeather2Info);
        real_Weather3.setText(mainWeather3Info);
        real_Weather4.setText(mainWeather4Info);
        real_Weather5.setText(mainWeather5Info);
       // real_Weather6.setText(mainWeather6Info);



        ImageView view=findViewById(R.id.search_WeatherImage);
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
        ImageView view1=findViewById(R.id.search_tommImage);
        if(mainWeather.toLowerCase().contains("rain")) {
            Picasso.with(this).load(R.drawable.rainy).resize(300,300).into(view1);
        }else if (mainWeather.toLowerCase().contains("snow")) {
            Picasso.with(this).load(R.drawable.snow).resize(300,300).into(view1);
        }else if (mainWeather.toLowerCase().contains("cloud")) {
            Picasso.with(this).load(R.drawable.cloudy).resize(300,300).into(view1);
        }else if (mainWeather.toLowerCase().contains("clear") || mainWeather.toLowerCase().contains("sun")) {
            Picasso.with(this).load(R.drawable.sunny).resize(300,300).into(view1);
        } else if (mainWeather.toLowerCase().contains("fog") || mainWeather.toLowerCase().contains("haze")) {
            Picasso.with(this).load(R.drawable.fog).resize(300,300).into(view1);
        }else{
            Picasso.with(this).load(R.drawable.sunny).resize(300,300).into(view1);
        }
        ImageView view2=findViewById(R.id.search_thirdImage);

        if(mainWeather.toLowerCase().contains("rain")) {
            Picasso.with(this).load(R.drawable.rainy).resize(300,300).into(view2);
        }else if (mainWeather.toLowerCase().contains("snow")) {
            Picasso.with(this).load(R.drawable.snow).resize(300,300).into(view2);
        }else if (mainWeather.toLowerCase().contains("cloud")) {
            Picasso.with(this).load(R.drawable.cloudy).resize(300,300).into(view2);
        }else if (mainWeather.toLowerCase().contains("clear") || mainWeather.toLowerCase().contains("sun")) {
            Picasso.with(this).load(R.drawable.sunny).resize(300,300).into(view2);
        } else if (mainWeather.toLowerCase().contains("fog") || mainWeather.toLowerCase().contains("haze")) {
            Picasso.with(this).load(R.drawable.fog).resize(300,300).into(view2);
        }else{
            Picasso.with(this).load(R.drawable.sunny).resize(300,300).into(view2);
        }

        ImageView view3=findViewById(R.id.search_fourthImage);
        if(mainWeather.toLowerCase().contains("rain")) {
            Picasso.with(this).load(R.drawable.rainy).resize(300,300).into(view3);
        }else if (mainWeather.toLowerCase().contains("snow")) {
            Picasso.with(this).load(R.drawable.snow).resize(300,300).into(view3);
        }else if (mainWeather.toLowerCase().contains("cloud")) {
            Picasso.with(this).load(R.drawable.cloudy).resize(300,300).into(view3);
        }else if (mainWeather.toLowerCase().contains("clear") || mainWeather.toLowerCase().contains("sun")) {
            Picasso.with(this).load(R.drawable.sunny).resize(300,300).into(view3);
        } else if (mainWeather.toLowerCase().contains("fog") || mainWeather.toLowerCase().contains("haze")) {
            Picasso.with(this).load(R.drawable.fog).resize(300,300).into(view3);
        }else{
            Picasso.with(this).load(R.drawable.sunny).resize(300,300).into(view3);
        }

        ImageView view4=findViewById(R.id.search_fifthImage);

        if(mainWeather.toLowerCase().contains("rain")) {
            Picasso.with(this).load(R.drawable.rainy).resize(300,300).into(view4);
        }else if (mainWeather.toLowerCase().contains("snow")) {
            Picasso.with(this).load(R.drawable.snow).resize(300,300).into(view4);
        }else if (mainWeather.toLowerCase().contains("cloud")) {
            Picasso.with(this).load(R.drawable.cloudy).resize(300,300).into(view4);
        }else if (mainWeather.toLowerCase().contains("clear") || mainWeather.toLowerCase().contains("sun")) {
            Picasso.with(this).load(R.drawable.sunny).resize(300,300).into(view4);
        } else if (mainWeather.toLowerCase().contains("fog") || mainWeather.toLowerCase().contains("haze")) {
            Picasso.with(this).load(R.drawable.fog).resize(300,300).into(view4);
        }else{
            Picasso.with(this).load(R.drawable.sunny).resize(300,300).into(view4);
        }


        Date now=new Date();

        Calendar calendar=new GregorianCalendar();
        calendar.add(calendar.DATE,1);
        Date tomorrow1=calendar.getTime();
        String nowAsString=new SimpleDateFormat("yyyy-MM-dd" ).format(now);
        TextView day=findViewById(R.id.search_Day);
        day.setText(nowAsString);
        String tomAsString=new SimpleDateFormat("MM-dd").format(tomorrow1);
        TextView tomorrow=findViewById(R.id.search_tomorrow);
        tomorrow.setText(tomAsString);

        calendar.add(calendar.DATE,1);
        Date tom2=calendar.getTime();
        String thirdAsString=new SimpleDateFormat("MM-dd").format(tom2);
        TextView third=findViewById(R.id.search_third);
        third.setText(thirdAsString);

        calendar.add(calendar.DATE,1);
        Date tom3=calendar.getTime();
        String fourthAsString=new SimpleDateFormat("MM-dd").format(tom3);
        TextView fourth=findViewById(R.id.search_fourth);
        fourth.setText(fourthAsString);

        calendar.add(calendar.DATE,1);
        Date tom4=calendar.getTime();
        String fifthAsString=new SimpleDateFormat("MM-dd").format(tom4);
        TextView fifth=findViewById(R.id.search_fifth);
        fifth.setText(fifthAsString);



        location.setOnTouchListener(new OnSwipeTouchListener(SearchInfo.this) {
            public void onSwipeTop() {
                Toast.makeText(SearchInfo.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Intent intent1=new Intent(SearchInfo.this,TestSwipe.class);
                startActivity(intent1);
            }
            public void onSwipeLeft() {
                Toast.makeText(SearchInfo.this, "left", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {
                Toast.makeText(SearchInfo.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });

    }

}