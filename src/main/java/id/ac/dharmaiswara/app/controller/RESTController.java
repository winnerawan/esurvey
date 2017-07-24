package id.ac.dharmaiswara.app.controller;

import id.ac.dharmaiswara.app.model.User;
import id.ac.dharmaiswara.app.service.RESTService;
import id.ac.dharmaiswara.app.utils.ApiEndPoint;
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

        post(ApiEndPoint.RESTAPI.ENDPOINT_REGISTER, (request, response) -> {
            response.type(JSON());
            String user_nim = request.queryParams("user_nim");
            String mEncodedNIM = BCrypt.hashpw(user_nim, BCrypt.gensalt(12));
            return JsonUtil.toJson(service.mApiRegister(request.queryParams("user_name"),
                    request.queryParams("user_email"),
                    mEncodedNIM,
                    request.queryParams("user_type")));
        });


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

