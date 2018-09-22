package com.tw.step;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class HomeAssistantTest {

    private HomeAssistant homeAssistant;

    @Before
    public void setUp() {
        homeAssistant = new HomeAssistant();
    }

    @Test
    public void shouldTurnOnLight() throws CommandNotFoundException {
        SquareLight light = mock(SquareLight.class);
        homeAssistant.addCommand("Turn on light",new TurnLightOnCommand(light));
        homeAssistant.listen("Turn on light");
        verify(light).on();
    }

    @Test
    public void shouldTurnOffLight() throws CommandNotFoundException {
        Command turnLightOffCommand = mock(Command.class);
        homeAssistant.addCommand("Turn off light",turnLightOffCommand);
        homeAssistant.listen("Turn off light");
        verify(turnLightOffCommand).execute();
    }

    @Test
    public void shouldListenCommandIgnoringCaseSensitivity() throws CommandNotFoundException {
        Command turnOffLight = mock(Command.class);
        homeAssistant.addCommand("Turn off light",turnOffLight);
        homeAssistant.listen("Turn off light");
        homeAssistant.listen("TURN OFF LIGHT");
        verify(turnOffLight,times(2)).execute();
    }

    @Test (expected = CommandNotFoundException.class)
    public void shouldThrowExceptionForUnknownCommand() throws CommandNotFoundException {
        homeAssistant.listen("unknown command");
    }

    @Test
    public void shouldIncreaseTheVolumeOfHomeTheater() throws CommandNotFoundException {
        HomeTheatre homeTheatre = mock(HomeTheatre.class);
        homeAssistant.addCommand("increase volume",()->homeTheatre.volumeUp());
        homeAssistant.listen("increase volume");
        verify(homeTheatre).volumeUp();
    }

    @Test
    public void shouldDecreaseTheVolumeOfHomeTheater() throws CommandNotFoundException {
        HomeTheatre homeTheatre = mock(HomeTheatre.class);
        homeAssistant.addCommand("decrease volume",()->homeTheatre.volumeDown());
        homeAssistant.listen("decrease volume");
        verify(homeTheatre).volumeDown();
    }

}
