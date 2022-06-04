package com.github.javarushcommunity.jrtb.command;

import static com.github.javarushcommunity.jrtb.command.CommandName.NO;
import static com.github.javarushcommunity.jrtb.command.NoCommand.NO_MESSAGE;

public class NoCommandTest extends AbstractCommandTest{
    @Override
    Command getCommand() {
        return new NoCommand(super.messageService);
    }

    @Override
    String getCommandName() {
        return NO.getCommand();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }
}
