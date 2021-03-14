package com.example.demo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo.R;
import com.example.demo.ui.drawerlayout.DrawerActivity;
import com.example.demo.ui.json.JsonActivity;
import com.example.demo.ui.swiperefresh.SwipeRefreshActivity;
import com.example.demo.ui.toolbar.ToolbarActivity;
import com.example.demo.ui.viewpage.ViewPageActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Activity mActivity;

    private Button btn_toolbar_example;
    private Button btn_swipe_refresh;
    private Button btn_view_page;
    private Button btn_drawer_layout;
    private Button btn_json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {                            //activity初始化
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivity = MainActivity.this;

        initView();
    }

    private void initView() {
        btn_toolbar_example = findViewById(R.id.btn_toolbar_example);
        btn_toolbar_example.setOnClickListener(this);

        btn_swipe_refresh = findViewById(R.id.btn_swipe_refresh);
        btn_swipe_refresh.setOnClickListener(this);

        btn_view_page = findViewById(R.id.btn_view_page);
        btn_view_page.setOnClickListener(this);

        btn_drawer_layout = findViewById(R.id.btn_drawer_layout);
        btn_drawer_layout.setOnClickListener(this);

        btn_json = findViewById(R.id.btn_json);
        btn_json.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_toolbar_example:
                startActivity(new Intent(mActivity, ToolbarActivity.class));
                break;
            case R.id.btn_swipe_refresh:
                startActivity(new Intent(mActivity, SwipeRefreshActivity.class));
                break;
            case R.id.btn_view_page:
                startActivity(new Intent(mActivity, ViewPageActivity.class));
                break;
            case R.id.btn_drawer_layout:
                startActivity(new Intent(mActivity, DrawerActivity.class));
                break;
            case R.id.btn_json:
                startActivity(new Intent(mActivity, JsonActivity.class));
                break;
            default:
                break;
        }
    }
}
