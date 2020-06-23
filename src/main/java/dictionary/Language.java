package dictionary;

public enum Language {
    RU("Русский"),
    EN("Английский");

    private String text;

    Language(String str) {
        this.text = str;
    }

    public String getText() {
        return text;
    }
}
