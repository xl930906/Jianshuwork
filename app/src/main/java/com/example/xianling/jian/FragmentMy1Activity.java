package com.example.xianling.jian;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by xianling on 2016/2/26.
 */
public class FragmentMy1Activity extends Fragment {
    private List<Person3> list=new ArrayList<>();
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my1, container, false);
        listView=(ListView) view.findViewById(R.id.listview_mypager);
        Bmob.initialize(getActivity(),"057b2e5f736d9a43e528f089b560189f");
        BmobQuery<Person3> query=new BmobQuery<>();
        query.findObjects(getActivity(), new FindListener<Person3>() {
            @Override
            public void onSuccess(List<Person3> list) {
                PingLunAdapter adapter=new PingLunAdapter(getActivity(),list);
                listView.setAdapter(adapter);
            }

            @Override
            public void onError(int i, String s) {

            }
        });
        return view;
    }
}