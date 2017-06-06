package id.ac.dharmaiswara.app.utils;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, May 2017
 */
public class JsonUtil {

    public static String toJson(Object object) {

        return new Gson().toJson(object);

    }

    public static ResponseTransformer json() {

        return JsonUtil::toJson;
    }

    public static String JSON() {
        return "application/json";
    }
}
