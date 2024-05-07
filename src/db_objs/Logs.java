package db_objs;

import java.sql.Time;
import java.util.Date;

public class Logs {

    private final int userId;
    private final String actions, modified_by;
    private final Date logsDate;
    private final Time logsTime;

    public Logs(int userId, String actions, String modified_by, Date logsDate, Time logsTime) {
        this.userId = userId;
        this.actions = actions;
        this.modified_by = modified_by;
        this.logsDate = logsDate;
        this.logsTime = logsTime;
    }

    public Time getLogsTime() {
        return logsTime;
    }

    public Date getLogsDate() {
        return logsDate;
    }

    public int getUserId() {
        return userId;
    }

    public String getActions() {
        return actions;
    }

    public String getModifiedBy() {
        return modified_by;
    }

}
