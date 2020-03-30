package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements Runnable {

    private String playerName;
    private Game game;
    public int oldNumber;
    public int newNumber;
    public int ratie;
    Board board;

    public void setRatie(int ratie) {
        this.ratie = ratie;
    }

    public void setOldNumber(int  number){
        oldNumber=number;
    }
    public void newNumber(int number){
        newNumber=number;
    }
    public Player(String name) {
        this.playerName=name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    private boolean play() throws InterruptedException
    {
        Board board = game.getBoard();
        if (board.isEmpty() || game.isEnded())
        {
            return false;
        }
        for(Player p : game.players)
        {
            p.run();
            if(p.ratie==0) p.ratie=p.getNewNumber()-p.getOldNumber();
            else {
                if((p.getNewNumber()-p.getOldNumber())==ratie) {
                    return true;
                    game.setWinner(p.getPlayerName());
                }
                else return false;
            }
        }


     return true;
    }

    @Override
    public void run() {
        try {

            Random rand = new Random();
            int number =rand.nextInt(50);
            number=number%board.getNumberOfTokens();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String toString()
    {
        return this.playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Game getGame() {
        return game;
    }

    public int getOldNumber() {
        return oldNumber;
    }

    public int getNewNumber() {
        return newNumber;
    }

    public int getRatie() {
        return ratie;
    }
}
