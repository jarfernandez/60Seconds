package com.jarfernandez.sixtyseconds;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int seconds = -1;
    private TextView secondsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        if (getActionBar() != null) {
            getActionBar().hide();
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        secondsTextView = findViewById(R.id.secondsTextView);
        secondsTextView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        CountDownTimer countDownTimer = new CountDownTimer(864000000, 1000) {

            @Override
            public void onTick(long milliseconds) {
                updateSeconds();
            }

            @Override
            public void onFinish() {
                MainActivity.this.recreate();
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
