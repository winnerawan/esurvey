package id.ac.dharmaiswara.app.model;

import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;

import java.util.UUID;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, May 2017
 */
public class User {

    @Id
    private UUID user_id;
    @Indexed(options = @IndexOptions(unique = true))
    private String user_nim;
    private String user_name;
    @Indexed(options = @IndexOptions(unique = true))
    private String user_email;

    public User(UUID user_id, String user_nim, String user_name, String user_email) {
        this.user_id = user_id;
        this.user_nim = user_nim;
        this.user_name = user_name;
        this.user_email = user_email;
    }

    public User(String user_nim, String user_name, String user_email) {
        this.user_nim = user_nim;
        this.user_name = user_name;
        this.user_email = user_email;
    }

    public User(String user_nim) {
        this.user_nim = user_nim;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_nim() {
        return user_nim;
    }

    public void setUser_nim(String user_nim) {
        this.user_nim = user_nim;
    }
}
