package id.ac.dharmaiswara.app.model;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, May 2017
 */
public class Choice {

    private String choice_id;
    private String question_id;
    private String choice_text;

    public Choice(String choice_id, String question_id, String choice_text) {
        this.choice_id = choice_id;
        this.question_id = question_id;
        this.choice_text = choice_text;
    }

    public String getChoice_id() {
        return choice_id;
    }

    public void setChoice_id(String choice_id) {
        this.choice_id = choice_id;
    }

    public String getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public String getChoice_text() {
        return choice_text;
    }

    public void setChoice_text(String choice_text) {
        this.choice_text = choice_text;
    }
}
