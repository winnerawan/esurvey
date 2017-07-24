package id.ac.dharmaiswara.app.service;

import id.ac.dharmaiswara.app.controller.SurveyController;
import id.ac.dharmaiswara.app.db.DatabaseHelper;
import id.ac.dharmaiswara.app.model.Type;
import id.ac.dharmaiswara.app.model.User;
import id.ac.dharmaiswara.app.utils.Msg;
import id.ac.dharmaiswara.app.utils.SurveyResponse;
import org.mongodb.morphia.Datastore;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, May 2017
 */
public class RESTService {

    private static final String USER_SESSION_ID = "user";

    public Sql2o mysql = null;

    public RESTService(Sql2o mysql) {
        this.mysql = mysql;
    }

    public SurveyResponse mApiRegister(String user_name, String user_email, String user_nim, String user_type) {
        String sql = "INSERT INTO user (user_name, user_email, user_nim, user_type) " +
                "VALUES (:user_name, :user_email, :user_nim, :user_type)";
        try (Connection con = mysql.open()) {
            con.createQuery(sql)
                    .addParameter("user_name", user_name)
                    .addParameter("user_email", user_email)
                    .addParameter("user_nim", user_nim)
                    .addParameter("user_type", user_type)
                    .executeUpdate();
            User user = new User(user_name, user_email, user_nim, user_type);
            return new SurveyResponse(200, Msg.OK(), user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SurveyResponse(500, Msg.Error(), null);
    }

}
