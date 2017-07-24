package id.ac.dharmaiswara.app;


import id.ac.dharmaiswara.app.controller.RESTController;
import id.ac.dharmaiswara.app.controller.WEBController;
import id.ac.dharmaiswara.app.db.MySQLAdapter;
import id.ac.dharmaiswara.app.service.RESTService;
import id.ac.dharmaiswara.app.service.WEBService;
import org.sql2o.Sql2o;

import static spark.Spark.*;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, May 2017
 */
public class SurveyApplication {

    public static void init(MySQLAdapter mySQLAdapter) {

        Sql2o mysql = mySQLAdapter.getMysql();

        staticFileLocation("/public");

        RESTService restService = new RESTService(mysql);
        WEBService webService = new WEBService(mysql);

        new RESTController(restService);
        new WEBController(webService);

    }

    public static void main(MySQLAdapter _mySQLAdapter) {
        init(_mySQLAdapter);
    }

    public static void main(String[] args) {
        init(new MySQLAdapter());
    }
}
