package time;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TimerTask;

public class SchedulerTask extends TimerTask {
    private final static String URL = "https://www.google.com";

    @Override
    public void run() {
        try {
            URL url = new URL(SchedulerTask.URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            System.out.println(connection.getResponseCode());
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
