package com.ja.getdevicelocation;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



    public class ForecastTask extends AsyncTask<String, Void, String[]> {
            Context mainContext;
            Class activityClass;


        public ForecastTask(Context mainContext, Class activityClass){
            this.mainContext=mainContext;
            this.activityClass=activityClass;

        }

        @Override
        protected String[] doInBackground(String... urls) {
            ForecastAPI forecastAPI = new ForecastAPI();
           // String url=forecastAPI.createURL(Double.parseDouble(geos[0]),Double.parseDouble(geos[1]));
            String[] response=new String[3];
            URL forecastURL;

            try {

                forecastURL = new URL(urls[0]);
                response[0]=forecastAPI.makeAPICall(forecastURL);
                response[1]=urls[1];
                response[2]=urls[0];



            } catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }

            return response;
        }


        @Override
        protected void onPostExecute(String[] response) {
            int i=Integer.parseInt(response[1]);
            ForecastAPI forecastAPI = new ForecastAPI();

            List<DailyWeather> res =forecastAPI.getGeoForecast(response[0]);

            Intent intent = new Intent(mainContext, activityClass);

            intent.putExtra("city",res.get(i).getCity());
            intent.putExtra("pressure",res.get(i).getPressure());
            intent.putExtra("humid",res.get(i).getHumid());
            intent.putExtra("mainWeather",res.get(i).getDiscription());
            double temp=res.get(i).getTemMin()/2+res.get(i).getTemMax()/2;
            temp=(double)(Math.round(temp*100)/100.0);
            intent.putExtra("temp",String.valueOf(temp)+" °C");
            intent.putExtra("forecastURL",response[2]);
            mainContext.startActivity(intent);




        }
    }

