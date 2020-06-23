package dictionary;

public enum RuffleText {
    START_RUFFLE("⚡️МАСШТАБНЫЙ РОЗЫГРЫШ ОТ КАНАЛОВ PCNEWS и ИГРОNEWS\n" +
            "\n" +
            "\uD83E\uDD11 5 призов общей стоимостью более 100000р \n" +
            "\n" +
            "1. Xbox One X - Cyberpunk 2077 Edition \n" +
            "2. ПК за 50к рублей \n" +
            "3. Игровые мышка и клавиатура \n" +
            "4. Игра на ps4 Ghost of Tsushima \n" +
            "5. Игра на ПК Death Stranding\n" +
            "За 4 и 5 места _приз можно забрать деньгами_.\n" +
            " \n" +
            "Всего 3 шага Чтобы выиграть: \n" +
            "\n" +
            "1. [Подписаться на ИгроNews](https://t.me/joinchat/AAAAAE8Rbe5GHA8KEz7Iuw)\n" +
            "2. [Подписаться на PCNEWS](https://t.me/joinchat/AAAAAFP3ozZWnRMiYnGfKQ) \n" +
            "3. Нажать кнопку «участвую» в закрепе обоих каналов\n" +
            "\n" +
            "\n" +
            "\uD83E\uDD16 Итоги подведёт бот 30.07.2020г\n" ),

    END_RUFFLE("⚡️МАСШТАБНЫЙ РОЗЫГРЫШ ОТ КАНАЛОВ PCNEWS и ИГРОNEWS\n" +
            "\n" +
            "\uD83E\uDD11 5 призов общей стоимостью более 100000р \n" +
            "\n" +
            "1. Xbox One X - Cyberpunk 2077 Edition \n" +
            "2. ПК за 50к рублей \n" +
            "3. Игровые мышка и клавиатура \n" +
            "4. Игра на ps4 Ghost of Tsushima \n" +
            "5. Игра на ПК Death Stranding\n" +
            "За 4 и 5 места _приз можно забрать деньгами_.\n" +
            " \n" +
            "Всего 3 шага Чтобы выиграть: \n" +
            "\n" +
            "1. [Подписаться на ИгроNews](https://t.me/joinchat/AAAAAE8Rbe5GHA8KEz7Iuw)\n" +
            "2. [Подписаться на PCNEWS](https://t.me/joinchat/AAAAAFP3ozZWnRMiYnGfKQ) \n" +
            "3. Нажать кнопку «участвую» в закрепе обоих каналов\n" +
            "\n" +
            "\n" +
            "\uD83E\uDD16 Итоги подведёт бот 30.07.2020г\n" +
            "\\*\\*\\*\\*\\*\n" +
            "Победители: [Максим Белкин](https://t.me/pivas21), " +
            "[Морги M](https://t.me/morgisht), " +
            "[Дарья Франц](https://t.me/dariaska01), " +
            "[Frontik](https://t.me/frontikk), " +
            "[Гомэрчик](https://t.me/coldsimsik)"),
    TAKE_PARTICIPANT(" Участвовать");

    private String text;

    RuffleText(String str) {
        this.text = str;
    }

    public String getText() {
        return text;
    }
}
