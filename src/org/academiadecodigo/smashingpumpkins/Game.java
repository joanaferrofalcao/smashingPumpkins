package org.academiadecodigo.smashingpumpkins;

import org.academiadecodigo.smashingpumpkins.characters.*;
import org.academiadecodigo.smashingpumpkins.characters.Character;
import org.academiadecodigo.smashingpumpkins.characters.special_characters.SpecialOne;
import org.academiadecodigo.smashingpumpkins.characters.special_characters.SpecialTwo;
import org.academiadecodigo.smashingpumpkins.field.Field;
import org.academiadecodigo.smashingpumpkins.field.Placard;


public class Game {

    public static final int CHARACTERS = 20;
    public static final int PLAYERS = 2;


    /**
     * Graphical Character Field
     */
    Placard placard;


    /**
     * Containers of characters
     */
    Character[] characters;
    Character[] players;

    /**
     * Animation delay
     */
    int delay;


    /**
     * Constructor
     */
    public Game(int delay) {

        this.delay = delay;

        Field.init();
    }

    /**
     * Creates the characters and randomly puts them in the field
     * Creates the two players and gives them a CollisionDetector
     * Also initiates the Placard with the players
     * And draws all the characters in the field
     */
    public void init() {

        characters = new Character[CHARACTERS];
        players = new Character[PLAYERS];

        CollisionDetector collisionDetector = new CollisionDetector(characters);

        for (int i = 0; i < characters.length; i++) {
            characters[i] = CharacterFactory.getNewCharacter();
        }

        players[0] = new SpecialOne(CharacterType.SPECIAL_ONE);
        players[1] = new SpecialTwo(CharacterType.SPECIAL_TWO);
        players[0].setCollisionDetector(collisionDetector);
        players[1].setCollisionDetector(collisionDetector);

        placard = new Placard((SpecialOne) players[0], (SpecialTwo) players[1]);

        placard.init();
        drawAllCharacters();
    }


    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        boolean stop = true; // exit condition

        while (stop) {

            // Pause for a while
            Thread.sleep(delay);

            // move characters that are not dead
            moveAllCharacters();

            // updates the scores
            placard.updatePlacardScore();

            // checks stop condition
            stop = areAllDead();

        }

        // shows the winner
        placard.messageWinner();

        // exit the game
        Thread.sleep(3000);
        System.exit(0);
    }

    /**
     * Moves all the characters in the game
     */
    private void moveAllCharacters() {

        // only moves characters that aren't dead
        for (Character character : characters) {
            if (!character.isDead()) {
                character.move();
            }
        }

        // moves the players
        for (Character character : players) {
            character.move();
        }
    }


    /**
     * Draw all the characters in the field
     */
    private void drawAllCharacters() {

        // draw characters
        for (Character character : characters) {
            character.drawRepresentation();
        }

        // draw players
        for (Character character : players) {
            character.drawRepresentation();
        }
    }


    /**
     * Game stop condition
     *
     * @return true if not all characters are dead, and false if all characters are dead
     */
    private boolean areAllDead() {

        for (Character character : characters) {

            if (!character.isDead()) {
                return true;
            }
        }

        return false;
    }
}
