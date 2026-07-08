package frc.robot.command_factories;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LEDs;

public class LEDFactory {

    private final LEDs LED;
    
    public LEDFactory(LEDs subsystem) {
        LED = subsystem;
    }

    public Command turnLEDsWhite() {
        return LED.colorCommand(0, 0, 0);
    }

    public Command turnLEDsOrange() {
        return LED.colorCommand(0, 0, 0);
    }

    public Command turnLEDsPurple() {
        return LED.colorCommand(128, 0, 128);
    }
}
