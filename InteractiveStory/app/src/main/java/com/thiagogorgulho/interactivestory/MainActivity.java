package com.thiagogorgulho.interactivestory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    private EditText mNameField;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameField = (EditText)findViewById(R.id.nameText);
        mStartButton = (Button)findViewById(R.id.startButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mNameField.getText().toString();
                if(name.length() == 0 || name.isEmpty()){
                    Toast.makeText(MainActivity.this, "Type an actual Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d(TAG, "Got name from input: " + name);
                StartStory(name);
            }
        });
    }

    private void StartStory(String name) {
        Intent intent = new Intent(this, StoryActivity.class);

        intent.putExtra(getResources().getString(R.string.name_key), name);
        startActivity(intent);
    }
}
