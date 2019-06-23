package com.swufe.swufesavemoney;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PersonFragment extends Fragment implements View.OnClickListener {
    TextView result;
    Button btn;
    String res;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceSate) {

        View view = inflater.inflate(R.layout.activity_person, null);
             result=(TextView)view.findViewById(R.id.result);
        btn=(Button)view.findViewById(R.id.tocash);
        btn.setOnClickListener(this);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString("param");
            result.setText(mParam1);
        }
        return view;
    }

    public static PersonFragment newInstance(String text) {
        PersonFragment fragment = new PersonFragment();
        Bundle args = new Bundle();
        args.putString("param", text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        String r=((ThirdActivity)getActivity()).getResult();
        r=r+"元";
        Log.i("Text","result"+r);
        result.setText(r);
    }

    public void OnActivityCreated(Bundle savedInstanceSate) {
        super.onActivityCreated(savedInstanceSate);
        TextView tv = (TextView) getView().findViewById(R.id.personTextView1);
        tv.setText("个人中心");
    }


    @Override
    public void onClick(View v) {

        Uri uri = Uri.parse("https://auth.alipay.com/login/index.htm");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
