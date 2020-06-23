package dictionary;

public enum AlertText {
    NOT_SIGNED("Необходимо подписаться на канал "),
    YET_PARTICIPATE("Вы уже участвуете в розыгрыше"),
    START_PARTICIPATE("Вы присоединились к участию в розыгрыще");

    private String text;

    AlertText(String str) {
        this.text = str;
    }

    public String getText() {
        return text;
    }
}
