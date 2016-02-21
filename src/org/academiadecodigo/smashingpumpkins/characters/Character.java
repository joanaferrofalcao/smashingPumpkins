package org.academiadecodigo.smashingpumpkins.characters;

import org.academiadecodigo.smashingpumpkins.CollisionDetector;
import org.academiadecodigo.smashingpumpkins.field.CardinalPoint;
import org.academiadecodigo.smashingpumpkins.field.Representation;

abstract public class Character {

    private CharacterType type;
    private Representation representation;

    private boolean dead;
    private CollisionDetector collisionDetector;

    // the first "currentCardinalPoint" is set randomly
    private CardinalPoint currentCardinalPoint = CardinalPoint.giveRandomCardinalPoint();

    // prob of changing the direction
    private int probOfChange = 10;

    private int velocity;

    /**
     * constructor - initiates the character with a representation and a CharacterType
     */
    public Character(CharacterType type) {

        this.type = type;
        this.representation = new Representation(type.getPic());

    }

    /**
     * Getters and Setters
     */
    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public CardinalPoint getCurrentCardinalPoint() {
        return currentCardinalPoint;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public Representation getRepresentation() {
        return representation;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getProbOfChange() {
        return probOfChange;
    }

    public void setDirection(CardinalPoint cardinalPoint) {
        currentCardinalPoint = cardinalPoint;
    }

    /**
     * Moves in the direction given by the chooseDirection method
     */
    public void move() {

        CardinalPoint newCardinalPoint = chooseDirection();
        int i = 0;

        while (i < velocity) {
            switch (newCardinalPoint) {
                case NORTH:
                    this.moveNorth();
                    break;
                case EAST:
                    this.moveEast();
                    break;
                case WEST:
                    this.moveWest();
                    break;
                case SOUTH:
                    this.moveSouth();
                    break;
            }

            // it only checks for collisions if the character has a collisionDetector
            // (only the players will have)
            if (collisionDetector != null) {
                collisionDetector.checkForCollisions(this);
            }

            i++;
        }

        currentCardinalPoint = newCardinalPoint;
    }

    /**
     * Makes representation update to direction
     */
    private void moveNorth() {

        representation.updatePositionToNorth();
    }

    private void moveSouth() {

        representation.updatePositionToSouth();
    }

    private void moveEast() {

        representation.updatePositionToEast();
    }

    private void moveWest() {

        representation.updatePositionToWest();
    }

    /**
     * Compares if characters overlap
     */
    public boolean compareCharacterPosition(Character character) {
        return representation.compareRepresentation(character.getRepresentation());
    }

    /**
     * Draws character representation
     */
    public void drawRepresentation() {
        representation.draw();
    }


    /**
     * Changes character representation to a new image
     *
     * @param str new image
     */
    public void changeRepresentationPic(String str) {
        representation.changePic(str);
    }


    /**
     * @return a new random CardinalPoint with probability equal to "probOfChange"
     * or, with probability "1-probOfChange", the currentCardinalPoint
     */
    public CardinalPoint chooseDirection() {

        CardinalPoint cardinalPoint = currentCardinalPoint;

        int i = (int) (Math.random() * 101);
        CardinalPoint newCardinalPoint = cardinalPoint;

        if (i >= this.getProbOfChange()) {
            return newCardinalPoint;
        }

        while (newCardinalPoint == cardinalPoint || cardinalPoint.opposite(newCardinalPoint)) {
            newCardinalPoint = CardinalPoint.giveRandomCardinalPoint();
        }

        return newCardinalPoint;
    }


    @Override
    public String toString() {
        return type.getPic();
    }

}
