package id.ac.dharmaiswara.app.service;

import id.ac.dharmaiswara.app.model.Admin;
import id.ac.dharmaiswara.app.model.AdminResult;
import id.ac.dharmaiswara.app.model.LoginResult;
import id.ac.dharmaiswara.app.model.User;
import id.ac.dharmaiswara.app.utils.RandomUuidGenerator;
import id.ac.dharmaiswara.app.utils.UuidGenerator;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.logging.Logger;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, May 2017
 */
public class WEBService implements WebModel {

    private static final Logger logger = Logger.getLogger(WEBService.class.getSimpleName());


    public Sql2o mysql = null;
    private UuidGenerator uuidGenerator;


    public WEBService(Sql2o mysql) {
        this.mysql = mysql;
        this.uuidGenerator = new RandomUuidGenerator();
    }

    @Override
    public Admin getAdminByEmail(String email) {
        try (Connection connection = mysql.open()) {
            String query = "SELECT * FROM admin WHERE admin_email = :admin_email";
            return connection.createQuery(query).throwOnMappingFailure(false).addParameter("admin_email", email)
                    .executeAndFetchFirst(Admin.class);
        }
    }

    @Override
    public AdminResult adminAuth(String email, String password) {
        AdminResult result = new AdminResult();
        Admin admin = getAdminByEmail(email);
        boolean match = BCrypt.checkpw(password, admin.getAdmin_password());
        if (match) {
            result.setAdmin(admin);
            return result;
        } else {
            return null;
        }
    }

    @Override
    public LoginResult authentication(String nim) {
        LoginResult result = new LoginResult();
        User user = getUserByNim(nim);
        if (user != null) {
            result.setUser(user);
            return result;
        } else {
            return null;
        }
    }

    @Override
    public User getUserByNim(String nim) {
        try (Connection connection = mysql.open()) {
            String query = "SELECT * FROM user WHERE user_nim = :user_nim";
            return connection.createQuery(query).throwOnMappingFailure(false).addParameter("user_nim", nim)
                    .executeAndFetchFirst(User.class);

        }
    }
}
