package net.andresbustamante.example.common.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateUtils {

    public static final ZoneId CET = ZoneId.of("CET");

    private DateUtils() {
        // no-op
    }

    public static ZonedDateTime getCurrentDateTime() {
        return ZonedDateTime.now(CET);
    }
}
