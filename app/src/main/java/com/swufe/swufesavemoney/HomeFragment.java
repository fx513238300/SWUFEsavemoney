package com.swufe.swufesavemoney;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.swufe.swufesavemoney.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private ListView listView;
 String data[]={"邦尼游泳馆：次卡买五次（125元）省10元","时光小馆：满49省4元","东北麻辣烫：满18省2元","沈妈砂锅：满20省2元","瑞瑞的纸包鱼：满59省5元","一点点：满12省1元","从云：满25省3元","汉堡王：满25省3元","重庆鸡公煲：满35省4元","爱达乐：满25省3元","尼可熊餐厅：满49省5元","更多优惠，敬请期待！"};
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceSate) {

        View view= inflater.inflate(R.layout.activity_home, container, false);
                listView = (ListView)view.findViewById(R.id.homelist);
              ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,data);
           listView.setAdapter(arrayAdapter);
return view;
    }

    public void OnActivityCreated(Bundle savedInstanceSate) {
        super.onActivityCreated(savedInstanceSate);
        TextView tv = (TextView) getView().findViewById(R.id.homeTextView1);
        tv.setText("详情：");

    }
}
