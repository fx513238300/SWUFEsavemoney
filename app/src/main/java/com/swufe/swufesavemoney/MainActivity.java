package com.swufe.swufesavemoney;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText yhm;
    TextView mm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yhm=(EditText)findViewById(R.id.yonghuming);
        mm=(TextView)findViewById(R.id.mima);
        Button btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String yonghuming=yhm.getText().toString();
        String mima=mm.getText().toString();
        Log.i("Text","yonghuming"+yonghuming);
        Log.i("Text","mima"+mima);
        if(yonghuming.equals("fx513238300")&mima.equals("19990701fx")){
                     Intent start=new Intent(this,ClubActivity.class);
                     startActivity(start);
        }
                 else{
                     Toast.makeText(this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                 }


    }
}
