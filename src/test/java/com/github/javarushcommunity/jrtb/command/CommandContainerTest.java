package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.command.Command;
import com.github.javarushcommunity.jrtb.command.CommandContainer;
import com.github.javarushcommunity.jrtb.command.CommandName;
import com.github.javarushcommunity.jrtb.command.UnknownCommand;
import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import com.github.javarushcommunity.jrtb.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit tests for CommandContainer")
public class CommandContainerTest {
    private CommandContainer commandContainer;

    @BeforeEach
    public void init(){
        SendBotMessageService service = Mockito.mock(SendBotMessageServiceImpl.class);
        commandContainer = new CommandContainer(service);
    }

    @Test
    public void shouldReturnAllTheExistingCommands(){
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {Command command =
                        commandContainer.retrieveCommand(commandName.getCommand());
                    Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
                });
    }

    @Test
    public void shouldReturnUnknownCommand(){
        String unknownCommand = "/abrakadabra";

        Command command = commandContainer.retrieveCommand(unknownCommand);

        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }

}
