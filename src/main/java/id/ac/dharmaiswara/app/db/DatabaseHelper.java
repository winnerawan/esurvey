package id.ac.dharmaiswara.app.db;

import com.mongodb.MongoClient;
import id.ac.dharmaiswara.app.model.User;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, May 2017
 */
public class DatabaseHelper {

    private static Morphia morphia = new Morphia();
    private static Datastore datastore = null;

    private static Logger logger = LoggerFactory.getLogger(DatabaseHelper.class);

    public DatabaseHelper() {
        if (!morphia.isMapped(User.class)) {
            morphia.map(User.class);
            initDatastore();
        } else {
            logger.info("Database Class Mapped Already!");
        }
    }

    void initDatastore() {

        MongoClient client = new MongoClient("localhost", 27017);
        datastore = morphia.createDatastore(client, "esurvey");
    }

    public Datastore getDataStore() {
        if(datastore == null) {
            initDatastore();
        }

        return datastore;
    }
}
