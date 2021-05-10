package com.example.flappy;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static TextView txtScore, txtBestScore, txtScoreOver;
    public static RelativeLayout _rl_gameOver;
    public static Button _btnStart;
    private GameView gv;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(LayoutParams.FLAG_FULLSCREEN, LayoutParams.FLAG_FULLSCREEN);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH = dm.widthPixels;
        Constants.SCREEN_HEIGHT = dm.heightPixels;
        setContentView(R.layout.activity_main);
        txtScore = findViewById(R.id.txt_Score);
        txtBestScore = findViewById(R.id.txt_bestScore);
        txtScoreOver = findViewById(R.id.txt_ScoreOVer);
        _rl_gameOver = findViewById(R.id.rl_gameOver);
        _btnStart = findViewById(R.id.btnStart);
        gv = findViewById(R.id.gv);
        _btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.setStart(true);
                txtScore.setVisibility(View.VISIBLE);
                _btnStart.setVisibility(View.INVISIBLE);
            }
        });
        _rl_gameOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _btnStart.setVisibility(View.VISIBLE);
                _rl_gameOver.setVisibility(View.INVISIBLE);
                gv.setStart(false);
                gv.reset();
            }
        });
        mediaPlayer = MediaPlayer.create(this,R.raw.sillychipsong);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }
}