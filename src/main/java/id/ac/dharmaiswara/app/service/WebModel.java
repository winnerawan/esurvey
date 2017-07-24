package id.ac.dharmaiswara.app.service;

import id.ac.dharmaiswara.app.model.Admin;
import id.ac.dharmaiswara.app.model.AdminResult;
import id.ac.dharmaiswara.app.model.LoginResult;
import id.ac.dharmaiswara.app.model.User;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, July 2017
 */
public interface WebModel {

    LoginResult authentication(String nim);

    User getUserByNim(String nim);

    Admin getAdminByEmail(String email);

    AdminResult adminAuth(String email, String password);
}
