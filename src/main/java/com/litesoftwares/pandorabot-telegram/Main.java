package com.litesoftwares;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi();
            botsApi.registerBot(new TelegramBot());
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
