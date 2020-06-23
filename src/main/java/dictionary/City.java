package dictionary;

public enum City {
    MCK("Москва"),
    KIEV("Киев");

    private String text;

    City(String str) {
        this.text = str;
    }

    public String getText() {
        return text;
    }
}
