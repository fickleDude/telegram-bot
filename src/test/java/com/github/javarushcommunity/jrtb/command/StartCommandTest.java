package com.github.javarushcommunity.jrtb.command;

import static com.github.javarushcommunity.jrtb.command.CommandName.START;
import static com.github.javarushcommunity.jrtb.command.StartCommand.START_MESSAGE;

public class StartCommandTest extends AbstractCommandTest{
    @Override
    Command getCommand() {
        return new StartCommand(super.messageService);
    }

    @Override
    String getCommandName() {
        return START.getCommand();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }
}
