package com.tw.step;

public class CommandNotFoundException extends Throwable {
    public CommandNotFoundException() {
        super("NO SUCH COMMAND");
    }
}
