package com.example.dynamictablayout.main_activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dynamictablayout.App;
import com.example.dynamictablayout.R;

import static com.example.dynamictablayout.App.tabList;

public class MainActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.frameLayout);


//        ArrayList<String> tabList = new ArrayList<>();
//        tabList.add("aval");
//        tabList.add("dovom");
//        tabList.add("sevom");

        tabList.add("aval");
        tabList.add("dovom");
        tabList.add("sevom");


        for (int i = 0; i < tabList.size(); i++) {
            tab.addTab(tab.newTab().setText("" + tabList.get(i)));
        }



        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tab.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));

        tab.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                App.tab_position = 0;
                viewPager.setCurrentItem(tab.getPosition());
                App.tab_position = tab.getPosition();

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
