package frc.robot.command_factories;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;
import static frc.robot.SubsystemContainer.*;

public class ShooterFactory {
    private final Shooter m_shooter;

    public ShooterFactory(Shooter subsystem) {
        m_shooter = subsystem;
    }

    public Command runMotor() {
        return m_shooter.runMotor();
    }

    // public Command runMotorSlow() {
    //     return shooter;
    // }

    public Command doNothing() {
        return m_shooter.doNothing();
    }
}
