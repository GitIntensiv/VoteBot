package utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Settings {
    private static Settings instance;
    private static String language;
    private static String timeZone;
    private static boolean isCreateRaffle;

    private int chat1MessageId;
    private int chat2MessageId;

    private Settings(String languageValue, String timeZoneValue, boolean isCreateRaffleValue) {
        language = languageValue;
        timeZone = timeZoneValue;
        isCreateRaffle = isCreateRaffleValue;
    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings("rus", "msс", false);
        }
        return instance;
    }

    public static String getLanguage() {
        if (language.equals("rus")) {
            return "ru";
        }
        if (language.equals("eng")) {
            return "en";
        }
        return language;
    }

    public static void setLanguage(String value) {
        language = value;
    }

    public static ZonedDateTime getTimeZone() {
        ZoneId zoneId = null;
        if (timeZone.equals("mcs")) {
            zoneId = ZoneId.of("Europe/Moscow");
        }
        if (timeZone.equals("kiev")) {
            zoneId = ZoneId.of("Europe/Kiev");
        }
        LocalDateTime ldt = LocalDateTime.now();
        return ldt.atZone(zoneId);
    }

    public static String getTimeZoneText() {
        if (timeZone.equals("msс")) {
            return "Europe/Moscow";
        }
        if (timeZone.equals("kiev")) {
            return "Europe/Kiev";
        }
        return "";
    }

    public static void setTimeZone(String value) {
        timeZone = value;
    }

    public static boolean isCreateRaffle() {
        return isCreateRaffle;
    }

    public static void setCreateRaffle(boolean isCreateRaffle) {
        Settings.isCreateRaffle = isCreateRaffle;
    }

    public int getChat1MessageId() {
        return chat1MessageId;
    }

    public void setChat1MessageId(int chat1MessageId) {
        this.chat1MessageId = chat1MessageId;
    }

    public int getChat2MessageId() {
        return chat2MessageId;
    }

    public void setChat2MessageId(int chat2MessageId) {
        this.chat2MessageId = chat2MessageId;
    }
}
