package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStory;
    Button mTopButton;
    Button mLowButton ;
    int mIndex;
    StoryDetails[] mStoryProgress = new StoryDetails[]{
            new StoryDetails(R.string.T1_Ans1,R.string.T1_Ans2,R.string.T1_Story),
            new StoryDetails(R.string.T2_Ans1,R.string.T2_Ans2,R.string.T2_Story),
            new StoryDetails(R.string.T3_Ans1,R.string.T3_Ans2,R.string.T3_Story),
            new StoryDetails(R.string.T4_End),
            new StoryDetails(R.string.T5_End),
            new StoryDetails(R.string.T6_End),
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        if(savedInstanceState!=null)
            mIndex=savedInstanceState.getInt("IndexKey");
        else
            mIndex=0;

        mLowButton= (Button)findViewById(R.id.buttonBottom);
        mTopButton= (Button)findViewById(R.id.buttonTop);
        mStory = (TextView) findViewById(R.id.storyTextView);
        updateStory(mStoryProgress[mIndex]);
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIndex==0||mIndex==1) {
                    mIndex=2;
                    updateStory(mStoryProgress[mIndex]);
                }
                else if(mIndex==2){
                    mIndex=5;
                    updateStory(mStoryProgress[mIndex]);
                }
                else
                    return;
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mLowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIndex==0){
                    mIndex=1;
                    updateStory(mStoryProgress[mIndex]);
                }
                else if(mIndex==1){
                    mIndex=3;
                    updateStory(mStoryProgress[mIndex]);
                }
                else if(mIndex==2){
                    mIndex=4;
                    updateStory(mStoryProgress[mIndex]);
                }
                else
                    return;

            }
        });

    }
    public void updateStory(StoryDetails Story){
        mStory.setText(Story.getStory());
        if(Story.getBottomAnswer()==0||Story.getTopAnswer()==0){
            mTopButton.setVisibility(View.GONE);
            mLowButton.setVisibility(View.GONE);
            return;
        }
        mTopButton.setText(Story.getTopAnswer());
        mLowButton.setText(Story.getBottomAnswer());

    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("IndexKey",mIndex);
    }
}

