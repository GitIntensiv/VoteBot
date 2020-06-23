package dictionary;


public enum WorkMessage {
    CHOOSE_LANGUAGE("Выберите язык"),
    CHOOSE_TIMEZONE("Выберите таймзону");

    private String text;

    WorkMessage(String str) {
        this.text = str;
    }

    public String getText() {
        return text;
    }
}
