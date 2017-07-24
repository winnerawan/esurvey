package id.ac.dharmaiswara.app.model;

import java.util.List;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, May 2017
 */
public class Question {

    private String question_id;
    private String survey_id;
    private int question_type;
    private String question_text;
    private String question_order;

    private Question question;
    private List<Choice> choices;

    public  Question(Question question, List<Choice> choices) {
        this.question = question;
        this.choices = choices;
    }
    public Question(String question_id, String survey_id, String question_text, String question_order) {
        this.question_id = question_id;
        this.survey_id = survey_id;
        this.question_text = question_text;
        this.question_order = question_order;
    }

    public Question(String question_id, String survey_id, int question_type, String question_text, String question_order, Question question, List<Choice> choices) {
        this.question_id = question_id;
        this.survey_id = survey_id;
        this.question_type = question_type;
        this.question_text = question_text;
        this.question_order = question_order;
        this.question = question;
        this.choices = choices;
    }

    public String getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public String getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(String survey_id) {
        this.survey_id = survey_id;
    }

    public int getQuestion_type() {
        return question_type;
    }

    public void setQuestion_type(int question_type) {
        this.question_type = question_type;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public String getQuestion_order() {
        return question_order;
    }

    public void setQuestion_order(String question_order) {
        this.question_order = question_order;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
