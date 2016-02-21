package org.academiadecodigo.smashingpumpkins.characters;


public class CharacterFactory {

    /**
     * @return a random Character from the selection of CharacterType available, except for the special characters
     */
    public static Character getNewCharacter() {

        //will never return a SPECIAL ONE or a SPECIAL TWO
        CharacterType characterType = CharacterType.values()[(int) (Math.random() * (CharacterType.values().length - 2))];

        Character character = null;

        /**
         * chooses characterType accordingly the index i given as argument
         */
        switch (characterType) {
            case SLOW_CHARACTER:
                character = new SlowCharacter(characterType);
                break;
            case FAST_CHARACTER:
                character = new FastCharacter(characterType);
                break;
        }

        return character;
    }

}
