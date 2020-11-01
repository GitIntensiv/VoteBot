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
        this.endRuffle = ZonedDateTime.of(LocalDateTime.of(2020, 11, 3, 14, 40, 0), zone);
        this.isStartMessageSend = false;
        this.isEndMessageSend = false;
        this.bot = new Bot();
    }

    @Override
    public void run() {
        ZoneId zone = ZoneId.of("Europe/Moscow");
        ZonedDateTime now = ZonedDateTime.of(LocalDateTime.now(), zone);
        if (now.isAfter(endRuffle) && !isEndMessageSend) {
            bot.sendEndMessage();
            isEndMessageSend = true;
        }
    }
}
