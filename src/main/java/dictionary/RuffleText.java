package dictionary;

public enum RuffleText {
    START_RUFFLE("⚡️*РОЗЫГРЫШ НА 100К РУБЛЕЙ ОТ PCNEWS и ИГРОNEWS*\n" +
            "\n" +
            "*1 место*: Xbox One X - Cyberpunk 2077 Edition \n" +
            "*2 место*: ПК за 50к рублей \n" +
            "*3 место*: Игровая мышка и клавиатура \n" +
            "*4 место*: Игра на ps4 Ghost of Tsushima \n" +
            "*5 место*: Игра на ПК Death Stranding\n" +
            "Вместо игр можно забрать деньги \uD83D\uDCB5\n" +
            " \n" +
            "*Всего 3 шага чтобы выиграть*: \n" +
            "\n" +
            "1. [Подписаться на ИгроNews](https://t.me/joinchat/AAAAAE8Rbe5GHA8KEz7Iuw)\n" +
            "2. [Подписаться на PCNEWS](https://t.me/joinchat/AAAAAFP3ozZWnRMiYnGfKQ) \n" +
            "3. Под конкурсным постом нажать кнопку «Участвовать» (бот засчитает ваш клик сразу на двух каналах)\n" +
            "\n" +
            "\n" +
            "\uD83E\uDD16 Итоги подведёт бот 30.07.2020г\n" ),

    END_RUFFLE("⚡️*РОЗЫГРЫШ НА 100К РУБЛЕЙ ОТ PCNEWS и ИГРОNEWS*\n" +
            "\n" +
            "*1 место*: Xbox One X - Cyberpunk 2077 Edition \n" +
            "*2 место*: ПК за 50к рублей \n" +
            "*3 место*: Игровая мышка и клавиатура \n" +
            "*4 место*: Игра на ps4 Ghost of Tsushima \n" +
            "*5 место*: Игра на ПК Death Stranding\n" +
            "Вместо игр можно забрать деньги \uD83D\uDCB5\n" +
            " \n" +
            "*Всего 3 шага чтобы выиграть*: \n" +
            "\n" +
            "1. [Подписаться на ИгроNews](https://t.me/joinchat/AAAAAE8Rbe5GHA8KEz7Iuw)\n" +
            "2. [Подписаться на PCNEWS](https://t.me/joinchat/AAAAAFP3ozZWnRMiYnGfKQ) \n" +
            "3. Под конкурсным постом нажать кнопку «Участвовать» (бот засчитает ваш клик сразу на двух каналах)\n" +
            "\n" +
            "\n" +
            "\uD83E\uDD16 Итоги подведёт бот 30.07.2020г\n"  +
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
