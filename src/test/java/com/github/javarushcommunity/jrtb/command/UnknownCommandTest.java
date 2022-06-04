package com.github.javarushcommunity.jrtb.command;

import static com.github.javarushcommunity.jrtb.command.UnknownCommand.UNKNOWN_MESSAGE;

public class UnknownCommandTest extends AbstractCommandTest{
    @Override
    Command getCommand() {
        return new UnknownCommand(super.messageService);
    }

    @Override
    String getCommandName() {
        return "/abrakadabra";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }
}
