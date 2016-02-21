package org.academiadecodigo.smashingpumpkins.characters.special_characters;

import org.academiadecodigo.smashingpumpkins.characters.CharacterType;
import org.academiadecodigo.smashingpumpkins.characters.special_characters.SpecialCharacter;
import org.academiadecodigo.smashingpumpkins.field.CardinalPoint;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;


public class SpecialOne extends SpecialCharacter {

    /**
     * constructor - initiates the character position and sets the velocity
     * and asks for keys config.
     *
     * @param type characterType
     */
    public SpecialOne(CharacterType type) {
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
        KeyboardEvent keyW = new KeyboardEvent();
        keyW.setKey(KeyboardEvent.KEY_W);
        keyW.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        getKeyboard().addEventListener(keyW);


        KeyboardEvent keyS = new KeyboardEvent();
        keyS.setKey(KeyboardEvent.KEY_S);
        keyS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        getKeyboard().addEventListener(keyS);


        KeyboardEvent keyA = new KeyboardEvent();
        keyA.setKey(KeyboardEvent.KEY_A);
        keyA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        getKeyboard().addEventListener(keyA);


        KeyboardEvent keyD = new KeyboardEvent();
        keyD.setKey(KeyboardEvent.KEY_D);
        keyD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        getKeyboard().addEventListener(keyD);


    }

    /**
     * Sets the character currentDirection according to the keyboardEvent that occurred
     *
     * @param keyboardEvent
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_W:
                setDirection(CardinalPoint.NORTH);
                break;
            case KeyboardEvent.KEY_S:
                setDirection(CardinalPoint.SOUTH);
                break;
            case KeyboardEvent.KEY_A:
                setDirection(CardinalPoint.WEST);
                break;
            case KeyboardEvent.KEY_D:
                setDirection(CardinalPoint.EAST);
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
