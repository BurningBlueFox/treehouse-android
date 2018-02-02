package com.thiagogorgulho.interactivestory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.thiagogorgulho.interactivestory.R;
import com.thiagogorgulho.interactivestory.model.Choice;
import com.thiagogorgulho.interactivestory.model.Page;
import com.thiagogorgulho.interactivestory.model.Story;

import java.util.Stack;

public class StoryActivity extends AppCompatActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();

    private String name;
    private Story story;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button[] storyChoiceButton;
    private Stack<Integer> pageStack = new Stack<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyImageView = (ImageView) findViewById(R.id.imageStoryPage);
        storyTextView = (TextView) findViewById(R.id.storyTextView);
        storyChoiceButton = new Button[]{(Button) findViewById(R.id.firstChoiceButton),
                (Button) findViewById(R.id.secondChoiceButton)};

        Intent intent = getIntent();
        name = intent.getStringExtra(getResources().getString(R.string.name_key));
        Log.d(TAG, name);

        story = new Story();
        LoadPage(0);
    }

    @Override
    public void onBackPressed() {
        pageStack.pop();
        if (pageStack.isEmpty()) {
            super.onBackPressed();
        }else{
            LoadPage(pageStack.pop());
        }

    }

    private void LoadPage(int pageNumber) {
        pageStack.push(pageNumber);

        Page page = story.getPage(pageNumber);
        LoadImage(page);


        LoadText(page);
        if (page.isFinalPage()) {

            LoadPlayAgainButton();
        } else {
            LoadChoice(page);
        }
    }

    private void LoadImage(Page page) {
        // Drawable image = ContextCompat.getDrawable(this, page.getImageId());
        storyImageView.setImageResource(page.getImageId());
    }

    private void LoadText(Page page) {
        String pageText = getString(page.getTextId());
        pageText = String.format(pageText, name);
        storyTextView.setText(pageText);
    }

    private void LoadChoice(Page page) {
        final Choice[] pageChoices = page.getChoices();
        for (int i = 0; i < pageChoices.length; i++) {
            storyChoiceButton[i].setText(pageChoices[i].getTextId());

            final int pageToLoad = pageChoices[i].getNextPage();
            storyChoiceButton[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LoadPage(pageToLoad);
                }
            });
        }
    }

    private void LoadPlayAgainButton() {
        for (int i = 0; i < storyChoiceButton.length; i++) {
            storyChoiceButton[i].setVisibility(View.INVISIBLE);
            if (i == storyChoiceButton.length - 1) {
                storyChoiceButton[i].setVisibility(View.VISIBLE);
                storyChoiceButton[i].setText(R.string.play_again);
                storyChoiceButton[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pageStack.clear();
                        finish();
                    }
                });
            }
        }
    }
}
