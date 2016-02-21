package org.academiadecodigo.smashingpumpkins.characters.special_characters;

import org.academiadecodigo.smashingpumpkins.characters.CharacterType;
import org.academiadecodigo.smashingpumpkins.characters.special_characters.SpecialCharacter;
import org.academiadecodigo.smashingpumpkins.field.CardinalPoint;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;


public class SpecialTwo extends SpecialCharacter {

    /**
     * constructor - initiates the character position and sets the velocity
     * and asks for keys config.
     *
     * @param type characterType
     */
    public SpecialTwo(CharacterType type) {
        super(type);
        this.setVelocity(4);

        configKeys();
    }

    /**
     * Configures the keys that this player will respond to
     */
    public void configKeys() {

        setKeyboard(new Keyboard(this));

        // add one for each key type
        KeyboardEvent keyUp = new KeyboardEvent();
        keyUp.setKey(KeyboardEvent.KEY_UP);
        keyUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        getKeyboard().addEventListener(keyUp);


        KeyboardEvent keyDown = new KeyboardEvent();
        keyDown.setKey(KeyboardEvent.KEY_DOWN);
        keyDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        getKeyboard().addEventListener(keyDown);


        KeyboardEvent keyLeft = new KeyboardEvent();
        keyLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        getKeyboard().addEventListener(keyLeft);


        KeyboardEvent keyRight = new KeyboardEvent();
        keyRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        getKeyboard().addEventListener(keyRight);

    }


    /**
     * Sets the character currentDirection according to the keyboardEvent that occurred
     *
     * @param keyboardEvent
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                setDirection(CardinalPoint.NORTH);
                break;
            case KeyboardEvent.KEY_DOWN:
                setDirection(CardinalPoint.SOUTH);
                break;
            case KeyboardEvent.KEY_LEFT:
                setDirection(CardinalPoint.WEST);
                break;
            case KeyboardEvent.KEY_RIGHT:
                setDirection(CardinalPoint.EAST);
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
