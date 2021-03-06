package bot;

import base.H2;
import dictionary.AlertText;
import dictionary.RuffleText;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.CallbackQuery;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import time.SchedulerMessage;
import utils.Settings;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Bot extends TelegramLongPollingBot {

    private final long CHAT_ID_1 = -1001461357622L;
    private final long CHAT_ID_2 = -1001167513241L;
    private final String CHAT_NAME_1 = "Вокабуля́рий";
    private final String CHAT_NAME_2 = "Программистка";

    public static void main(String[] args) {
        ApiContextInitializer.init();
        Timer time = new Timer();
        SchedulerMessage st = new SchedulerMessage();
        time.schedule(st, 0, 1000);
        TelegramBotsApi botsApi = new TelegramBotsApi();
        Settings.getInstance().setChat1MessageId(561);
        Settings.getInstance().setChat2MessageId(380);
        try {
            botsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) { //ToDo прикрутить логирование
            e.printStackTrace();
        }

    }

    public void onUpdateReceived(Update update) {
        H2 base = H2.getInstance();
        CallbackQuery callbackQuery = update.getCallbackQuery();
        if (callbackQuery != null) {
            if (callbackQuery.getData().equals("/participate")) {
                Integer userId = callbackQuery.getFrom().getId();
                Long chatId = callbackQuery.getMessage().getChatId();
                AnswerCallbackQuery answer = new AnswerCallbackQuery();
                answer.setCallbackQueryId(callbackQuery.getId());

                if (chatId == CHAT_ID_1) {
                    if (!checkSignOnFirstChanell(answer, userId)) {
                        return;
                    }
                    if (!checkSignOnSecondChanell(answer, userId)) {
                        return;
                    }
                }

                if (chatId == CHAT_ID_2) {
                    if (!checkSignOnSecondChanell(answer, userId)) {
                        return;
                    }
                    if (!checkSignOnFirstChanell(answer, userId)) {
                        return;
                    }
                }

                if (base.isExitUsername(userId)) {
                    answer.setText(AlertText.YET_PARTICIPATE.getText());
                    sendBaseAnswer(answer);
                } else {
                    answer.setText(AlertText.START_PARTICIPATE.getText());
                    sendBaseAnswer(answer);
                    base.insertUsername(userId);
                    sendEditMessage();
                }
            }
        } else {
            Message message = update.getMessage();
            if (message != null) {
                SendMessage sendMessage = createSendMessage(message);
                sendMessage.setText("Hello, it is a test");
                sendBaseMessage(sendMessage);
            }
        }
    }


    public String getBotUsername() {
        return "Jhony_pirat_bot";
    }

    public String getBotToken() {
        return "1288138052:AAFou7f9ij20NBGbbII6C-2z33f35O2Id_w";
    }

//    private void sendMessage(Message message, String text) {
//        SendMessage sendMessage = createSendMessage(message, text);
//        sendBaseMessage(sendMessage);
//    }
//
//    private void sendMessageInOtherChat(Long id, String text) {
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.enableMarkdown(true);
//        sendMessage.setChatId(id);
//        sendMessage.setText(text);
//        sendBaseMessage(sendMessage);
//    }

    private void sendBaseMessage(SendMessage sendMessage) {
        try {
            sendApiMethod(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendBaseAnswer(AnswerCallbackQuery answer) {
        try {
            answerCallbackQuery(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

//    private SendMessage createSendMessage(Message message, String text) {
//        SendMessage sendMessage = createSendMessage(message);
//        sendMessage.setText(text);
//        return sendMessage;
//    }


    private SendMessage createSendMessage(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId());
        return sendMessage;
    }

    public void sendEndMessage() {
        EditMessageText new_message = new EditMessageText()
                .setText(RuffleText.END_RUFFLE.getText())
                .enableMarkdown(true)
                .disableWebPagePreview();

        new_message.setChatId(CHAT_ID_1);
        new_message.setMessageId(Settings.getInstance().getChat1MessageId());
        try {
            execute(new_message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        new_message.setChatId(CHAT_ID_2);
        new_message.setMessageId(Settings.getInstance().getChat2MessageId());
        try {
            execute(new_message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private boolean checkUserIsSigned(Integer userId, long chatId) {
        String status = "";
        GetChatMember chatMember = new GetChatMember();
        chatMember.setChatId(chatId);
        chatMember.setUserId(userId);
        try {
            status = execute(chatMember).getStatus();
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return status.equals("member");
    }

    private void sendEditMessage() {
        EditMessageText new_message = new EditMessageText()
                .setText(RuffleText.START_RUFFLE.getText())
                .enableMarkdown(true)
                .disableWebPagePreview();

        InlineKeyboardMarkup replyKeyboard = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(new InlineKeyboardButton().setText(getRuffleButtonText()).setCallbackData("/participate"));
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(row);
        replyKeyboard.setKeyboard(rows);
        new_message.setReplyMarkup(replyKeyboard);

        new_message.setChatId(CHAT_ID_1);
        new_message.setMessageId(Settings.getInstance().getChat1MessageId());
        try {
            execute(new_message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        new_message.setChatId(CHAT_ID_2);
        new_message.setMessageId(Settings.getInstance().getChat2MessageId());
        try {
            execute(new_message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private String getRuffleButtonText() {
        H2 base = H2.getInstance();
        int count = base.getCountParticipant();
        return "(" + count + ")" + RuffleText.TAKE_PARTICIPANT.getText();
    }

    private boolean checkSignOnFirstChanell(AnswerCallbackQuery answer, Integer userId) {
        if (!checkUserIsSigned(userId, CHAT_ID_1)) {
            answer.setText(AlertText.NOT_SIGNED.getText() + CHAT_NAME_1);
            sendBaseAnswer(answer);
            return false;
        }
        return true;
    }

    private boolean checkSignOnSecondChanell(AnswerCallbackQuery answer, Integer userId) {
        if (!checkUserIsSigned(userId, CHAT_ID_2)) {
            answer.setText(AlertText.NOT_SIGNED.getText() + CHAT_NAME_2);
            sendBaseAnswer(answer);
            return false;
        }
        return true;
    }
}
