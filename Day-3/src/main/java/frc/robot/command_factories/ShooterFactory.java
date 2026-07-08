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
        return shooter.runMotor(0.3);
    }

    public Command runMotorSlow() {
        return shooter.runMotor(Constants.ShooterConstants.SLOW_SPEED);
    }

    public Command doNothing() {
        return shooter.doNothing();
    }
}
