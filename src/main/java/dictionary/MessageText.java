package dictionary;

public enum MessageText {
    WELCOME_MESSAGE("Привет! Я *VoterBi* и я помогу провести розыгрыш в твоем канале :))"),
    ERROR_MESSAGE("Извини, я не знаю, что ты хочешь :( Попробуй использовать /start");

    private String text;

    MessageText(String str) {
        this.text = str;
    }

    public String getText() {
        return text;
    }
}
