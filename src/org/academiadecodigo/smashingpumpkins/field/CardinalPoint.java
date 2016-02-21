package org.academiadecodigo.smashingpumpkins.field;

public enum CardinalPoint {

    NORTH,
    SOUTH,
    EAST,
    WEST;

    /**
     * @return random cardinal point
     */
    public static CardinalPoint giveRandomCardinalPoint() {

        int i = (int) (Math.random() * CardinalPoint.values().length);

        return CardinalPoint.values()[i];
    }

    /**
     * @param point cardinal point we want to get the opposite direction of
     * @return opposite cardinal point
     */
    public boolean opposite(CardinalPoint point) {

        boolean aux = false;

        switch (point) {
            case NORTH:
                if (this == SOUTH) {
                    aux = true;
                }
                break;
            case SOUTH:
                if (this == NORTH) {
                    aux = true;
                }
                break;
            case WEST:
                if (this == EAST) {
                    aux = true;
                }
                break;
            case EAST:
                if (this == WEST) {
                    aux = true;
                }
                break;
        }
        return aux;
    }

}
