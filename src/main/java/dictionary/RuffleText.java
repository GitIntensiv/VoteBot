package dictionary;

public enum RuffleText {
    START_RUFFLE("\uD83D\uDCA3 *Розыгрыш компьютера, PS 5 и Cyberpunk 2077 collector’s edition*\n" +
            "\n" +
            "*Как всегда, всего три простых шага:*\n" +
            "\n" +
            "1. Быть подписчиком [Personal Computer](https://t.me/personalcomputer_tg)\n" +
            "2. Быть подписчиком [ИгроNews](https://t.me/game_new7)\n" +
            "3. Нажать кнопку участвовать в закрепе\n" +
            "\n" +
            "*19 ноября рандом-бот определит 3 победителя:*\n" +
            "\n" +
            "\uD83E\uDD471 место - Компьютер за 100 тысяч рублей (комплектующие выбираете самостоятельно)\n" +
            "\uD83E\uDD482 место - PlayStation 5\n" +
            "\uD83E\uDD493 место - Cyberpunk 2077 collector’s edition\n" +
            "\n" +
            "Желаем удачи \uD83C\uDF40" ),

    END_RUFFLE("\uD83D\uDCA3 *Розыгрыш компьютера, PS 5 и Cyberpunk 2077 collector’s edition*\n" +
            "\n" +
            "*Как всегда, всего три простых шага:*\n" +
            "\n" +
            "1. Быть подписчиком [Personal Computer](https://t.me/personalcomputer_tg)\n" +
            "2. Быть подписчиком [ИгроNews](https://t.me/game_new7)\n" +
            "3. Нажать кнопку участвовать в закрепе\n" +
            "\n" +
            "*19 ноября рандом-бот определит 3 победителя:*\n" +
            "\n" +
            "\uD83E\uDD471 место - Компьютер за 100 тысяч рублей (комплектующие выбираете самостоятельно)\n" +
            "\uD83E\uDD482 место - PlayStation 5\n" +
            "\uD83E\uDD493 место - Cyberpunk 2077 collector’s edition\n" +
            "\n" +
            "Желаем удачи \uD83C\uDF40" +
            "\\*\\*\\*\\*\\*\n" +
            "Победители: [Ⲁⳝⲣⲁⲕⲁⲇⲁⳝⲣⲁ](https://t.me/abrakadabra), " +
            "[Владислав Вотяков](https://t.me/Legkinik), " +
            "[Storm](https://t.me/shtormovoy)"),
    TAKE_PARTICIPANT(" Участвовать");

    private String text;

    RuffleText(String str) {
        this.text = str;
    }

    public String getText() {
        return text;
    }
}
