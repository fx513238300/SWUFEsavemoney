package com.swufe.swufesavemoney;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Cluc extends AppCompatActivity implements View.OnClickListener {


    @Override
    public void onClick(View v) {
    }
    public void btnClick(View v) {
        Toast.makeText(this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
    }
}
