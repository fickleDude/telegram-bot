package com.github.javarushcommunity.jrtb.service;

import com.github.javarushcommunity.jrtb.bot.JavarushTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService{
    private final JavarushTelegramBot telegramBot;

    @Autowired
    public SendBotMessageServiceImpl(JavarushTelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @Override
    public void sendMessage(String chadId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chadId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try{
            telegramBot.execute(sendMessage);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
