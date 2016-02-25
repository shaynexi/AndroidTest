package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private EditText et3, et4, et5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et3 = (EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);
        et5 = (EditText) findViewById(R.id.editText5);
    }

    public void Register_Check(View v) {
        final String str3 = et3.getText().toString().trim();
        final String str4 = et4.getText().toString().trim();
        final String str5 = et5.getText().toString().trim();
        final String pattern = "^[a-z0-9]+([._\\\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str3);

        if (str4.equals(str5)&&m.find()&&str4.length()>0) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            intent.setClass(RegisterActivity.this,RegisterSuccessActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else if(str4.length()<=0){
            Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
        }
        else if(str5.length()<=0){
            Toast.makeText(RegisterActivity.this, "请确认密码", Toast.LENGTH_SHORT).show();
        }
        else if (str3.length()<=0) {
            Toast.makeText(RegisterActivity.this, "请输入正确格式的邮箱", Toast.LENGTH_SHORT).show();
        }
        else if(str4.equals(str5)){
            Toast.makeText(RegisterActivity.this, "请输入正确格式的邮箱", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(RegisterActivity.this, "请确认密码是否一致", Toast.LENGTH_SHORT).show();
        }
    }
}
