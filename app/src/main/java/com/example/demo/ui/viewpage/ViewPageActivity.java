package com.example.demo.ui.viewpage;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.demo.R;
import com.example.demo.ui.viewpage.fragements.FirstFragment;
import com.example.demo.ui.viewpage.fragements.SecondFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

public class ViewPageActivity extends AppCompatActivity {

    private final String[] mTitles = {"碎片1", "碎片2"};

    private ViewPager mViewPager;
    private SlidingTabLayout mTabLayout;

    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);

        initView();
    }

    private void initView() {
        mFragments.add(new FirstFragment());
        mFragments.add(new SecondFragment());

        mViewPager = findViewById(R.id.view_pager);
        mViewPager.setAdapter(new MyPageAdapter(this.getSupportFragmentManager()));

        mTabLayout = findViewById(R.id.slidingtab);
        mTabLayout.setViewPager(mViewPager, mTitles, this, mFragments);

        mTabLayout.setCurrentTab(0);
    }

    /**
     * fragment 适配器
     */
    private class MyPageAdapter extends FragmentPagerAdapter {
        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }


        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}
