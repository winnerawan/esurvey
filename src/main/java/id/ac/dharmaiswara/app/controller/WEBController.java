package id.ac.dharmaiswara.app.controller;

import id.ac.dharmaiswara.app.model.Admin;
import id.ac.dharmaiswara.app.model.AdminResult;
import id.ac.dharmaiswara.app.model.LoginResult;
import id.ac.dharmaiswara.app.model.User;
import id.ac.dharmaiswara.app.service.WEBService;
import id.ac.dharmaiswara.app.utils.EndPoint;
import spark.ModelAndView;
import spark.Request;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, May 2017
 */
public class WEBController {

    private static final String USER_SESSION_ID = "user";
    private static final String ADMIN_SESSION_ID = "admin";

    public WEBController(WEBService service) {

        /**=========== ADMIN ============*/

        before("/admin/index", (request, response) -> {
            Admin admin = getAuthenticatedAdmin(request);
            if (admin == null) {
                response.redirect("/admin/login");
            }
        });

        get(EndPoint.WEB.ENDPOINT_ADMIN_LOGIN, (request, response) -> new ModelAndView(null, "admin/login.hbs"), new HandlebarsTemplateEngine());

        post(EndPoint.WEB.ENDPOINT_ADMIN_LOGIN, (request, response) -> {
            Map<String, Object> map = new HashMap<String, Object>();
            String email = request.queryParams("email");
            String password = request.queryParams("password");
            Admin admin = new Admin(email, password);
            AdminResult result = service.adminAuth(email, password);
            if (result != null) {
                map.put("admin", getAuthenticatedAdmin(request));
                response.redirect("../admin/index");
                addAdminAuthenticatedUser(request, admin);
            } else {
                response.redirect("../admin/login");
            }
            return new ModelAndView(map, "../admin/login");
        }, new HandlebarsTemplateEngine());

        get(EndPoint.WEB.ENDPOINT_ADMIN_INDEX, (request, response) -> new ModelAndView(null, "admin/index.hbs"), new HandlebarsTemplateEngine());

        get(EndPoint.WEB.ENDPOINT_ADMIN_SURVEYS, (request, response) -> new ModelAndView(null, "admin/surveys.hbs"), new HandlebarsTemplateEngine());

        /**=========== USER ===========*/

        get(EndPoint.WEB.ENDPOINT_INDEX, (request, response) -> new ModelAndView(null, "index.hbs"), new HandlebarsTemplateEngine());

        get(EndPoint.WEB.ENDPOINT_SURVEY, (request, response) -> new ModelAndView(null, "survey.hbs"), new HandlebarsTemplateEngine());

        get(EndPoint.WEB.ENDPOINT_SURVEYS, (request, response) -> new ModelAndView(null, "surveys.hbs"), new HandlebarsTemplateEngine());

        post(EndPoint.WEB.ENDPOINT_LOGIN, (request, response) -> {
            Map<String, Object> map = new HashMap<>();
            String nim = request.queryParams("nim");
            User user = new User(nim);
            LoginResult result = service.authentication(nim);
            if (result != null) {
                map.put("user", getAuthenticatedUser(request));
                response.redirect("../surveys");
                addAuthenticatedUser(request, user);
            } else {
                response.redirect("/");
            }
            return new ModelAndView(map, "index.hbs");
        }, new HandlebarsTemplateEngine());


    }

    private void addAdminAuthenticatedUser(Request request, Admin a) {
        request.session().attribute(ADMIN_SESSION_ID, a);
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

    private Admin getAuthenticatedAdmin(Request request) {
        return request.session().attribute(ADMIN_SESSION_ID);
    }
}
