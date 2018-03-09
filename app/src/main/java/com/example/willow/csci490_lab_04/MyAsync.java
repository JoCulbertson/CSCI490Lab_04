package com.example.willow.csci490_lab_04;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Willow on 3/8/2018.
 */

public class MyAsync extends AsyncTask<String, Void, String> {

    private TextView textView;

    public MyAsync(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(String... strings) {
        URL url = null;
        try {
            url = new URL(strings[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection connection = null;
        try {
            connection = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader((connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 0;
        while(i < 20){
            try {
                line += bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
        
        Log.i("Lab_04.onCreate()", "read line");

        return line;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.i("ASYNC", s);
        textView.setText(s);
    }
}
