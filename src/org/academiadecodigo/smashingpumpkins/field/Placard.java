package org.academiadecodigo.smashingpumpkins.field;

import org.academiadecodigo.smashingpumpkins.characters.special_characters.SpecialOne;
import org.academiadecodigo.smashingpumpkins.characters.special_characters.SpecialTwo;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;


public class Placard {

    private SpecialOne specialOne;
    private SpecialTwo specialTwo;

    private Text scorePlayer1;
    private Text scorePlayer2;

    /**
     * Constructor - needs to know the two players that are playing
     *
     * @param specialOne player 1
     * @param specialTwo player 2
     */
    public Placard(SpecialOne specialOne, SpecialTwo specialTwo) {
        this.specialOne = specialOne;
        this.specialTwo = specialTwo;
    }

    /**
     * Initializes the placard
     */
    public void init() {

        scorePlayer1 = new Text(Field.MARGIN_LEFT * 2.5, Field.MARGIN_TOP * 2, "0");
        scorePlayer2 = new Text(Field.MARGIN_LEFT * 2.5, Field.MARGIN_TOP * 4, "0");

        scorePlayer1.setColor(Color.BLACK);
        scorePlayer2.setColor(Color.BLACK);

        scorePlayer1.grow(10, 10);
        scorePlayer2.grow(10, 10);

        scorePlayer1.draw();
        scorePlayer2.draw();
    }

    /**
     * Updates the placard score
     */
    public void updatePlacardScore() {

        int score1 = specialOne.getScore();
        int score2 = specialTwo.getScore();

        String stringScorePlayer1 = score1 + "";
        String stringScorePlayer2 = score2 + "";

        scorePlayer1.setText(stringScorePlayer1);
        scorePlayer2.setText(stringScorePlayer2);

    }

    /**
     * Checks the who's the winner of the game, according with their scores
     */
    public void messageWinner() {

        Text text = new Text(500, 325, "SPECIAL TWO WINS!!");
        text.grow(300, 60);
        text.setColor(Color.BLACK);

        if (specialOne.getScore() == specialTwo.getScore()) {

            text.setText("It was a tie!");

        } else if (specialOne.getScore() > specialTwo.getScore()) {

            text.setText("SPECIAL ONE WINS!!");
        }

        text.draw();

    }

}
