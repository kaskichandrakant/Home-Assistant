package com.tw.step;

import java.util.HashMap;

import static com.sun.tools.javadoc.Main.execute;

public class HomeAssistant {
    private HashMap<String, Command> commands;

    public HomeAssistant() {
        this.commands = new HashMap<>();
    }


    public void addCommand(String voiceCommand, Command command) {
        voiceCommand = voiceCommand.toLowerCase();
        commands.put(voiceCommand,command);
    }


    public void listen(String voiceCommand) throws CommandNotFoundException {
        voiceCommand = voiceCommand.toLowerCase();
        Command command = commands.get(voiceCommand);
        if(command == null){
            throw new CommandNotFoundException();
        }
        command.execute();
    }
}
