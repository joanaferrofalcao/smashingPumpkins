package org.academiadecodigo.smashingpumpkins.characters.special_characters;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.smashingpumpkins.characters.Character;
import org.academiadecodigo.smashingpumpkins.characters.CharacterType;
import org.academiadecodigo.smashingpumpkins.field.CardinalPoint;


abstract public class SpecialCharacter extends Character implements KeyboardHandler {

    private Keyboard keyboard;
    private int score;

    /**
     * Constructor
     *
     * @param type CharacterType
     */
    public SpecialCharacter(CharacterType type) {
        super(type);
    }

    /**
     * Getters and setters
     */
    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public int getScore() {
        return score;
    }

    abstract public void configKeys();

    /**
     * Increments the score
     */
    public void incScore() {
        this.score++;
    }

    /**
     * Overrides the chooseDirection to never choose a random direction
     *
     * @return always the currentDirection of the character
     */
    @Override
    public CardinalPoint chooseDirection() {

        return getCurrentCardinalPoint();
    }

}
