package com.londonappbrewery.destini;
public class StoryDetails {
    private int mTopAnswer;
    private int mBottomAnswer;
    private int mStory;
    public StoryDetails(int top, int bottom , int story){
        mBottomAnswer = bottom;
        mStory = story;
        mTopAnswer=top;
    }
    public StoryDetails(int story){
        mStory= story;
    }

    public int getTopAnswer() {
        return mTopAnswer;
    }

    public void setTopAnswer(int topAnswer) {
        mTopAnswer = topAnswer;
    }

    public int getBottomAnswer() {
        return mBottomAnswer;
    }

    public void setBottomAnswer(int bottomAnswer) {
        mBottomAnswer = bottomAnswer;
    }

    public int getStory() {
        return mStory;
    }

    public void setStory(int story) {
        mStory = story;
    }
}
