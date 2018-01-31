package com.thiagogorgulho.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FunFactsActivity extends AppCompatActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName();

    private TextView mFactTextView;
    private Button mShowFactButton;
    private RelativeLayout mRelativeLayout;
    private FactBook mFactBook = new FactBook();
    private ColorPallete mColorPallete = new ColorPallete();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        //Assign the view from the layout file to the corresponding variable
        mFactTextView = (TextView)findViewById(R.id.FunFacts);
        mShowFactButton = (Button)findViewById(R.id.ButtonFacts);
        mRelativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);

        ChangeFact();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFact();
            }
        };
        mShowFactButton.setOnClickListener(listener);

    }

    private void ChangeFact(){
        int color = mColorPallete.GetRandomColor();
        mRelativeLayout.setBackgroundColor(color);
        mShowFactButton.setTextColor(color);
        mFactTextView.setText(mFactBook.GetFact());


        Toast.makeText(this, "New Fact generated", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "New fact generated");
    }
}
