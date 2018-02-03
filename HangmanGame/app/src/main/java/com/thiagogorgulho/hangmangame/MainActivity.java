package com.thiagogorgulho.hangmangame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartGame();
            }
        });
    }

    private String SelectRandomAnswer(){
        String a = "";

        Random r = new Random();
        int n = r.nextInt(3);
        switch (n){
            case 0: a = getString(R.string.answer_0); break;
            case 1: a = getString(R.string.answer_1); break;
            case 2: a = getString(R.string.answer_2); break;
            case 3: a =  getString(R.string.answer_3); break;
        }
            return a;
    }

    private void StartGame(){
        Game game = new Game(SelectRandomAnswer());

        Log.d(TAG, "Game has started");
    }

}
