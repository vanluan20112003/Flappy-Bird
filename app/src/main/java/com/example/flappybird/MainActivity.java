package com.example.flappybird;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static TextView txt_Score, txt_best_score, txt_game_over, txt_score_over;
    public static RelativeLayout rl_game_over;
    public  static Button btn_start;
    private GameView gv;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH = dm.widthPixels;
        Constants.SCREEN_HEIGHT = dm.heightPixels;
        setContentView(R.layout.activity_main);
        txt_Score= findViewById(R.id.txt_score);
        txt_best_score=findViewById(R.id.txt_best_score);
        txt_score_over=findViewById(R.id.txt_score_over);
        rl_game_over=findViewById(R.id.rl_game_over);
        btn_start=findViewById(R.id.btnStart);
        gv=findViewById(R.id.gv);
        rl_game_over.setVisibility(View.INVISIBLE);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.setStart(true);
                txt_Score.setVisibility(View.VISIBLE);
                btn_start.setVisibility(View.INVISIBLE);
                rl_game_over.setVisibility(View.INVISIBLE);
               //txt_game_over.setVisibility(View.INVISIBLE);
//                txt_score_over.setVisibility(View.INVISIBLE);
            }
        });
        rl_game_over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_start.setVisibility(View.VISIBLE);
                rl_game_over.setVisibility(View.INVISIBLE);
                gv.setStart(false);
                gv.reset();
            }
        });
        mediaPlayer = MediaPlayer.create(this, R.raw.sillychipsong);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
}