package com.tw.step;

public class  TurnLightOnCommand implements Command{

    private final SquareLight light;

    public TurnLightOnCommand(SquareLight light) {
        this.light = light;
    }


    @Override
    public void execute() {
        light.on();
    }
}
