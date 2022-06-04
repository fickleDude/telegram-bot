package com.github.javarushcommunity.jrtb.command;

import static com.github.javarushcommunity.jrtb.command.HelpCommand.*;

import static com.github.javarushcommunity.jrtb.command.CommandName.*;

public class HelpCommandTest extends AbstractCommandTest{
    @Override
    Command getCommand() {
        return new HelpCommand(super.messageService);
    }

    @Override
    String getCommandName() {
        return HELP.getCommand();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }
}
