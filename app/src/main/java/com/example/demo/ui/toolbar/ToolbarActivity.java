package com.example.demo.ui.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.demo.R;

public class ToolbarActivity extends AppCompatActivity {

    private Context mContext;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        mContext = this;

        initView();
    }

    private void initView() {
        toolbar = findViewById(R.id.tba_toolbar);
        toolbar.setTitle("Toolbar Example");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tba_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tba_settings:
                Toast.makeText(mContext, "点击了设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tba_info:
                Toast.makeText(mContext, "点击了关于", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tba_add:
                Toast.makeText(mContext, "点击了添加", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}
