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

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText yhm;
    TextView mm;
    public List<HashMap<String,String>> peopleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yhm=(EditText)findViewById(R.id.yonghuming);
        mm=(TextView)findViewById(R.id.mima);
        Button btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(this);
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                SQLHelper sqlHelper=new SQLHelper();
                Connection con=sqlHelper.getConnection();
                peopleList=sqlHelper.getPerson(con);
                Log.i("ThirdActivity","成功"+peopleList);
            }
        };
        new Thread(runnable).start();

    }

    @Override
    public void onClick(View v) {
        String yonghuming=yhm.getText().toString();
        String mima=mm.getText().toString();
        Log.i("Text","yonghuming"+yonghuming);
        Log.i("Text","mima"+mima);
        int a=peopleList.size();
        for(int i=0;i<a;i++){
            String name = String.valueOf(peopleList.get(i).get("name"));
            String password = String.valueOf(peopleList.get(i).get("password"));
            Log.i("Text","name"+name);
            Log.i("Text","password"+password);

            if(yonghuming.equals(name)&&mima.equals(password)){
                Intent start=new Intent(this,ClubActivity.class);
                startActivity(start);
            }else{
                Toast.makeText(this, "用户或密码错误", Toast.LENGTH_SHORT).show();
            }

        }


    }
}
