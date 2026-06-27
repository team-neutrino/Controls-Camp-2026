package frc.robot.factories;

import edu.wpi.first.wpilibj2.command.Command;

import static frc.robot.util.Constants.IntakeConstants.*;
import static frc.robot.util.Subsystems.intake;

public class IntakeFactory {
    public static Command runIntakeCommand() {
        return intake.runIntake(INTAKE_VOLTAGE);
    }

    public static Command runOuttake() {
        return intake.runIntake(OUTTAKE_VOLTAGE);
    }

    public static Command deployIntakeCommand() {
        return intake.deployIntake();
    }

    public static Command retractIntakeCommand() {
        return intake.retractIntake();
    }

    public static Command toggleIntakeCommand() {
        return intake.toggleIntake();
    }
}
