package com.swufe.swufesavemoney;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MoneyFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceSate) {
        return inflater.inflate(R.layout.activity_money, container);
    }

    public void OnActivityCreated(Bundle savedInstanceSate) {
        super.onActivityCreated(savedInstanceSate);
        TextView tv = (TextView) getView().findViewById(R.id.moneyTextView1);
        tv.setText("省钱啦：");
    }




}
