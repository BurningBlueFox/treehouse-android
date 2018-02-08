package com.thiagogorgulho.hangmangame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    public static final String TAG = GameActivity.class.getSimpleName();
    private TextView answerText;
    private EditText inputField;
    private Button inputButton;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent i = getIntent();

        game = new Game(i.getStringExtra("ans"));

        answerText = (TextView)findViewById(R.id.answerView);
        inputField = (EditText)findViewById(R.id.inputText);
        inputButton = (Button)findViewById(R.id.submitButton);

        answerText.setText(game.GetCurrentProgress());

        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = inputField.getText().toString();
                try{
                    game.ApplyGuess(answer);
                }
                catch (IllegalArgumentException argument){
                    Log.e(TAG, "Exception: " + argument.getMessage());
                }

                UpdateGameScore();
            }
        });
    }

    private void UpdateGameScore(){
        answerText.setText(game.GetCurrentProgress());
        if(game.isWon()){
            inputButton.setVisibility(View.INVISIBLE);
        }
    }
}
