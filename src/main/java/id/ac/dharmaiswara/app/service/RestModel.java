package id.ac.dharmaiswara.app.service;

import id.ac.dharmaiswara.app.model.User;
import id.ac.dharmaiswara.app.utils.SurveyResponse;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, July 2017
 */
public interface RestModel {

    /**
     * Register user
     * @param user_name of user
     * @param user_email of user
     * @param user_nim of user
     * @return detail user
     */
    SurveyResponse mApiRegister(String user_name, String user_email, String user_nim);

    User getUserByNim(String nim);
}
