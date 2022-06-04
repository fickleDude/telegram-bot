package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;
import static com.github.javarushcommunity.jrtb.command.CommandName.*;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandContainer;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService service) {
        commandContainer = ImmutableMap.<String, Command>builder()
        .put(START.getCommand(), new StartCommand(service))
        .put(STOP.getCommand(), new StopCommand(service))
        .put(HELP.getCommand(), new HelpCommand(service))
        .put(NO.getCommand(), new NoCommand(service))
                .build();
        unknownCommand = new UnknownCommand(service);
    }

    public Command retrieveCommand(String commandIdentifier){
        return commandContainer.getOrDefault(commandIdentifier, unknownCommand);
    }
}
