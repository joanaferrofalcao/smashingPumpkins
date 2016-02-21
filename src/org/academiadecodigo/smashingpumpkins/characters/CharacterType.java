package org.academiadecodigo.smashingpumpkins.characters;


public enum CharacterType {

    SLOW_CHARACTER("scarecrow.png"),
    FAST_CHARACTER("scarecrow.png"),
    SPECIAL_ONE("player_1.png"),
    SPECIAL_TWO("player_2.png");

    // image that is going to shown on the representation
    private String pic;

    CharacterType(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }
}
