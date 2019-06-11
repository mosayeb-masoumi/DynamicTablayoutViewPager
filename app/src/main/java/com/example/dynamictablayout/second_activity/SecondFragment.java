package com.example.dynamictablayout.second_activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dynamictablayout.App;
import com.example.dynamictablayout.R;
import com.example.dynamictablayout.main_activity.MyFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    View view;
    TextView txt;

    public static SecondFragment newInstance(int position) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", position);
        fragment.setArguments(args);
        return fragment;
    }


    int position;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_second, container, false);

        txt = view.findViewById(R.id.txtSecond);
        position = position = getArguments().getInt("someInt", 0);


        txt.setText("" + App.tablist2.get(position));

        return view;
    }


}
