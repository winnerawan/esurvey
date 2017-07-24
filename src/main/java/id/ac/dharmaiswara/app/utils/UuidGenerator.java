package id.ac.dharmaiswara.app.utils;

import java.util.UUID;

/**
 * Copyright 2017 StudioSoft Kreasi
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, July 2017
 */
public interface UuidGenerator {

    /**
     * Each call should return a different UUID.
     */
    UUID generate();
}
