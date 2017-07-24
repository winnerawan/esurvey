package id.ac.dharmaiswara.app.model;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, May 2017
 */
public class Survey {

    private String survey_id;
    private String survey_title;
    private String survey_description;
    private String survey_created;
    private String survey_status;

    public Survey(String survey_id) {
        this.survey_id = survey_id;
    }

    public Survey(String survey_id, String survey_title, String survey_description, String survey_created, String survey_status) {
        this.survey_id = survey_id;
        this.survey_title = survey_title;
        this.survey_description = survey_description;
        this.survey_created = survey_created;
        this.survey_status = survey_status;
    }

    public String getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(String survey_id) {
        this.survey_id = survey_id;
    }

    public String getSurvey_title() {
        return survey_title;
    }

    public void setSurvey_title(String survey_title) {
        this.survey_title = survey_title;
    }

    public String getSurvey_description() {
        return survey_description;
    }

    public void setSurvey_description(String survey_description) {
        this.survey_description = survey_description;
    }

    public String getSurvey_created() {
        return survey_created;
    }

    public void setSurvey_created(String survey_created) {
        this.survey_created = survey_created;
    }

    public String getSurvey_status() {
        return survey_status;
    }

    public void setSurvey_status(String survey_status) {
        this.survey_status = survey_status;
    }
}
