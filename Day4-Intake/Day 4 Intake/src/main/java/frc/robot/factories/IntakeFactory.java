package frc.robot.factories;

import edu.wpi.first.wpilibj2.command.Command;

import static frc.robot.util.Constants.IntakeConstants.*;
import static frc.robot.util.Subsystems.intake;

public class IntakeFactory {

    public static Command exampleCommand() {
        return intake.exampleMethodCommand();
    }
}
