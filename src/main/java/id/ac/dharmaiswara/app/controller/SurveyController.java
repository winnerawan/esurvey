package id.ac.dharmaiswara.app.controller;

import id.ac.dharmaiswara.app.db.DatabaseHelper;
import id.ac.dharmaiswara.app.utils.Msg;
import id.ac.dharmaiswara.app.utils.SurveyResponse;
import id.ac.dharmaiswara.app.model.UserType;
import org.mongodb.morphia.Datastore;
import org.slf4j.LoggerFactory;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, May 2017
 */
public class SurveyController {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(SurveyController.class);

    private static final String USER_SESSION_ID = "user";

    private static DatabaseHelper helper = new DatabaseHelper();
    private static Datastore datastore = helper.getDataStore();
    private static SurveyResponse response = new SurveyResponse();


    public static SurveyResponse setUserType(UserType type) {
        datastore.save(type);
        return new SurveyResponse(200, Msg.OK(), type);
    }
}
