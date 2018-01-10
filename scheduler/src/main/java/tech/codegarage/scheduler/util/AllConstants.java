package tech.codegarage.scheduler.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author Md. Rashadul Alam
 */
public class AllConstants {

    //Intent action key
    public static final String INTENT_ACTION_CREATE = "CREATE";
    public static final String INTENT_ACTION_DELETE = "DELETE";
    public static final String INTENT_ACTION_CANCEL = "CANCEL";

    //Session key
    public static final String SESSION_KEY_SCHEDULE_DATA = "SESSION_KEY_SCHEDULE_DATA";
    public static final String SESSION_DEFAULT_VALUE_STRING = "";

    //Intent key
    public static final String INTENT_KEY_SCHEDULE_DATA_ALARM_RECEIVER = "INTENT_KEY_SCHEDULE_DATA_ALARM_RECEIVER";
    public static final String INTENT_KEY_SCHEDULE_DATA_ALARM_SERVICE = "INTENT_KEY_SCHEDULE_DATA_ALARM_SERVICE";

    public static final DateFormat TIME_FORMAT = new SimpleDateFormat("hh:mm aa", Locale.CANADA);
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy", Locale.CANADA);
}