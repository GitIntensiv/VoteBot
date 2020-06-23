package dictionary;

public enum ButtonText {
    CREATE_RAFFLE("Создать розыгрыш"),
    MANAGE_CHANEL("Управление каналами"),
    SETTINGS("Настройки"),
    CHANGE_LANGUAGE("Сменить язык"),
    CHANGE_TIMEZONE("Сменить таймзону"),
    BACK("Назад"),
    BACK_TO_MENU("Назад в главное меню"),
    RAFFLE_TEXT("Пришли мне текст для розыгрыша"),
    CHANGE_TEXT("Изменить текст"),
    CHANGE_TIME("Сменить время окончания"),
    CHANGE_TEXT_BUTTON("Изменить текст кнопки"),
    PUBLICH_RUFFLE("Опубликовать розыгрыш сейчас"),
    MINUS_WINNERS("- победителей"),
    PLUS_WINNERS("+ победителей"),
    CHECK_SUBSCRIPTION("Проверка подписки"),
    CHANGE_CHANELL("Сменить чат/канал");

    private String text;

    ButtonText(String str) {
        this.text = str;
    }

    public String getText() {
        return text;
    }
}
