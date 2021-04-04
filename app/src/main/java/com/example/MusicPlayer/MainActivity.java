package com.example.MusicPlayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Button playbutton;
    SeekBar start,end;
    TextView startText,endText;
    MediaPlayer song;
    ImageView imageView;
    Animation animation;
    int SongTotalTime;
    ImageButton next,previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playbutton=findViewById(R.id.play);
        startText=findViewById(R.id.textStart);
        endText=findViewById(R.id.TextEnd);
        imageView=findViewById(R.id.img1);
        animation= AnimationUtils.loadAnimation(this,R.anim.rotation);

        song=MediaPlayer.create(this,R.raw.sayso);
        song.setLooping(true);
        song.seekTo(0);
        song.setVolume(0.5f,0.5f);
        SongTotalTime=song.getDuration();


        start=findViewById(R.id.PlayLine);
        start.setMax(SongTotalTime);
        start.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser)
                {
                    song.seekTo(progress);
                    start.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        end=findViewById(R.id.volume1);
        end.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume=progress/100f;
                song.setVolume(volume,volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (song !=null)
                {
                    try {
                        Message message=new Message();
                        message.what=song.getCurrentPosition();
                        handler.sendMessage(message);
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException ignored)
                    {

                    }
                }
            }
        }).start();

    }


    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler()
    {
        @SuppressLint("SetText18n")
        @Override
        public void handleMessage (Message message)
        {
            int SeekBarPosition=message.what;
            start.setProgress(SeekBarPosition);

            String Time=createTimeText(SeekBarPosition);
            startText.setText(Time);

            String remainingTime=createTimeText(SongTotalTime - SeekBarPosition);
            endText.setText("- "+remainingTime);

        }

    };


    public String createTimeText(int time)
    {
        String timeText;
        int min=time/1000/60;
        int sec=time/1000%60;
        timeText=min+":";
        if(sec<10) timeText+="0";
        timeText += sec;
        return timeText;
    }


    public void playButton(View view) {
        if(!song.isPlaying())
        {
            song.start();
            imageView.startAnimation(animation);
            playbutton.setBackgroundResource(R.drawable.ic_baseline_pause_24);
        }
        else{
            song.pause();
            imageView.clearAnimation();
            playbutton.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24);
        }

    }

    public void lyrics(View view) {
        Intent i = new Intent(this, Lyrics.class);
        startActivity(i);
        finish();
    }

    public void fav(View view) {
        Snackbar sb = Snackbar.make(view,"Added to your favourites...",Snackbar.LENGTH_LONG);
        sb.show();
    }

    public void previous(View view) {
        Snackbar sb = Snackbar.make(view,"Not Available now..",Snackbar.LENGTH_LONG);
        sb.show();
    }

    public void next(View view) {
        Intent i=new Intent(this,MainActivity2.class);
        startActivity(i);
        finish();
    }
}