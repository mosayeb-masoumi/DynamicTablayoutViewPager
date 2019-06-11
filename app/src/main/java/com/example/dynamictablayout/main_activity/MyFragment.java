package com.example.dynamictablayout.main_activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dynamictablayout.App;
import com.example.dynamictablayout.R;
import com.example.dynamictablayout.second_activity.SecondActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    View view;
    Context context;

    // for sendind position
    public static MyFragment newInstance(int position) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", position);
        fragment.setArguments(args);
        return fragment;
    }

    int position;
    TextView txt;
    Button btnnext;
    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my, container, false);

        context=getContext();

        txt=view.findViewById(R.id.txt);
        btnnext=view.findViewById(R.id.btnNext);

        position = getArguments().getInt("someInt", 0);
        txt = view.findViewById(R.id.txt);
//OR     txt.setText("" + App.tabList.get(position));
//OR
        if(position==0)
            txt.setText("aval");
        else if(position==1){
            txt.setText("dovom");
        }
        else if(position==2){
            txt.setText("sevom");
        }


        btnnext.setText("btn"+" " + App.tabList.get(position));

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });


        return view;
    }


}
