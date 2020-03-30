package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws InterruptedException
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter any number: ");
        //numarul de token
        int m = scan.nextInt();

        scan.close();

        Token token=new Token();
        token.setNumberToken(m);




        Game game = new Game();
        game.setBoard(new Board(10));
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.start();
    }
}
