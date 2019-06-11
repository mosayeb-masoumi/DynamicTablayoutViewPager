package com.example.dynamictablayout.second_activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dynamictablayout.App;
import com.example.dynamictablayout.R;
import com.example.dynamictablayout.main_activity.PagerAdapter;

import java.util.ArrayList;

import static com.example.dynamictablayout.App.tabList;

public class SecondActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent i2=getIntent();
        int position = i2.getIntExtra("position",0);


        tab = findViewById(R.id.tabsSecond);
        viewPager = findViewById(R.id.frameLayoutSecond);


        // dasty (if we get list from server we just need that list. just for test we uses three static lists)
        if(position==0){
            App.tablist2 = new ArrayList<>();
            App.tablist2.add("aval1");
            App.tablist2.add("aval2");
            App.tablist2.add("aval3");
            for (int i = 0; i < App.tablist2.size(); i++) {
                tab.addTab(tab.newTab().setText("" + App.tablist2.get(i)));
            }
        }else if(position == 1){
            App.tablist2 = new ArrayList<>();
            App.tablist2.add("dovom1");
            App.tablist2.add("dovom2");
            App.tablist2.add("dovom3");
            for (int i = 0; i < App.tablist2.size(); i++) {
                tab.addTab(tab.newTab().setText("" + App.tablist2.get(i)));
            }
        }else if(position == 2) {
            App.tablist2 = new ArrayList<>();
            App.tablist2.add("sevom1");
            App.tablist2.add("sevom2");
            App.tablist2.add("sevom3");
            for (int i = 0; i < App.tablist2.size(); i++) {
                tab.addTab(tab.newTab().setText("" + App.tablist2.get(i)));
            }

        }



        PagerAdapter2 adapter = new PagerAdapter2(getSupportFragmentManager(), tab.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));

        tab.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//Bonus Code : If your tab layout has more than 2 tabs then tab will scroll other wise they will take whole width of the screen
//        if (tab.getTabCount() == 2) {
        if (App.tabList.size() <= 3) {
            tab.setTabMode(TabLayout.MODE_FIXED);
        } else {
            tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        }

    }
}
