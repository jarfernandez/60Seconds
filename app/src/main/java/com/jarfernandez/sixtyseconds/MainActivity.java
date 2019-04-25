package com.jarfernandez.sixtyseconds;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int seconds = -1;
    private TextView secondsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        secondsTextView = findViewById(R.id.secondsTextView);

        CountDownTimer countDownTimer = new CountDownTimer(864000000, 1000) {

            @Override
            public void onTick(long milliseconds) {
                updateSeconds();
            }

            @Override
            public void onFinish() {
            }
        };

        countDownTimer.start();
    }

    private void updateSeconds() {
        seconds++;
        if (seconds >= 60) {
            seconds = 0;
        }

        if (seconds < 10) {
            secondsTextView.setText(" " + seconds);
        } else {
            secondsTextView.setText("" + seconds);
        }
    }
}
