package org.academiadecodigo.smashingpumpkins.field;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Representation {

    private static final String RESOURCE_DIR = "resources";

    private int x;
    private int y;

    private Picture picture;

    // set representation size
    private final int REP_SIZE_WIDTH = 36;
    private final int REP_SIZE_HEIGHT = 48;

    // set pic correction to make the collisions look more real
    private final int PIC_CORRECTION = 8;


    /**
     * Constructor - initiates the position in a given x and y
     *
     * @param x   leftmost x coordinate
     * @param y   topmost y coordinate
     * @param str image name
     */
    public Representation(int x, int y, String str) {
        this.x = x;
        this.y = y;

        this.picture = new Picture(x, y, RESOURCE_DIR + "/" + str);
    }

    /**
     * Constructor - initiates the position in a random x and y (inside the field limits)
     *
     * @param str image name
     */
    public Representation(String str) {
        this.x = Field.MARGIN_LEFT + (int) (Math.random() * (Field.getWidth() - REP_SIZE_WIDTH));
        this.y = Field.MARGIN_TOP + (int) (Math.random() * (Field.getHeight() - REP_SIZE_HEIGHT));

        this.picture = new Picture(x, y, RESOURCE_DIR + "/" + str);
    }

    /**
     * setters and getters
     */
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    /**
     * Compares if the representations are overlapping
     *
     * @param representation that is going to compare to
     * @return true if overlapping, false otherwise
     */
    public boolean compareRepresentation(Representation representation) {

        return Math.abs(this.x - representation.getX()) <= (REP_SIZE_WIDTH - PIC_CORRECTION)
                && Math.abs((this.y - representation.getY())) <= (REP_SIZE_HEIGHT - PIC_CORRECTION);
    }


    /**
     * Updates the pic position if the direction that they want to translate to is
     * still inside the field limits
     */
    public void updatePositionToNorth() {

        // checks the field limit
        if (this.y <= Field.MARGIN_TOP) {
            this.y = Field.MARGIN_TOP;
            return;
        }

        this.y--;
        this.picture.translate(0d, -1d); // translates the pic
    }

    public void updatePositionToSouth() {

        if (this.y >= Field.getHeight() + Field.MARGIN_TOP - REP_SIZE_HEIGHT) {
            this.y = Field.getHeight() + Field.MARGIN_TOP - REP_SIZE_HEIGHT;
            return;
        }

        this.y++;
        this.picture.translate(0d, 1d);
    }

    public void updatePositionToEast() {

        if (this.x >= Field.getWidth() + Field.MARGIN_LEFT - REP_SIZE_WIDTH) {
            this.x = Field.getWidth() + Field.MARGIN_LEFT - REP_SIZE_WIDTH;
            return;
        }

        this.x++;
        this.picture.translate(1d, 0d);
    }

    public void updatePositionToWest() {

        if (this.x <= Field.MARGIN_LEFT) {
            this.x = Field.MARGIN_LEFT;
            return;
        }

        this.x--;
        this.picture.translate(-1d, 0d);
    }

    /**
     * Draw the pic of the representation
     */
    public void draw() {
        picture.draw();
    }


    /**
     * Changes the representation pic
     *
     * @param str new image
     */
    public void changePic(String str) {
        picture.load(str);
    }


    @Override
    public String toString() {
        return "Representation{" +
                "col=" + x +
                ", row=" + y +
                '}';
    }
}
