package id.ac.dharmaiswara.app.model;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, July 2017
 */
public class AdminResult {

    private String error;
    private Admin admin;

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public Admin getAdmin() {
        return admin;
    }
    public void setAdmin(Admin user) {
        this.admin = user;
    }
}
