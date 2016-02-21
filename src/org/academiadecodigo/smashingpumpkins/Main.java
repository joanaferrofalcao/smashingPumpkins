package org.academiadecodigo.smashingpumpkins;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game g = new Game(50); // Creates a game with the given delay

        g.init(); // Creates the characters and randomly puts them in the field

        g.start(); // Starts the game

    }
}
