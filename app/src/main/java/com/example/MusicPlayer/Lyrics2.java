package com.example.MusicPlayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Lyrics2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics2);
    }

    public void goBack(View view) {
        Intent homeIntent = new Intent(Lyrics2.this,MainActivity2.class);
        startActivity(homeIntent);
        finish();
    }
}