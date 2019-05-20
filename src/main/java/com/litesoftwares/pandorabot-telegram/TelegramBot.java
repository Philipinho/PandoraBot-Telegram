package com.litesoftwares;

import com.litesoftwares.utils.ReadProperty;
import com.litesoftwares.utils.Utils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBot extends TelegramLongPollingBot {
    private SendMessage sendMessage = new SendMessage();
    @Override
    public void onUpdateReceived(Update update){
        try {
            if(update.hasMessage() && update.getMessage().getText().equalsIgnoreCase("/start")){

                sendMessage
                        .enableMarkdown(true)
                        .setChatId(update.getMessage().getChatId())
                        .setText("Hi, @" + update.getMessage().getChat().getUserName() + ".");
            }

            else if (update.hasMessage() && update.getMessage().hasText() ) {
                PandoraBot bot = new PandoraBot(update.getMessage().getChatId().toString());

                String response = bot.response(update.getMessage().getText());

                sendMessage
                        .enableHtml(true)
                        .setChatId(update.getMessage().getChatId())
                        .setText(response);
            }

            execute(sendMessage);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotToken(){
        return ReadProperty.getValue("telegram.bot.token");
    }

    @Override
    public String getBotUsername(){
        return ReadProperty.getValue("telegram.bot.username");
    }
}
