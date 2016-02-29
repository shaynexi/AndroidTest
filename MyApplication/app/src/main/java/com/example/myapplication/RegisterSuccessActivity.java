package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RegisterSuccessActivity extends AppCompatActivity {

    private TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_success);
        Intent intent = getIntent();
        Bundle bundle =intent.getExtras();
        String name = bundle.getString("str3");
        userName = (TextView) findViewById(R.id.textView7);
        userName.setText(name);
    }
}
