package dictionary;

public enum RuffleText {
    START_RUFFLE("\uD83C\uDF81\uD83D\uDCB0*Послезавтра раздача 30000р среди подписчиков AndroHack* \n" +
            "как забрать приз?\n" +
            "\n" +
            "1. Быть подписчиком [AndroHack](https://t.me/AndroHackApp)\n" +
            "2. Подписаться на [Computers World](https://t.me/ComputersWorld_tg)\n" +
            "3. Подписаться на [⚡️ИгроNews](https://t.me/in_gme)⚡️\n" +
            "4. Нажать кнопку участвовать в закрепе одного из каналов\n" +
            "\n" +
            "Тыкнув четыре раза на кнопку ты получишь шанс выиграть:\n" +
            "\uD83E\uDD47*Xiaomi Redmi Note 9 Pro 128 ГБ*\n" +
            "\uD83E\uDD48*TWS Huawei FreeBuds 3i*\n" +
            "\uD83E\uDD49*TWS Xiaomi Mi True Wireless Earbuds Basic S*\n" +
            "\uD83D\uDCB8 *Или просто можешь забрать деньги*\n" +
            "\n" +
            "*3 ноября рандом-бот определит 3 победителя:*\n" +
            "\n" +
            "Удачи мой друг \uD83C\uDF40" ),

    END_RUFFLE("\uD83C\uDF81\uD83D\uDCB0*Послезавтра раздача 30000р среди подписчиков AndroHack* \n" +
            "как забрать приз?\n" +
            "\n" +
            "1. Быть подписчиком AndroHack\n" +
            "2. Подписаться на Computers World\n" +
            "3. Подписаться на ⚡️ИгроNews⚡️\n" +
            "4. Нажать кнопку участвовать в закрепе одного из каналов\n" +
            "\n" +
            "Тыкнув четыре раза на кнопку ты получишь шанс выиграть:\n" +
            "\uD83E\uDD47*Xiaomi Redmi Note 9 Pro 128 ГБ*\n" +
            "\uD83E\uDD48*TWS Huawei FreeBuds 3i*\n" +
            "\uD83E\uDD49*TWS Xiaomi Mi True Wireless Earbuds Basic S*\n" +
            "\uD83D\uDCB8 *Или просто можешь забрать деньги*\n" +
            "\n" +
            "*3 ноября рандом-бот определит 3 победителя:*\n" +
            "\n" +
            "Удачи мой друг \uD83C\uDF40" +
            "\\*\\*\\*\\*\\*\n" +
            "Победители: [Антонина Олешко](https://t.me/bang_v_mang),\n" +
            "[Dom Pérignon](https://t.me/Dom_Perignon_tg),\n" +
            "[Кофейный Задрот](https://t.me/missSofiss)"),
    TAKE_PARTICIPANT(" Участвовать");

    private String text;

    RuffleText(String str) {
        this.text = str;
    }

    public String getText() {
        return text;
    }
}
