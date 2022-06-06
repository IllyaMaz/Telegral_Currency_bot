import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "UckraineCurrencyBot";
}

    @Override
    public String getBotToken() {
        return "5562043722:AAHHPtVmgOr9fmGwvK_8MYcUKsU1Mhrlg1A";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            String message = update.getMessage().getText();
            sendMsg(update.getMessage().getChatId().toString(),message);
        }
    }

    public synchronized void sendMsg(String chatId, String string){

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(string);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            //todo add log
            e.printStackTrace();
        }
    }
}
