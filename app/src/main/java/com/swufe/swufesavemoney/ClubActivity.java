package com.swufe.swufesavemoney;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ClubActivity extends AppCompatActivity  implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        ImageButton btn=findViewById(R.id.swim);
        btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent start=new Intent(this,ThirdActivity.class);
        startActivity(start);
    }
}
