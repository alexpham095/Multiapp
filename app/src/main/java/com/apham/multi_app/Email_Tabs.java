package com.apham.multi_app;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Email_Tabs extends AppCompatActivity implements Tab1.OnFragmentInteractionListener,Tab2.OnFragmentInteractionListener,Tab3.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_tabs);

        ViewPager viewPager = (ViewPager) this.findViewById(R.id.pager);
        PagerAdapter myPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPagerAdapter);
        TabLayout tabLayout = (TabLayout) this.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
