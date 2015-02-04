package com.example.rajohns.materiallogin;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.gc.materialdesign.views.ButtonRectangle;
import com.pnikosis.materialishprogress.ProgressWheel;

public class MainActivity extends ActionBarActivity {
    ProgressWheel loadingIndicator;
    ButtonRectangle loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingIndicator = (ProgressWheel)findViewById(R.id.progress_wheel);
        loadingIndicator.setVisibility(View.GONE);

        loginButton = (ButtonRectangle)findViewById(R.id.button);
    }

    public void loginTapped(View v) {
        if (loadingIndicator.getVisibility() == View.GONE) {
            showLoading(true);
        }
        else {
            showLoading(false);
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, PostLogin.class));
            }
        }, 4000);

    }

    @Override
    protected void onPause() {
        super.onPause();
        showLoading(false);
    }

    public void showLoading(boolean shouldShowLoading) {
        if (shouldShowLoading) {
            loadingIndicator.setVisibility(View.VISIBLE);
            loginButton.setText("");
        }
        else {
            loadingIndicator.setVisibility(View.GONE);
            loginButton.setText("Login");
        }
    }
}
