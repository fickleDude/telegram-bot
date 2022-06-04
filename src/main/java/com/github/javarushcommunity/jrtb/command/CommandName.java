package com.github.javarushcommunity.jrtb.command;

public enum CommandName {
    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("nocommand");

    private final String command;

    CommandName(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
