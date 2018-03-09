package com.example.willow.csci490_lab_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openConnection("https://jsonplaceholder.typicode.com/users");
    }
    public String openConnection(String url2) {
        /*URL url = null;
        try {
            url = new URL("https://jsonplaceholder.typicode.com/users");
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
        }*/

        TextView textView = findViewById(R.id.textview);

        MyAsync asynctask = new MyAsync(textView);

        asynctask.execute(url2);

        Log.i("Lab_04.onCreate()", "read line");

        return url2;
    }


}
