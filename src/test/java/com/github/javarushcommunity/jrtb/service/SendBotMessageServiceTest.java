package com.github.javarushcommunity.jrtb.service;

import com.github.javarushcommunity.jrtb.bot.JavarushTelegramBot;
import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import com.github.javarushcommunity.jrtb.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit tests for SendBotMessageService")
public class SendBotMessageServiceTest {
    private SendBotMessageService botMessageService;
    private JavarushTelegramBot telegramBot;

    @BeforeEach
    public void init(){
        telegramBot = Mockito.mock(JavarushTelegramBot.class);
        botMessageService = new SendBotMessageServiceImpl(telegramBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        String chatId = "testChatId";
        String message = "testMessage";
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        botMessageService.sendMessage(chatId,message);

        Mockito.verify(telegramBot).execute(sendMessage);
    }
}
