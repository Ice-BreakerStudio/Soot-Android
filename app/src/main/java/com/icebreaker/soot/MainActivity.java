package com.icebreaker.soot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.icebreaker.soot.adapter.MainActivityViewPagerAdapter;
import com.icebreaker.soot.fragment.MatchFragment;
import com.icebreaker.soot.fragment.MeFragment;
import com.icebreaker.soot.fragment.NewsFragment;


public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    BottomNavigationBar bottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //查找控件
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        bottomNavigationBar=(BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
		
		//设置toolbar
        setSupportActionBar(toolbar);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_news, "新闻"))
                .addItem(new BottomNavigationItem(R.drawable.ic_match, "比赛"))
                .addItem(new BottomNavigationItem(R.drawable.ic_me, "我的"))
                .setFirstSelectedPosition(0)
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {
                switch (position){
                    case 0:
                        viewPager.setCurrentItem(0,true);
                        break;
                    case 1:
                        viewPager.setCurrentItem(1,true);
                        break;
                    case 2:
                        viewPager.setCurrentItem(2,true);
                        break;
                }
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationBar.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        SetupViewPager(viewPager);
    }




    private void SetupViewPager(ViewPager viewPager){
        MainActivityViewPagerAdapter adapter = new MainActivityViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NewsFragment());
        adapter.addFragment(new MatchFragment());
        adapter.addFragment(new MeFragment());
        viewPager.setAdapter(adapter);
    }
}
