package id.ac.dharmaiswara.app;


import id.ac.dharmaiswara.app.controller.SurveyController;
import id.ac.dharmaiswara.app.db.DatabaseHelper;
import id.ac.dharmaiswara.app.model.UserType;
import id.ac.dharmaiswara.app.utils.ApiEndPoint;
import id.ac.dharmaiswara.app.utils.JsonUtil;

import static id.ac.dharmaiswara.app.utils.JsonUtil.json;
import static spark.Spark.*;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, May 2017
 */
public class SurveyApplication {

    private SurveyApplication() {

        new DatabaseHelper();

        post(ApiEndPoint.RESTAPI.ENDPOINT_LOGIN, (request, response) -> {
            String userType = request.queryParams("type");
            UserType type = new UserType(userType);
            return JsonUtil.toJson(SurveyController.setUserType(type));
        });
    }


    public static void main(String[] args) {
        new SurveyApplication();
    }
}
