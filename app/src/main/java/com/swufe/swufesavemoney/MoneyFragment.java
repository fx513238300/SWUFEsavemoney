package com.swufe.swufesavemoney;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;


public class MoneyFragment extends Fragment  {
    EditText shengqianma;
    Button btnmoney;
    String number;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceSate) {

        View view = inflater.inflate(R.layout.activity_money, null);
//通过id找到需要被监听的button
        btnmoney= (Button)view.findViewById(R.id.savemoney);
        shengqianma=(EditText)view.findViewById(R.id.number);
        btnmoney.setOnClickListener(new View.OnClickListener(){
            //为找到的button设置监听
            @Override
//重写onClick函数
            public void onClick(View v){
                String sqm=shengqianma.getText().toString();
                if(sqm.equals("123456")){
                    String res=((ThirdActivity)getActivity()).getResult();
                    res= String.valueOf(Integer.parseInt(res)+2);
                    ((ThirdActivity)getActivity()).setResult(res);
                    Log.i("Text","shengqianma"+sqm);
                    Log.i("Text","money"+res);
                    Toast.makeText(getActivity(),"恭喜你！省钱成功！",Toast.LENGTH_SHORT).show();
                }
                else if(sqm.equals("456789")){
                    String res=((ThirdActivity)getActivity()).getResult();
                    res= String.valueOf(Integer.parseInt(res)+3);
                    ((ThirdActivity)getActivity()).setResult(res);
                    Log.i("Text","shengqianma"+sqm);
                    Log.i("Text","money"+res);
                    Toast.makeText(getActivity(),"恭喜你！省钱成功！",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity(),"省钱码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
return view;

    }


    public void OnActivityCreated(Bundle savedInstanceSate) {
        super.onActivityCreated(savedInstanceSate);
        TextView tv = (TextView) getView().findViewById(R.id.moneyTextView1);

        tv.setText("省钱啦：");


    }


}
