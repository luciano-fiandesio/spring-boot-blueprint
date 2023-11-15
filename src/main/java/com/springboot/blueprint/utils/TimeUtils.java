package com.springboot.blueprint.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@UtilityClass
public class TimeUtils {

    public static OffsetDateTime toUTCOffsetDateTime(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            ZoneOffset offset = ZoneOffset.UTC;
            return localDateTime.atOffset(offset);
        }
        return null;
    }

}
