package org.academiadecodigo.smashingpumpkins.field;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public final class Field {

    // correct the margin error in simpleGraphics
    public static final int MARGIN_TOP = 10;
    public static final int MARGIN_LEFT = 10;

    private static Picture picture;

    //This class is not supposed to be instantiated
    private Field() {
    }

    /**
     * Initializes the Screen
     */
    public static void init() {

        picture = new Picture(MARGIN_LEFT, MARGIN_TOP, "resources/football_field.jpg");
        picture.draw();
    }

    /**
     * Getters of the field limits
     */
    public static int getWidth() {
        return picture.getWidth();
    }

    public static int getHeight() {
        return picture.getHeight();
    }

}
