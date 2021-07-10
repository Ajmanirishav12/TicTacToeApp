package com.example.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Tictac extends AppCompatActivity
{
    //0------>X will start the Game.
    //1--->O  It means O
    int activeplayer=0;
    TextView text;
    Boolean flag=true;
    int count=0;
    ImageView img;
    int[] gamestate = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    public void Playertap (View view)
    {
        img = (ImageView) view;
        int val;
        if(flag==false)
            Restart(view);
        text = findViewById(R.id.txt);
        val = Integer.parseInt(img.getTag().toString());
        if (gamestate[val] == -1) {
            count++;
            gamestate[val] = activeplayer;
            if (activeplayer == 0) {
                img.setImageResource(R.drawable.x);
                text.setText("Player O turn Tap");
                activeplayer = 1;
            } else {
                activeplayer = 0;
                img.setImageResource(R.drawable.o);
                text.setText("Player X turn Tap");
            }
        }
        if ((gamestate[0] == gamestate[1] && gamestate[1] == gamestate[2] && gamestate[0] != -1) || ((gamestate[3] == gamestate[4] && gamestate[4] == gamestate[5] && gamestate[3] != -1)) || (gamestate[6] == gamestate[7] && gamestate[7] == gamestate[8] && gamestate[6] != -1) || (gamestate[0] == gamestate[3] && gamestate[3] == gamestate[6] && gamestate[0] != -1) || (gamestate[1] == gamestate[4] && gamestate[4] == gamestate[7] && gamestate[1] != -1) || (gamestate[2] == gamestate[5] && gamestate[5] == gamestate[8] && gamestate[2] != -1) || (gamestate[0] == gamestate[4] && gamestate[4] == gamestate[8] && gamestate[0] != -1) || (gamestate[2] == gamestate[4] && gamestate[4] == gamestate[6] && gamestate[2] != -1)) {
            if (activeplayer == 1) {
                text.setText("X has Won");
                flag = false;
            }
            else
            {
                text.setText("O has Won");
                flag = false;

            }
        }
        if (count == 9) {
         flag=false;
            Restart(view);
        }

    }

    public void Restart(View view)
    {
        for (int j = 0; j < 9; j++)
        {
            gamestate[j] = -1;
        }
        flag = true;
        text.setText("X turn tap to play");
        activeplayer = 0;
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictac);
    }
}