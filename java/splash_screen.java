package com.example.drawer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class splash_screen extends AppCompatActivity {

    // Set the delay for the splash screen (in milliseconds)
    private static final long SPLASH_DELAY = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        // Use a Handler to delay the opening of MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start MainActivity
                Intent intent = new Intent(splash_screen.this, SignupActivity.class);
                startActivity(intent);
                finish(); // Finish the splash screen activity
            }
        }, SPLASH_DELAY);
    }
}
