package time;

import bot.Bot;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimerTask;

public class SchedulerMessage extends TimerTask {

    private ZonedDateTime startRuffle;
    private ZonedDateTime endRuffle;
    private boolean isStartMessageSend;
    private boolean isEndMessageSend;
    private Bot bot;

    public SchedulerMessage() {
        ZoneId zone = ZoneId.of("Europe/Moscow");
        this.startRuffle = ZonedDateTime.of(LocalDateTime.of(2020, 6, 24, 19, 30, 0), zone);
        this.endRuffle = ZonedDateTime.of(LocalDateTime.of(2020, 7, 30, 19, 0, 0), zone);
        this.isStartMessageSend = false;
        this.isEndMessageSend = false;
        this.bot = new Bot();
    }

    @Override
    public void run() {
        ZoneId zone = ZoneId.of("Europe/Moscow");
        ZonedDateTime now = ZonedDateTime.of(LocalDateTime.now(), zone);
        if (now.isAfter(startRuffle) && !isStartMessageSend) {
            bot.sendStartMessage();
            isStartMessageSend = true;
        }
        if (now.isAfter(endRuffle) && !isEndMessageSend) {
            bot.sendEndMessage();
            isEndMessageSend = true;
        }
    }
}
