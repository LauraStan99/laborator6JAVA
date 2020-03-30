package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game {
    private Board board;
    public List<Player> players = new ArrayList<>();
    public String winner =new String();

    /*
    * se realizeaza creearea un grup de fire de executie cu dimensiune fixa , am ales 5*/
    private static ExecutorService executors = Executors.newFixedThreadPool(5);

    public Game() { }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
        player.setOldNumber(0);
        player.setRatie(0);
    }

    public Game(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    /*
    * synchronized este utilizat pentru a ne asigura ca doar un fir de executie poate accesa resursa in acel moment
    */
    public synchronized void setWinner(Player p) {

            winner = p.getPlayerName();

    }

    /*
    *gestionăm InterruptException pentru intreruperea unui thread care nu inceteaza sa functioneze,
    * parcurgand lista de jucatori le oferim tuturor accesul de a juca
    * se utilizeaza executor pentru ca obiectele de tip Runnable (Players) sa fie trimise pentru a se executa
    *
 */
    public void start() throws InterruptedException  {
        for(Player p : players) {
            executors.execute((Runnable) p);
        }
        executors.shutdown();
        while (!executors.isTerminated()) {
            Thread.sleep(50);
        }
        System.out.println("Winner is " + winner);
    }

    public boolean isEnded()
    {
        return winner != null;
    }
}
