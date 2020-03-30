package com.company;

import java.util.ArrayList;
import java.util.List;


public class Board {
    public int numberOfTokens;
    public List<Token> tokens = new ArrayList<>();

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
    /*umplu tabla de joc cu numere alese random intre 1 si numarul de Token*/
    public Board(int numberOfTokens){
        this.numberOfTokens=numberOfTokens;

        int number=(int)Math.random()*numberOfTokens;
        for(Token i : tokens)
        {
            i.setNumberToken(number);
        }
    }

    public boolean isEmpty()
    {
        if(tokens.size()==0)return false;
        else{
            return true;
        }

    }

    public int getNumberOfTokens() {
        return numberOfTokens;
    }
}
