package org.academiadecodigo.smashingpumpkins;

import org.academiadecodigo.smashingpumpkins.characters.Character;
import org.academiadecodigo.smashingpumpkins.characters.special_characters.SpecialOne;
import org.academiadecodigo.smashingpumpkins.characters.special_characters.SpecialTwo;


public class CollisionDetector {

    private Character[] characters;

    /**
     * Constructor
     *
     * @param characters array of characters
     */
    public CollisionDetector(Character[] characters) {
        this.characters = characters;
    }

    /**
     * Checks if a given character collides with one of the other characters
     *
     * @param character character that will check if has collided with the other characters
     */
    public void checkForCollisions(Character character) {

        for (Character c : characters) {

            // does not compare with himself
            if (c.equals(character)) {
                continue;
            }

            // checks if the characters are in the same position
            if (c.compareCharacterPosition(character)) {

                if (character instanceof SpecialOne && !c.isDead()) {

                    c.setDead(true); // only change the dead status in non-special characters
                    c.changeRepresentationPic("resources/blood.png"); // change representation in dead characters
                    ((SpecialOne) character).incScore(); // increases player score

                }

                // does the same as above but checks for Special Two instead of Special One
                if (character instanceof SpecialTwo && !c.isDead()) {

                    c.setDead(true);
                    c.changeRepresentationPic("resources/blood.png");
                    ((SpecialTwo) character).incScore();

                }
            }
        }
    }
}
