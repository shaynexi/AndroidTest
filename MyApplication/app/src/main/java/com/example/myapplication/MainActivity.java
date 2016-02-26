package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText et;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.editText);

        btn = (Button) findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        });
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
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
        Log.d("Register", "register");
    }


}
