package com.thiagogorgulho.hangmangame;

public class Game{
    public static final int MAX_MISSES = 7;
    private String hits;
    private String misses;
    public String answer;

    public Game(String answer){
        this.answer = answer.toLowerCase();
        hits = "";
        misses = "";
    }

    private char normalizedGuess(char letter){
        if (! Character.isLetter(letter)){
            throw new IllegalArgumentException("A letter is required");
        }
        letter = Character.toLowerCase(letter);
        if(misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1){
            throw new IllegalArgumentException("Guess has already been made");
        }

        return letter;
    }

    public boolean ApplyGuess(char letter){
        
        letter = normalizedGuess(letter);
        boolean isHit = answer.indexOf(letter) != -1;
        if(isHit){
            hits += letter;
        }else{
            misses += letter;
        }
        return isHit;
    }

    public boolean ApplyGuess(String letters){
        if(letters.length() == 0){
            throw new IllegalArgumentException("Please input a value");
        }
        char firstLetter = letters.charAt(0);
        return ApplyGuess(firstLetter);
    }

    public int getRemainingTries(){
        return MAX_MISSES - misses.length();
    }

    public String GetCurrentProgress(){
        String progress = "";
        for(char letter:answer.toCharArray()){
            char display = '-';
            if(hits.indexOf(letter) != -1){
                display = letter;
            }
            progress += display;
        }

        return progress;
    }

    public boolean isWon(){
        return GetCurrentProgress().indexOf('-') == -1;
    }
}