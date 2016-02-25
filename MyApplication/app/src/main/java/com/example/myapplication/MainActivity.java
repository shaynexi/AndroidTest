package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.editText);

    }

    public void onClick_Event(View v) {
        final String str = et.getText().toString().trim();
        final String pattern = "^[a-z0-9]+([._\\\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$";
        Pattern r =Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        if (m.find()) {
            Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this, "请输入正确格式的邮箱", Toast.LENGTH_SHORT).show();
        }
    }

    public void Register(View v)  {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        intent.setClass(MainActivity.this,RegisterActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
