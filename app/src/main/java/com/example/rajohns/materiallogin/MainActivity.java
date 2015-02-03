package com.example.rajohns.materiallogin;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.gc.materialdesign.views.ButtonRectangle;
import com.pnikosis.materialishprogress.ProgressWheel;


public class MainActivity extends Activity {
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

        startActivity(new Intent(this, PostLogin.class));
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
