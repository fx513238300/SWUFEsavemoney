package com.swufe.swufesavemoney;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ThirdActivity extends FragmentActivity {
    private Fragment mFragments[];
    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RadioButton rbtHome,rbtMoney,rbtPerson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);



        mFragments=new Fragment[3];
        fragmentManager=getSupportFragmentManager();
        mFragments[0]=fragmentManager.findFragmentById(R.id.fragment_home);
        mFragments[1]=fragmentManager.findFragmentById(R.id.fragment_money);
        mFragments[2]=fragmentManager.findFragmentById(R.id.fragment_person);
        fragmentTransaction=fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);
        fragmentTransaction.show(mFragments[0]).commit();

        rbtHome=(RadioButton)findViewById(R.id.radioHome);
        rbtMoney=(RadioButton)findViewById(R.id.radioMoney);
        rbtPerson=(RadioButton)findViewById(R.id.radioPerson);
        rbtHome.setBackgroundResource(R.drawable.shape3);

        radioGroup=(RadioGroup)findViewById(R.id.bottomGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i("radioGroup","checkId="+checkedId);
                fragmentTransaction=fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);
                rbtHome.setBackgroundResource(R.drawable.shape2);
                rbtMoney.setBackgroundResource(R.drawable.shape2);
                rbtPerson.setBackgroundResource(R.drawable.shape2);
                switch (checkedId){
                    case R.id.radioHome:
                        fragmentTransaction.show(mFragments[0]).commit();
                        rbtHome.setBackgroundResource(R.drawable.shape3);
                        break;
                    case R.id.radioMoney:
                        fragmentTransaction.show(mFragments[1]).commit();
                        rbtMoney.setBackgroundResource(R.drawable.shape3);
                        break;
                    case R.id.radioPerson:
                        fragmentTransaction.show(mFragments[2]).commit();
                        rbtPerson.setBackgroundResource(R.drawable.shape3);
                        break;
                    default:
                        break;
                }
            }
        });








    }
}
