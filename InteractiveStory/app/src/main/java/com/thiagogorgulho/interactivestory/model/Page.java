package com.thiagogorgulho.interactivestory.model;

public class Page {
    private int textId;
    private int imageId;
    private Choice choices[];
    private boolean isFinalPage = false;

    public Page(int image,int text, Choice[] choice){
        this.imageId = image;
        this.textId = text;
        this.choices = choice;
        isFinalPage = false;
    }

    public Page(int image, int text) {
        this.textId = text;
        this.imageId = image;
        isFinalPage = true;
    }

    public boolean isFinalPage() { return isFinalPage; }

    public void setFinalPage(boolean finalPage) { isFinalPage = finalPage;}

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Choice[] getChoices() {
        return choices;
    }

    public void setChoices(Choice[] choices) {
        this.choices = choices;
    }
}
