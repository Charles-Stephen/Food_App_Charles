package com.example.food_app_charles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Fetch extends AppCompatActivity {

    Button fetch;
    private SQL_LITE_HELPER sql_lite_helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);

        sql_lite_helper = new SQL_LITE_HELPER(getApplicationContext());

        fetch = findViewById(R.id.fetch);
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<ModelClass> arrayList = sql_lite_helper.Fetchdata();
                for (int i = 0; i < arrayList.size(); i++) {
                    Log.d("Print Data", "id = " + arrayList.get(i).id + "; Name = " + arrayList.get(i).name + "; Email = " + arrayList.get(i).email + "; Password = " + arrayList.get(i).pass + "; Phone = " + arrayList.get(i).phone + ";");
                }
            }
        });

    }
}