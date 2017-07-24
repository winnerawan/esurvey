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

        public static String ENDPOINT_LOGIN = "/api/login";
        public static String ENDPOINT_INDEX = "/api";
        public static String ENDPOINT_REGISTER = "/api/register";
    }

    public static class WEB {

        public static final String ENDPOINT_LOGIN = "/login";
        public static String ENDPOINT_INDEX = "/";
        public static String ENDPOINT_SURVEY = "/survey";
    }
}
