package dictionary;

public enum RuffleText {
    START_RUFFLE("\uD83D\uDCB0 *Заработали несколько сотен тысяч на продажах рекламы и решили побаловать подписчиков перед новым годом*\n" +
            "\n" +
            "Самый *крупный компьютерный канал* «[Computers World](https://t.me/ComputersWorld_tg)» и *лучший* канал *с бесплатным* программным обеспечением «[Portablik](https://t.me/portablik)»\n" +
            "разыгрывают призы:\n" +
            "\n" +
            "\uD83C\uDFC6 1 место: Видеокарта GIGABYTE nVidia GeForce RTX 2060\n" +
            "\uD83E\uDD48 2 место: Видеокарта GIGABYTE nVidia GeForce GTX 1660SUPER\n" +
            "\uD83E\uDD49 3 место: Видеокарта MSI nVidia GeForce GTX 1650SUPER\n" +
            "\uD83C\uDFAF 4 место: SSD накопитель SAMSUNG 970 EVO Plus MZ-V7S1T0BW 1ТБ\n" +
            "\uD83C\uDFB2 5 место: SSD накопитель SAMSUNG 970 EVO Plus MZ-V7S500BW 500ГБ\n" +
            "\uD83C\uDFC56 место: SSD накопитель SAMSUNG 970 EVO Plus MZ-V7S250BW 250ГБ\n" +
            "\uD83C\uDFC57 место: SSD накопитель SAMSUNG 970 EVO Plus MZ-V7S250BW 250ГБ\n" +
            "\uD83C\uDFC58 место: SSD накопитель SAMSUNG 970 EVO Plus MZ-V7S250BW 250ГБ\n" +
            "\uD83C\uDFB3 9 место: 3000 рублей на QIWI\n" +
            "\uD83C\uDFB3 10 место: 1000 рублей на QIWI\n" +
            "\n" +
            "*Как участвовать?*\n" +
            "✔️Подписаться на [Computers World](https://t.me/ComputersWorld_tg)\n" +
            "✔️Подписаться на [Portablik](https://t.me/portablik)\n" +
            "✔️*Нажать кнопку \"Участвовать\" в закрепе* \n" +
            "✔️Ждать результатов \n" +
            "\n" +
            "_29 ноября рандом-бот определит 10 победителей:_\n" +
            "\n" +
            "*Шансы выиграть есть АБСОЛЮТНО у каждого!*" ),

    END_RUFFLE("\uD83D\uDCB0 *Заработали несколько сотен тысяч на продажах рекламы и решили побаловать подписчиков перед новым годом*\n" +
            "\n" +
            "Самый *крупный компьютерный канал* «[Computers World](https://t.me/ComputersWorld_tg)» и *лучший* канал *с бесплатным* программным обеспечением «[Portablik](https://t.me/portablik)»\n" +
            "разыгрывают призы:\n" +
            "\n" +
            "\uD83C\uDFC6 1 место: Видеокарта GIGABYTE nVidia GeForce RTX 2060\n" +
            "\uD83E\uDD48 2 место: Видеокарта GIGABYTE nVidia GeForce GTX 1660SUPER\n" +
            "\uD83E\uDD49 3 место: Видеокарта MSI nVidia GeForce GTX 1650SUPER\n" +
            "\uD83C\uDFAF 4 место: SSD накопитель SAMSUNG 970 EVO Plus MZ-V7S1T0BW 1ТБ\n" +
            "\uD83C\uDFB2 5 место: SSD накопитель SAMSUNG 970 EVO Plus MZ-V7S500BW 500ГБ\n" +
            "\uD83C\uDFC56 место: SSD накопитель SAMSUNG 970 EVO Plus MZ-V7S250BW 250ГБ\n" +
            "\uD83C\uDFC57 место: SSD накопитель SAMSUNG 970 EVO Plus MZ-V7S250BW 250ГБ\n" +
            "\uD83C\uDFC58 место: SSD накопитель SAMSUNG 970 EVO Plus MZ-V7S250BW 250ГБ\n" +
            "\uD83C\uDFB3 9 место: 3000 рублей на QIWI\n" +
            "\uD83C\uDFB3 10 место: 1000 рублей на QIWI\n" +
            "\n" +
            "*Как участвовать?*\n" +
            "✔️Подписаться на [Computers World](https://t.me/ComputersWorld_tg)\n" +
            "✔️Подписаться на [Portablik](https://t.me/portablik)\n" +
            "✔️*Нажать кнопку \"Участвовать\" в закрепе* \n" +
            "✔️Ждать результатов \n" +
            "\n" +
            "_29 ноября рандом-бот определит 10 победителей:_\n" +
            "\n" +
            "*Шансы выиграть есть АБСОЛЮТНО у каждого!*" +
            "\\*\\*\\*\\*\\*\n" +
            "Победители: [Данил Карпов](https://t.me/karpov_dan),\n" +
            "[Frozen Bi](https://t.me/frozen_frozen01),\n" +
            "[София Би](https://t.me/sofi2100),\n" +
            "[PC MAN](https://t.me/pc_man1),\n" +
            "[Lalipapa](https://t.me/lalipapapa),\n" +
            "[Александ Шведс](https://t.me/aleksander0386),\n" +
            "[Анюта Исаева](https://t.me/annet_isaeva),\n" +
            "[Борис Самсонов](https://t.me/samson_b7),\n" +
            "[Пух Вини Пух](https://t.me/vinistuh),\n" +
            "[Dilshot Han](https://t.me/dilhan77)"),
    TAKE_PARTICIPANT(" Участвовать");

    private String text;

    RuffleText(String str) {
        this.text = str;
    }

    public String getText() {
        return text;
    }
}
