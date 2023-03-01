package com.example.food_app_charles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main_Screen extends AppCompatActivity {

    EditText name, email, pass, phone;
    Button btn, nextpage;
    SQL_LITE_HELPER sql_lite_helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        phone = findViewById(R.id.phone);
        btn = findViewById(R.id.btn);
        nextpage = findViewById(R.id.nextpage);

        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Fetch.class);
                startActivity(i);
            }
        });

        sql_lite_helper = new SQL_LITE_HELPER(getApplicationContext());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String useremail = email.getText().toString();
                String userpass = pass.getText().toString();
                String userphone = phone.getText().toString();

                sql_lite_helper.Insertdata(new Data(username, useremail, userpass, userphone));
            }
        });
    }
}