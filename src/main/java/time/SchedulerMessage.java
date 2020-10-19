package time;

import bot.Bot;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimerTask;

public class SchedulerMessage extends TimerTask {

    private ZonedDateTime endRuffle;
    private boolean isEndMessageSend;
    private Bot bot;
    private boolean flag = false;

    public SchedulerMessage() {
        ZoneId zone = ZoneId.of("Europe/Moscow");
        this.endRuffle = ZonedDateTime.of(LocalDateTime.of(2020, 11, 19, 20, 0, 0), zone);
        this.isEndMessageSend = false;
        this.bot = new Bot();
    }

    @Override
    public void run() {
        ZoneId zone = ZoneId.of("Europe/Moscow");
        ZonedDateTime now = ZonedDateTime.of(LocalDateTime.now(), zone);
        if (!flag) {
            bot.sendEditMessage();
            flag = true;
        }
        if (now.isAfter(endRuffle) && !isEndMessageSend) {
            bot.sendEndMessage();
            isEndMessageSend = true;
        }
    }
}
