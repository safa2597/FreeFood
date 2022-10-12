package com.example.freefood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class tabs extends AppCompatActivity {
    private TabLayout tablayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        tablayout = findViewById(R.id.tablayout);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView,new Restaurants())
                .commit();
        /*tablayout.setupWithViewPager(viewPager);
        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new Restaurants(),"restaurants");
        vpAdapter.addFragment(new Associations(),"associations");
        viewPager.setAdapter(vpAdapter);*/
    }
}