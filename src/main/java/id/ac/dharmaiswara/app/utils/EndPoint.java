package id.ac.dharmaiswara.app.utils;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, May 2017
 */
public class EndPoint {

    private EndPoint() {

    }

    public static class RESTAPI {

        public static String ENDPOINT_SURVEYS = "/api/surveys";
        public static String ENDPOINT_LOGIN = "/api/login";
        public static String ENDPOINT_INDEX = "/api";
        public static String ENDPOINT_REGISTER = "/api/register";
        public static String ENDPOINT_SURVEY = "/api/survey/:survey_id";
        public static String ENDPOINT_QUESTION = "/api/question/:survey_id";
        public static String ENDPOINT_QUESTIONS = "/api/question/:survey_id/:question_id";
        public static String ENDPOINT_QUESTION_BY_QID = "/api/question/:question_id/:question_id";
        public static String ENDPOINT_CHOICE = "/api/choice/:question_id";
    }

    public static class WEB {

        public static final String ENDPOINT_ADMIN_LOGIN = "/admin/login";
        public static final String ENDPOINT_ADMIN_INDEX = "/admin/index";


        public static final String ENDPOINT_LOGIN = "/user/login";
        public static String ENDPOINT_INDEX = "/";
        public static String ENDPOINT_SURVEY = "/survey";
        public static String ENDPOINT_SURVEYS = "/surveys";

        public static String ENDPOINT_ADMIN_SURVEYS = "/admin/surveys";
    }
}
