package model;

import java.time.LocalDateTime;

public class Ruffle {
    private LocalDateTime endTime;
    private String nameChanel;
    private int countWinners;
    private boolean isSubscription;
    private String buttonText;

    public Ruffle() {
        this.endTime = LocalDateTime.now().plusMinutes(30);
        this.nameChanel = "Test"; // Todo заменить
        this.countWinners = 1;
        this.isSubscription = true;
        this.buttonText = "(0) Участвовать!";
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getNameChanel() {
        return nameChanel;
    }

    public void setNameChanel(String nameChanel) {
        this.nameChanel = nameChanel;
    }

    public int getCountWinners() {
        return countWinners;
    }

    public void setCountWinners(int countWinners) {
        this.countWinners = countWinners;
    }

    public boolean isSubscription() {
        return isSubscription;
    }

    public void setSubscription(boolean subscription) {
        isSubscription = subscription;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getRuffleText() {
        return "Время окончания: " + this.endTime + "\n"
                + "Канал/чат: " + this.nameChanel + "\n"
                + "Количество победителей: " + this.countWinners + "\n"
                + "Проверка на подписку: " + getSubscriptionText() + "\n"
                + "Текст кнопки: " + this.buttonText;
    }

    private String getSubscriptionText() {
        if (this.isSubscription) {
            return "Вкл.";
        } else {
            return "Выкл.";
        }
    }
}
