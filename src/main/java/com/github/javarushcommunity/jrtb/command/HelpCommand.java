package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.javarushcommunity.jrtb.command.CommandName.*;

public class HelpCommand implements Command{
    public final static String HELP_MESSAGE = String.format("""
                    ✨<b>Available commands</b>✨

                    <b>To start\tor finish work with bot</b>
                    %s - to start work with me
                    %s - to pause work with me

                    %s - to get information about work with me
                    """,
            START.getCommand(), STOP.getCommand(), HELP.getCommand());

    private final SendBotMessageService sendBotMessageService;

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
