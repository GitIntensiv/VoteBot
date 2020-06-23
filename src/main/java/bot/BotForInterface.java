package bot;

import dictionary.*;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.CallbackQuery;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import utils.Settings;

import java.util.ArrayList;
import java.util.List;

public class BotForInterface extends TelegramLongPollingBot {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(new BotForInterface());
        } catch (TelegramApiRequestException e) { //ToDo прикрутить логирование
            e.printStackTrace();
        }

    }

    public void onUpdateReceived(Update update) {
        Settings.getInstance();
        Message message = update.getMessage();
        CallbackQuery callbackQuery = update.getCallbackQuery();
        if (message != null && message.hasText()) {
            String messageText = message.getText();
            if (messageText.equals("/start") || messageText.equals(ButtonText.BACK_TO_MENU.getText())) {
                sendMessageWithPanel(message, MessageText.WELCOME_MESSAGE.getText());
//                sendMessageWithPanel(message, "Hello, i am a secret bot");
                return;
            }
            if (messageText.equals(ButtonText.MANAGE_CHANEL.getText())) {
                createPanelManagedChanel(message);
                return;
            }
            if (messageText.equals(ButtonText.CREATE_RAFFLE.getText())) {
                Settings.setCreateRaffle(true);
                getCreateRaffle(message);
                return;
            }
            if (messageText.equals(ButtonText.SETTINGS.getText())) {
                sendMessageWithSettings(message);
                return;
            }
            if (Settings.isCreateRaffle()) {
                // создаем опрос
                createRuffle(message);
                Settings.setCreateRaffle(false);
                return;
            }
            if (message.getForwardFromChat() != null) {
                long chatId = message.getForwardFromChat().getId();
                sendMessageInOtherChat(chatId, "ggggggg");
                return;
            }
            sendMessage(message, MessageText.ERROR_MESSAGE.getText());
        }

        if (callbackQuery != null) {
            String data = callbackQuery.getData();
            if (data.equals("/language")) {

                List<String> name = new ArrayList<>();
                name.add(Language.RU.getText());
                name.add(Language.EN.getText());
                name.add(ButtonText.BACK.getText());

                List<String> dataMessage = new ArrayList<>();
                dataMessage.add("rus");
                dataMessage.add("eng");
                dataMessage.add("backLanguage");

                sendMessageWithLanguageAndTimeZoneSettings(callbackQuery.getMessage(),
                        WorkMessage.CHOOSE_LANGUAGE.getText(), name, dataMessage);
            }
            if (data.equals("/timezone")) {

                List<String> name = new ArrayList<>();
                name.add(City.MCK.getText());
                name.add(City.KIEV.getText());
                name.add(ButtonText.BACK.getText());

                List<String> dataMessage = new ArrayList<>();
                dataMessage.add("mcs");
                dataMessage.add("kiev");
                dataMessage.add("backCity");

                sendMessageWithLanguageAndTimeZoneSettings(callbackQuery.getMessage(),
                        WorkMessage.CHOOSE_TIMEZONE.getText(), name, dataMessage);
            }
            if (data.equals("backLanguage") || data.equals("backCity")) {
                sendMessageWithSettings(callbackQuery.getMessage());
            }
        }
    }


    public String getBotUsername() {
        return "VoterBlBot";
    }

    public String getBotToken() {
        return "1013132905:AAHWCa_gYedoqf6od3GwiSGx7fZQY3hEDH4";
    }

    private void sendMessageWithPanel(Message message, String text) {
        SendMessage sendMessage = createSendMessage(message, text);
        setButtonsPanel(sendMessage);
        sendBaseMessage(sendMessage);
    }

    private void sendMessage(Message message, String text) {
        SendMessage sendMessage = createSendMessage(message, text);
        sendBaseMessage(sendMessage);
    }

    private void sendMessageInOtherChat(Long id, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(id);
        sendMessage.setText(text);
        sendBaseMessage(sendMessage);
    }

    private void sendBaseMessage(SendMessage sendMessage) {
        try {
            sendApiMethod(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private SendMessage createSendMessage(Message message, String text) {
        SendMessage sendMessage = createSendMessage(message);
        sendMessage.setText(text);
        return sendMessage;
    }


    private SendMessage createSendMessage(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId());
        return sendMessage;
    }


    private void setButtonsPanel(SendMessage message) {
        ReplyKeyboardMarkup replyKeyboard = new ReplyKeyboardMarkup();
        message.setReplyMarkup(replyKeyboard);
        replyKeyboard.setSelective(true);
        replyKeyboard.setResizeKeyboard(true);
        replyKeyboard.setOneTimeKeyboard(false);

        List<KeyboardRow> rows = new ArrayList<KeyboardRow>();
        KeyboardRow row1 = new KeyboardRow();

//        row1.add(new KeyboardButton("Secret"));
        row1.add(new KeyboardButton(ButtonText.CREATE_RAFFLE.getText()));
        row1.add(new KeyboardButton(ButtonText.MANAGE_CHANEL.getText()));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton(ButtonText.SETTINGS.getText()));

        rows.add(row1);
        rows.add(row2);

        replyKeyboard.setKeyboard(rows);
    }

    private void sendMessageWithSettings(Message message) {
        String text = getTextOnSettings();
        SendMessage sendMessage = createSendMessage(message, text);

        InlineKeyboardMarkup replyKeyboard = new InlineKeyboardMarkup();

        List<InlineKeyboardButton> row = new ArrayList<>();

        row.add(new InlineKeyboardButton().setText(ButtonText.CHANGE_LANGUAGE.getText()).setCallbackData("/language"));
        row.add(new InlineKeyboardButton().setText(ButtonText.CHANGE_TIMEZONE.getText()).setCallbackData("/timezone"));

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(row);

        replyKeyboard.setKeyboard(rows);
        sendMessage.setReplyMarkup(replyKeyboard);

        sendBaseMessage(sendMessage);
    }

    private void sendMessageWithLanguageAndTimeZoneSettings(Message message, String text, List<String> name, List<String> data) {
        SendMessage sendMessage = createSendMessage(message, text);

        InlineKeyboardMarkup replyKeyboard = new InlineKeyboardMarkup();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();

        row1.add(new InlineKeyboardButton().setText(name.get(0)).setCallbackData(data.get(0)));
        row2.add(new InlineKeyboardButton().setText(name.get(1)).setCallbackData(data.get(1)));
        row3.add(new InlineKeyboardButton().setText(name.get(2)).setCallbackData(data.get(2)));

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        replyKeyboard.setKeyboard(rows);
        sendMessage.setReplyMarkup(replyKeyboard);

        sendBaseMessage(sendMessage);
    }

    private String getTextOnSettings() {
        String language = Settings.getLanguage();
        String timeZone = Settings.getTimeZoneText();
        return "*Язык*: " + language + "\n*Таймзона*: " + timeZone;
    }

    private void getCreateRaffle(Message message) {
        SendMessage sendMessage = createSendMessage(message, ButtonText.RAFFLE_TEXT.getText());
        setButtonsBackPanel(sendMessage);
        sendBaseMessage(sendMessage);
    }

    private void setButtonsBackPanel(SendMessage message) {
        ReplyKeyboardMarkup replyKeyboard = new ReplyKeyboardMarkup();
        message.setReplyMarkup(replyKeyboard);
        replyKeyboard.setSelective(true);
        replyKeyboard.setResizeKeyboard(true);
        replyKeyboard.setOneTimeKeyboard(false);

        List<KeyboardRow> rows = new ArrayList<KeyboardRow>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton(ButtonText.BACK_TO_MENU.getText()));

        rows.add(row1);

        replyKeyboard.setKeyboard(rows);
    }

    private void createRuffle(Message message) {
        SendMessage sendMessage = createSendMessage(message, message.getText());
        createMainButtonPanel(sendMessage);
        createMessagePanel(message, "Что вы хотите изменить в розыгрыше?");
    }

    private void createMainButtonPanel(SendMessage message) {
        ReplyKeyboardMarkup replyKeyboard = new ReplyKeyboardMarkup();
        message.setReplyMarkup(replyKeyboard);
        replyKeyboard.setSelective(true);
        replyKeyboard.setResizeKeyboard(true);
        replyKeyboard.setOneTimeKeyboard(false);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton(ButtonText.CHANGE_TEXT.getText()));
        row1.add(new KeyboardButton(ButtonText.CHANGE_TIME.getText()));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton(ButtonText.CHANGE_TEXT_BUTTON.getText()));

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton(ButtonText.BACK_TO_MENU.getText()));
        row3.add(new KeyboardButton(ButtonText.PUBLICH_RUFFLE.getText()));

        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        replyKeyboard.setKeyboard(rows);
        sendBaseMessage(message);
    }

    private void createMessagePanel(Message message, String text) {
        SendMessage sendMessage = createSendMessage(message, text);

        InlineKeyboardMarkup replyKeyboard = new InlineKeyboardMarkup();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();

        row1.add(new InlineKeyboardButton().setText(ButtonText.MINUS_WINNERS.getText()).setCallbackData("minus"));
        row1.add(new InlineKeyboardButton().setText(ButtonText.PLUS_WINNERS.getText()).setCallbackData("plus"));

        row2.add(new InlineKeyboardButton().setText(ButtonText.CHECK_SUBSCRIPTION.getText()).setCallbackData("subcr"));

        row3.add(new InlineKeyboardButton().setText(ButtonText.CHANGE_CHANELL.getText()).setCallbackData("change"));

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        replyKeyboard.setKeyboard(rows);
        sendMessage.setReplyMarkup(replyKeyboard);

        sendBaseMessage(sendMessage);
    }

    private void createPanelManagedChanel(Message message) {
        String text = "Здесь ты можешь управлять добавленными каналами";
        SendMessage sendMessage = createSendMessage(message, text);

        InlineKeyboardMarkup replyKeyboard = new InlineKeyboardMarkup();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();

        row1.add(new InlineKeyboardButton().setText("Добавить чат").setCallbackData("1"));

        row2.add(new InlineKeyboardButton().setText("ИгроNews").setCallbackData("3"));

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);

        replyKeyboard.setKeyboard(rows);
        sendMessage.setReplyMarkup(replyKeyboard);

        sendBaseMessage(sendMessage);
    }
}
