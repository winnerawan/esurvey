package id.ac.dharmaiswara.app.controller;

import id.ac.dharmaiswara.app.model.User;
import id.ac.dharmaiswara.app.service.RESTService;
import id.ac.dharmaiswara.app.utils.EndPoint;
import id.ac.dharmaiswara.app.utils.JsonUtil;
import org.springframework.security.crypto.bcrypt.BCrypt;
import spark.Request;

import static id.ac.dharmaiswara.app.utils.JsonUtil.JSON;
import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, May 2017
 */
public class RESTController {

    private static final String USER_SESSION_ID = "user";

    public RESTController(RESTService service) {

        post(EndPoint.RESTAPI.ENDPOINT_REGISTER, (request, response) -> {
            response.type(JSON());
            //String mEncodedNIM = BCrypt.hashpw(user_nim, BCrypt.gensalt(12));
            return JsonUtil.toJson(service.mApiRegister(
                    request.queryParams("user_nim"),
                    request.queryParams("user_name"),
                    request.queryParams("user_email")));
        });

        post(EndPoint.RESTAPI.ENDPOINT_LOGIN, (request, response) -> {
            response.type(JSON());
            return JsonUtil.toJson(service.mApiLogin(request.queryParams("user_nim")));
        });

        get(EndPoint.RESTAPI.ENDPOINT_SURVEYS, (request, response) -> {
            response.type(JSON());
            return JsonUtil.toJson(service.mApiSurveyList());
        });

        get(EndPoint.RESTAPI.ENDPOINT_SURVEY, (request, response) -> {
            response.type(JSON());
            return JsonUtil.toJson(service.mApiSurvey(request.params("survey_id")));
        });

        get(EndPoint.RESTAPI.ENDPOINT_QUESTION, (request, response) -> {
            response.type(JSON());
            return JsonUtil.toJson(service.mApiQuestion(request.params("survey_id")));
        });

        get(EndPoint.RESTAPI.ENDPOINT_QUESTIONS, (request, response) -> {
            response.type(JSON());
            return JsonUtil.toJson(service.mApiQuestion(
                    request.params("survey_id"), request.params("question_id")));
        });

        get(EndPoint.RESTAPI.ENDPOINT_CHOICE, (request, response) -> {
            response.type(JSON());
            return JsonUtil.toJson(service.mApiChoice(request.params("question_id")));
        });
//
//        get(EndPoint.RESTAPI.ENDPOINT_QUESTION_BY_QID, (request, response) -> {
//            response.type(JSON());
//            return JsonUtil.toJson(service.mApiQuestionByQuestioinId(request.params("question_id"),
//                    request.params("question_id")));
//        });



    }
    private void addAuthenticatedUser(Request request, User u) {
        request.session().attribute(USER_SESSION_ID, u);
    }

    private void removeAuthenticatedUser(Request request) {
        request.session().removeAttribute(USER_SESSION_ID);

    }

    private User getAuthenticatedUser(Request request) {
        return request.session().attribute(USER_SESSION_ID);
    }

}

