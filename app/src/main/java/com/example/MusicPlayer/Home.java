package com.example.MusicPlayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.google.android.material.snackbar.Snackbar;

public class Home extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageButton b1 = (ImageButton) findViewById(R.id.b1);
        ImageButton b2 = (ImageButton) findViewById(R.id.b2);
        ImageButton b3 = (ImageButton) findViewById(R.id.b3);
        ImageButton b4 = (ImageButton) findViewById(R.id.b4);
        ImageButton b5 = (ImageButton) findViewById(R.id.b5);
        ImageButton b6 = (ImageButton) findViewById(R.id.b6);


        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Snackbar sb = Snackbar.make(v,"Playing song",Snackbar.LENGTH_LONG);
                sb.show();
                Intent i = new Intent(Home.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });



        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Snackbar sb = Snackbar.make(v,"Coming Soon...",Snackbar.LENGTH_LONG);
                sb.show();
            }
        });

        b4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Snackbar sb = Snackbar.make(v,"Coming Soon...",Snackbar.LENGTH_LONG);
                sb.show();
            }
        });

        b5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Snackbar sb = Snackbar.make(v,"Coming Soon...",Snackbar.LENGTH_LONG);
                sb.show();
            }
        });

        b6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Snackbar sb = Snackbar.make(v,"Coming Soon...",Snackbar.LENGTH_LONG);
                sb.show();
            }
        });

    }
}