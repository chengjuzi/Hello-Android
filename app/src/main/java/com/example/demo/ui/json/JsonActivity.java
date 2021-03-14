package com.example.demo.ui.json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.demo.R;
import com.example.demo.beans.App;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JsonActivity extends AppCompatActivity {

    private final String url = "http://aimer.neige.icu/index.json";

    private Context mContext;

    private ProgressBar progressBar;
    private Button getData;

    private TextView text1_name;
    private TextView text1_version;
    private TextView text2_name;
    private TextView text2_version;
    private TextView text3_name;
    private TextView text3_version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        mContext = this;
        initView();
    }

    private void initTextView() {
        text1_name = findViewById(R.id.text1_name);
        text1_version = findViewById(R.id.text1_version);
        text2_name = findViewById(R.id.text2_name);
        text2_version = findViewById(R.id.text2_version);
        text3_name = findViewById(R.id.text3_name);
        text3_version = findViewById(R.id.text3_version);
    }

    private void initView() {
        initTextView();

        progressBar = findViewById(R.id.progressbar);

        getData = findViewById(R.id.getdata);
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressBarVisable();
                sendRequestWithOKHttp();
            }
        });
    }

    private void setProgressBarVisable() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void setProgressBarGone() {
        progressBar.setVisibility(View.GONE);
    }

    private void sendRequestWithOKHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                        .url(url)
                        .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    parseJSONWithJSONObject(responseData);
                    setProgressBarGone();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseJSONWithJSONObject(String jsonData) {
        Gson gson = new Gson();
        List<App> appList = gson.fromJson(jsonData, new TypeToken<List<App>>(){}.getType());
        if (appList.size() == 3) {
            text1_name.setText(appList.get(0).getName());
            text1_version.setText(appList.get(0).getVersion());
            text2_name.setText(appList.get(1).getName());
            text2_version.setText(appList.get(1).getVersion());
            text3_name.setText(appList.get(2).getName());
            text3_version.setText(appList.get(2).getVersion());
        }
        else {
            text1_name.setText("Error");
            text1_version.setText("Error");
            text2_name.setText("Error");
            text2_version.setText("Error");
            text3_name.setText("Error");
            text3_version.setText("Error");
        }
    }
}
