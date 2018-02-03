package com.thiagogorgulho.hangmangame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    public static final String TAG = GameActivity.class.getSimpleName();
    private TextView answerText;
    private EditText inputField;
    private Button inputButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        answerText = (TextView)findViewById(R.id.answerView);
        inputField = (EditText)findViewById(R.id.inputText);
        inputButton = (Button)findViewById(R.id.submitButton);

        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = inputField.getText().toString();
            }
        });
    }
}
