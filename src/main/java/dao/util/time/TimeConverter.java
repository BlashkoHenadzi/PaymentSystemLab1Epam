package dao.util.time;

import java.sql.Timestamp;
import java.util.Date;

public class TimeConverter {
    public static Date toDate(Timestamp timestamp) {
        return new Date(timestamp.getTime());
    }

    public static Timestamp toTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }
}
