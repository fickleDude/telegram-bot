package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.bot.JavarushTelegramBot;
import com.github.javarushcommunity.jrtb.command.Command;
import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import com.github.javarushcommunity.jrtb.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract class AbstractCommandTest {
    protected JavarushTelegramBot telegramBot = Mockito.mock(JavarushTelegramBot.class);
    protected SendBotMessageService messageService = new SendBotMessageServiceImpl(telegramBot);

    abstract Command getCommand();
    abstract String getCommandName();
    abstract String getCommandMessage();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        Long chatId = 1718265932673L;
        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(this.getCommandName());
        update.setMessage(message);
        SendMessage sendMessage = Mockito.mock(SendMessage.class);
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(this.getCommandMessage());
        sendMessage.enableHtml(true);

        this.getCommand().execute(update);

        Mockito.verify(telegramBot).execute(sendMessage);
    }
}
