package frc.robot.command_factories;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class ShooterFactory {
    private final Shooter shooter;

    public ShooterFactory(Shooter subsystem) {
        shooter = subsystem;
    }

    public Command runMotor() {
        return shooter.runMotor();
    }

    // public Command runMotorSlow() {
    //     return shooter;
    // }

    public Command doNothing() {
        return shooter.doNothing();
    }
}
