package com.example.chers026.tablayoutexample;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager(), MainActivity.this));

        // Give the TabLayout the ViewPager
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        final ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        final int tabsCount = vg.getChildCount();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.e("Tab count", "Unselected = " + tab.getPosition());

                ViewGroup vgTab = (ViewGroup) vg.getChildAt(tab.getPosition());
                TextView view = (TextView) vgTab.findViewById(R.id.txt_title);
                Typeface type = Typeface.createFromAsset(getApplicationContext().getAssets(), "AvenirLTStd-Heavy.otf");
                view.setTypeface(type);

//
//                int tabChildsCount = vgTab.getChildCount();
//                for (int i = 0; i < tabChildsCount; i++) {
//                    View tabViewChild = vgTab.getChildAt(i);
//                    if (tabViewChild instanceof AppCompatTextView) {
//                        Log.e("Tab count", "Infont");
//                        Typeface type = Typeface.createFromAsset(getApplicationContext().getAssets(), "AvenirLTStd-Heavy.otf");
//                        TextView viewChild = (TextView) tabViewChild;
//                        viewChild.setTypeface(type);
//                        viewChild.setAllCaps(false);
//                    }
//                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.e("Tab count", "selected = " + tab.getPosition());

                ViewGroup vgTab = (ViewGroup) vg.getChildAt(tab.getPosition());
                TextView view = (TextView) vgTab.findViewById(R.id.txt_title);
                Typeface type = Typeface.createFromAsset(getApplicationContext().getAssets(), "AvenirLTStd-Roman.otf");
                view.setTypeface(type);

//                ViewGroup vgTab = (ViewGroup) vg.getChildAt(tab.getPosition());
//                int tabChildsCount = vgTab.getChildCount();
//
//                for (int i = 0; i < tabChildsCount; i++) {
//                    View tabViewChild = vgTab.getChildAt(i);
//                    if (tabViewChild instanceof AppCompatTextView) {
//                        Log.e("Tab count", "Infont");
//                        Typeface type = Typeface.createFromAsset(getApplicationContext().getAssets(), "AvenirLTStd-Roman.otf");
//                        TextView viewChild = (TextView) tabViewChild;
//                        viewChild.setTypeface(type);
//                        viewChild.setAllCaps(false);
//                    }
//                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //onTabSelected(tab);
            }
        });

        Log.e("Tab count", "Tabcount = " + tabsCount);

        addCustomLayout(0, 0, R.string.tab1);
        addCustomLayout(1, 0, R.string.tab2);
        addCustomLayout(2, 0, R.string.tab3);
    }

    private void addCustomLayout(final int position, @DrawableRes int drawableId, @StringRes int resId) {
        View v = LayoutInflater.from(this).inflate(R.layout.layout_tab_title, null);
        TextView tabTitle = (TextView) v.findViewById(R.id.txt_title);
        tabTitle.setText(resId);
        tabLayout.getTabAt(position).setCustomView(v);
    }


}





