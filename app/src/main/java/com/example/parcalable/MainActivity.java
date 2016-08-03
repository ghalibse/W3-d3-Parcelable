package com.example.parcalable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivityTAG_";
    String jsonString = "[\n" +
            "    {\"name\" : \"Juan\", \"age\": 20, \"grade\": 8.1},\n" +
            "    {\"name\" : \"Miguel\", \"age\": 23, \"grade\": 8.3},\n" +
            "    {\"name\" : \"Roberto\", \"age\": 39, \"grade\": 9.3},\n" +
            "    {\"name\" : \"Luis\", \"age\": 19, \"grade\": 6.9},\n" +
            "    {\"name\" : \"Gaudencio\", \"age\": 25, \"grade\": 4.3}\n" +
            "]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void doMagic(View view) {

        Gson gson = new GsonBuilder().create();
        Type listType = new TypeToken<List<Student>>() {
        }.getType();

        ArrayList<Student> students = gson.fromJson(jsonString, listType);

        for (Student student : students) {
            Log.d(TAG, "doMagic3: "
                    + student.name + " "
                    + student.age + " "
                    + student.grade);
        }

        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }
}
