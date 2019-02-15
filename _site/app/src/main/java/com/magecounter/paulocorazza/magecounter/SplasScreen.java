package com.magecounter.paulocorazza.magecounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class SplasScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splas_screen);

        Handler handler  = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showSplashScreen();
            }
        },3000);

    }
    private void showSplashScreen(){

        Intent intent = new Intent(SplasScreen.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}
